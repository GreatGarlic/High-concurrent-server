package org.server.disruptor;

import io.netty.channel.ChannelHandlerContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;

/**
 * 消费者处理类.
 * 
 * @author 创建者:刘源
 */

public class DisruptorEventHandle implements EventHandler<ValueEvent> {

	public DisruptorEventHandle() {

	}
	/**
	 * 调试日志.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(DisruptorEventHandle.class);

	/**
	 * 
	 * 处理消费者要做的事.
	 * 
	 * @param event
	 *            event published to the {@link RingBuffer}
	 * @param sequence
	 *            sequence of the event being processed
	 * @param endOfBatch
	 *            endOfBatch flag to indicate if this is the last event in a batch from the {@link RingBuffer} ·
	 * 
	 *            方法添加日期 :2014年10月8日<br>
	 *            创建者:刘源
	 */
	@Override
	public void onEvent(ValueEvent event, long sequence, boolean endOfBatch) {
		try {
			ChannelHandlerContext ctx = event.getEntity().getCtx();
			//LOGGER.debug("消费者开始消费ID:"+ctx.channel().id().asLongText());
			Object msg =  event.getEntity().getMsg();
            LOGGER.debug(msg.toString());
			//ctx.writeAndFlush(msg);
		} catch (Exception e) {
			LOGGER.error("消费异常:", e);
		}

	}

}
