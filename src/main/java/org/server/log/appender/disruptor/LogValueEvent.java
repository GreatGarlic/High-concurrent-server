package org.server.log.appender.disruptor;

import org.server.log.appender.disruptor.model.LogPublishMessageEntity;

import com.lmax.disruptor.EventFactory;

/**
 * Disruptor生产者传递到消费者内容的载体.
 * 
 * @author 创建者:刘源
 */

public class LogValueEvent {
	public LogValueEvent() {

	}
	private LogPublishMessageEntity entity;
	
	public LogPublishMessageEntity getEntity() {
		return entity;
	}
	public void setEntity(LogPublishMessageEntity entity) {
		this.entity = entity;
	}
	/**
	 * 由于需要让Disruptor为我们创建事件，我们同时还声明了一个EventFactory来实例化Event对象.
	 */
	public final static EventFactory<LogValueEvent> EVENT_FACTORY = new EventFactory<LogValueEvent>() {
		@Override
		public LogValueEvent newInstance() {
			return new LogValueEvent();
		}
	};

}
