package org.server.log.appender.disruptor;

import org.server.log.appender.disruptor.model.LogPublishMessageEntity;

import ch.qos.logback.classic.spi.ILoggingEvent;

import com.lmax.disruptor.EventTranslatorOneArg;

/**
 * 生产者Translator对象.
 * 
 * @author 创建者:刘源
 */

public class LogProducerTranslator {

	public LogProducerTranslator() {

	}
	
	public static final EventTranslatorOneArg<LogValueEvent, LogPublishMessageEntity> TRANSLATOR = new EventTranslatorOneArg<LogValueEvent, LogPublishMessageEntity>() {
		@Override
		public void translateTo(LogValueEvent event, long sequence,
				LogPublishMessageEntity arg0) {
			event.setEntity(arg0);
		};
	};

}
