package org.server.disruptor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.server.disruptor.model.PublishMessageEntity;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

/**
 * Disruptor初始化.
 * 
 * @author 创建者:刘源
 */

public class DisruptorUtil {

	public DisruptorUtil() {

	}

	/**
	 * 指定环形缓冲器的大小，必须是2的幂.
	 */
	private static final int BUFFER_SIZE = 1024 * 4;
	/**
	 * ringbuffer是整个模式（Disruptor）的核心.
	 */
	private static final RingBuffer<ValueEvent> ringBuffer;
	static {
		Executor executor = Executors.newCachedThreadPool();
		Disruptor<ValueEvent> disruptor = new Disruptor<ValueEvent>(ValueEvent.EVENT_FACTORY, BUFFER_SIZE, executor,
				ProducerType.SINGLE, new YieldingWaitStrategy());
		disruptor.handleEventsWith(new DisruptorEventHandle());
		disruptor.start();
		ringBuffer = disruptor.getRingBuffer();
	}

	/**
	 * 
	 * 向Disruptor中发布信息.
	 * 
	 * @param entity
	 *            方法添加日期: 2014年10月10日 创建者:刘源
	 */
	public static void publish(PublishMessageEntity entity) {
		ringBuffer.publishEvent(ProducerTranslator.TRANSLATOR, entity);
	}
}
