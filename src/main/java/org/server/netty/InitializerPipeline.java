/****************************************************************
 *文件名: 类名.java <br>
 *版本: <br>
 *描述: 相关描述<br>
 *版权所有: <br>
 *创建者: 刘源 <br>
 *创建日期: 2014年7月4日 <br>
 *修改者: 刘源<br>
 *修改日期: 2014年7月4日<br>
 *修改说明: 修改说明<br>
 ****************************************************************/

package org.server.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

import io.netty.handler.traffic.ChannelTrafficShapingHandler;
import io.netty.handler.traffic.GlobalTrafficShapingHandler;
import io.netty.util.HashedWheelTimer;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import org.server.netty.codec.MessageDecoder;
import org.server.netty.codec.MessageEncoder;
import org.server.netty.handler.ChannelTrafficCounterHandler;
import org.server.netty.handler.CommonHandler;
import org.server.netty.handler.GlobalTrafficCounterHandler;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 *装载Netty处理链路.
 * @author 刘源
 */

public class InitializerPipeline extends ChannelInitializer<SocketChannel> {
    private GlobalTrafficCounterHandler counter;
    private EventExecutorGroup eventExecutorGroup;
	public InitializerPipeline() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        counter = new GlobalTrafficCounterHandler(executor, 1000);
        eventExecutorGroup = new DefaultEventExecutorGroup(32);
	}

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
        ChannelTrafficCounterHandler trafficCounterHandler = new ChannelTrafficCounterHandler(50);

		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast("decoder", new MessageDecoder());
        //pipeline.addLast("trafficCounter", trafficCounterHandler);
        pipeline.addLast("globalCounter", counter);
        pipeline.addLast("encoder", new MessageEncoder());
		pipeline.addLast("handler", new CommonHandler());
	}
}
