package org.server.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import org.server.disruptor.DisruptorUtil;
import org.server.disruptor.model.PublishMessageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 自定义编码器.
 * 
 * @author 刘源
 */
public class MessageEncoder extends MessageToByteEncoder<Object> {
	/**
	 * 日志组件.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageEncoder.class);

	public MessageEncoder() {

	}

	/**
	 * 
	 * 编码.
	 * 
	 * @param ctx
	 *            Netty上下文
	 * @param msg
	 *            信息实体
	 * @param out 缓冲区
	 * 
	 *             方法添加日期 :2014-10-11<br>
	 *             创建者:刘源
	 */
	@Override
	protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out)  {
		//LOGGER.info(String.format("[%s]发送出的报文:[%s]", ctx.channel().id().asLongText(), ByteBufUtil.hexDump((byte[]) msg)));
        PublishMessageEntity log = new PublishMessageEntity(ctx, String.format("[%s]发送出的报文:[%s]", ctx.channel().id().asLongText(), ByteBufUtil.hexDump((byte[])msg)));
        DisruptorUtil.publish(log);
		out.writeBytes((byte[]) msg);
	}
}
