package org.server.netty.handler;

import io.netty.handler.traffic.GlobalTrafficShapingHandler;
import io.netty.handler.traffic.TrafficCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by spirit on 2014-10-15.
 */
public class GlobalTrafficCounterHandler extends GlobalTrafficShapingHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonHandler.class);
    public GlobalTrafficCounterHandler(ScheduledExecutorService executor, long checkInterval) {
        super(executor, checkInterval);
    }

    @Override
    protected void doAccounting(TrafficCounter counter) {
        LOGGER.debug(String.format("========写入数据[%d] Bytes, 读取数据[%d] Bytes, %s=======",
                trafficCounter().cumulativeWrittenBytes(), trafficCounter().cumulativeReadBytes(), super.toString()));
    }
}
