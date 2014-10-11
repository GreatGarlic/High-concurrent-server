package org.server.disruptor;

import org.server.disruptor.model.PublishMessageEntity;

import com.lmax.disruptor.EventFactory;

/**
 * Disruptor生产者传递到消费者内容的载体.
 * 
 * @author 创建者:刘源
 */

public class ValueEvent {
	public ValueEvent() {

	}
	/**
	 * 消息.
	 */
	private PublishMessageEntity entity;
	
	/**
	 * 
	*获得消息.
	* @return
	*方法添加日期：2014-10-11 <br>
	*创建者:刘源
	 */
	public PublishMessageEntity getEntity() {
		return entity;
	}
	/**
	 * 
	*存储消息.
	* @param entity
	*方法添加日期：2014-10-11 <br>
	*创建者:刘源
	 */
	public void setEntity(final PublishMessageEntity entity) {
		this.entity = entity;
	}
	/**
	 * 由于需要让Disruptor为我们创建事件，我们同时还声明了一个EventFactory来实例化Event对象.
	 */
	public final static EventFactory<ValueEvent> EVENT_FACTORY = new EventFactory<ValueEvent>() {
		@Override
		public ValueEvent newInstance() {
			return new ValueEvent();
		}
	};

}
