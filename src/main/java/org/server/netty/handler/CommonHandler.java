package org.server.netty.handler;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import io.netty.handler.traffic.ChannelTrafficShapingHandler;
import org.server.disruptor.DisruptorUtil;
import org.server.disruptor.model.PublishMessageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Netty业务逻辑处理器(Disruptor的生产者).
 * 
 * @author 刘源
 */

public class CommonHandler extends ChannelHandlerAdapter {
	/**
	 * 日志组件.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonHandler.class);

	public CommonHandler() {

	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		LOGGER.debug(String.format("[%s]========打开连接=======", ctx.channel().id().asLongText()));
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {

	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		PublishMessageEntity entity = new PublishMessageEntity(ctx, msg);
		//向Disruptor中发布消息
		//DisruptorUtil.publish(entity);

        ctx.writeAndFlush(msg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		LOGGER.error("[" + ctx.channel().id().asLongText() + "]" + "通讯异常:", cause);
	}
}
