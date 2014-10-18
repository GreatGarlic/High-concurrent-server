package org.server.log.appender.disruptor.model;

import ch.qos.logback.core.spi.AppenderAttachableImpl;

/**
 * 向Disruptor中发布的消息Bean.
 * 
 * @author 刘源
 */

public class LogPublishMessageEntity <E>{

	private E eventObject;

	
	private AppenderAttachableImpl<E> parent;
	
	public E getEventObject() {
		return eventObject;
	}

	public void setEventObject(E eventObject) {
		this.eventObject = eventObject;
	}


	public AppenderAttachableImpl<E> getParent() {
		return parent;
	}

	public void setParent(AppenderAttachableImpl<E> parent) {
		this.parent = parent;
	}
	public LogPublishMessageEntity(E eventObject,AppenderAttachableImpl<E> parent) {
		this.eventObject = eventObject;
		this.parent = parent;
	}

}
