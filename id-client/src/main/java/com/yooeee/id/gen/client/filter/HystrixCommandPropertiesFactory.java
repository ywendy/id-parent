package com.yooeee.id.gen.client.filter;

import com.alibaba.dubbo.common.URL;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * @author Administrator
 * @date 2018/4/3
 */
public class HystrixCommandPropertiesFactory {


    public static HystrixCommandProperties.Setter create(URL url) {
        return HystrixCommandProperties.Setter().withCircuitBreakerSleepWindowInMilliseconds(url.getParameter("sleepWindowInMilliseconds", 5000))
                .withCircuitBreakerErrorThresholdPercentage(url.getParameter("errorThresholdPercentage", 50))
                .withCircuitBreakerRequestVolumeThreshold(url.getParameter("requestVolumeThreshold", 20))
                .withExecutionIsolationThreadInterruptOnTimeout(true)
                .withExecutionTimeoutInMilliseconds(url.getParameter("timeoutInMilliseconds", 1000));
    }
}
