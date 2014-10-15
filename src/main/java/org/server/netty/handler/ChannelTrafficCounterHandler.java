package org.server.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.traffic.ChannelTrafficShapingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by spirit on 2014-10-15.
 */
public class ChannelTrafficCounterHandler extends ChannelTrafficShapingHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonHandler.class);

    public ChannelTrafficCounterHandler(long checkInterval) {
        super(checkInterval);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        long writeBytes = this.trafficCounter().cumulativeWrittenBytes();

        LOGGER.debug(String.format("[%s]========写入数据[%d] Bytes, 读取数据[%d] Bytes=======",
                ctx.channel().id().asLongText(),writeBytes, trafficCounter().cumulativeReadBytes()));
    }
}
