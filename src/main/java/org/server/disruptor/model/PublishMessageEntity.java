package org.server.disruptor.model;

import io.netty.channel.ChannelHandlerContext;

/**
 * 向Disruptor中发布的消息Bean.
 * 
 * @author 刘源
 */

public class PublishMessageEntity {

	public PublishMessageEntity() {

	}

	/**
	 * Netty上下文(可用来操作Netty管道).
	 */
	private ChannelHandlerContext ctx;
	/**
	 * 消息体.
	 */
	private Object msg;

	public PublishMessageEntity(ChannelHandlerContext ctx, Object msg) {
		this.ctx = ctx;
		this.msg = msg;
	}

	/**
	 * 
	 * 获得Netty上下文.
	 * 
	 * 方法添加日期: 2014年10月10日 创建者:刘源
	 * 
	 * @return Netty上下文
	 */
	public ChannelHandlerContext getCtx() {
		return ctx;
	}

	/**
	 * 
	 * 放入Netty上下文.
	 * 
	 * 方法添加日期: 2014年10月10日 创建者:刘源
	 * 
	 * @param ctx
	 *            Netty上下文
	 */
	public void setCtx(ChannelHandlerContext ctx) {
		this.ctx = ctx;
	}

	/**
	 * 
	 * 获得消息体.
	 * 
	 * 方法添加日期: 2014年10月10日 创建者:刘源
	 * 
	 * @return Object 任意对象
	 */
	public Object getMsg() {
		return msg;
	}

	/**
	 * 
	 * 设置消息体.
	 * 
	 * 方法添加日期：2014-10-11 <br>
	 * 创建者:刘源
	 * 
	 * @param msg  任意对象
	 */
	public void setMsg(Object msg) {
		this.msg = msg;
	}

}
