/****************************************************************
 *文件名: 类名.java <br>
 *版本: <br>
 *描述: 相关描述<br>
 *版权所有: <br>
 *创建者: 刘源 <br>
 *创建日期: 2016年7月7日 <br>
 *修改者: 刘源<br>
 *修改日期: 2016年7月7日<br>
 *修改说明: 修改说明<br>
 ****************************************************************/

package org.test.reconnect;

import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {

	private EventLoopGroup loop = new NioEventLoopGroup();
	private ChannelFuture channelFuture;
	private String host;
	private int port;

	public Bootstrap createBootstrap(Bootstrap bootstrap, EventLoopGroup eventLoop) {

		if (bootstrap != null) {
			bootstrap.group(eventLoop);
			bootstrap.channel(NioSocketChannel.class);
			bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
			bootstrap.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel socketChannel) throws Exception {
					socketChannel.pipeline().addLast(new ClientHandler(Client.this));
				}
			});
			bootstrap.remoteAddress(host, port);
			channelFuture = bootstrap.connect();
			channelFuture.addListener(new ChannelFutureListener() {
				@Override
				public void operationComplete(ChannelFuture future) throws Exception {
					if (!future.isSuccess()) {
						System.out.println("Reconnect");
						final EventLoop loop = future.channel().eventLoop();
						loop.schedule(new Runnable() {
							@Override
							public void run() {
								Client.this.createBootstrap(new Bootstrap(), loop);
							}
						}, 1L, TimeUnit.SECONDS);
					}
				}
			});
		}
		return bootstrap;
	}

	public void connect(String host, int port) {
		this.host = host;
		this.port = port;
		createBootstrap(new Bootstrap(), loop);
	}

	public ChannelFuture getChannelFuture() {
		return channelFuture;
	}

	public void sendMessage(Object msg) {
		channelFuture.channel().writeAndFlush(msg);
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

}
