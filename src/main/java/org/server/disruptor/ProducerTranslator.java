package org.server.disruptor;

import org.server.disruptor.model.PublishMessageEntity;

import com.lmax.disruptor.EventTranslatorOneArg;

/**
 * 生产者Translator对象.
 * 
 * @author 创建者:刘源
 */

public class ProducerTranslator {

	public ProducerTranslator() {

	}

	public static final EventTranslatorOneArg<ValueEvent, PublishMessageEntity> TRANSLATOR = new EventTranslatorOneArg<ValueEvent, PublishMessageEntity>() {
		/**
		 * 
		 * 用于向载体中填充内容.
		 * 
		 * @param event
		 *            消息载体
		 * @param sequence
		 * @param arg0
		 *            消息体
		 *            方法添加日期 :2014年10月9日<br>
		 *            创建者:刘源
		 */
		@Override
		public void translateTo(ValueEvent event, long sequence, PublishMessageEntity arg0) {
			event.setEntity(arg0);
		}
	};

}
