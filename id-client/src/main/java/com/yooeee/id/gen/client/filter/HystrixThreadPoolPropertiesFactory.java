package com.yooeee.id.gen.client.filter;

import com.alibaba.dubbo.common.URL;
import com.netflix.hystrix.HystrixThreadPoolProperties;

/**
 * @author Administrator
 * @date 2018/4/3
 */
public class HystrixThreadPoolPropertiesFactory {


    public static HystrixThreadPoolProperties.Setter create(URL url) {
        return HystrixThreadPoolProperties.Setter().withCoreSize(url.getParameter("coreSize", 10))
                .withAllowMaximumSizeToDivergeFromCoreSize(true)
                .withMaximumSize(url.getParameter("maximumSize", 20))
                .withMaxQueueSize(-1)
                .withKeepAliveTimeMinutes(url.getParameter("keepAliveTimeMinutes", 1));
    }

}



