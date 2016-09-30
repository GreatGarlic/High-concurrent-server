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
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 类的相关描述
 */

public class ClientHandler extends SimpleChannelInboundHandler<Object> {

	private Client client;

	public ClientHandler(Client client) {
		this.client = client;
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		final EventLoop eventLoop = ctx.channel().eventLoop();
		eventLoop.schedule(new Runnable() {
			@Override
			public void run() {
				client.createBootstrap(new Bootstrap(), eventLoop);
			}
		}, 1L, TimeUnit.SECONDS);
		super.channelInactive(ctx);
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

	}

}
