package com.yooeee.id.gen.client.filter;

import com.alibaba.dubbo.common.URL;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 * @date 2018/4/3
 */
public class SetterFactory {
    private static ConcurrentHashMap<String, HystrixCommand.Setter> setterMap = new ConcurrentHashMap<>();

    public static HystrixCommand.Setter create(String interfaceName, String methodName, URL url) {

        String key = String.format("%s.%s", interfaceName, methodName);
        if (setterMap.containsKey(key)) {
            return setterMap.get(key);
        } else {
            setterMap.putIfAbsent(key, doCreate(interfaceName, methodName, url));
            return setterMap.get(key);
        }
    }

    private static HystrixCommand.Setter doCreate(String interfaceName, String methodName, URL url) {
        //线程池按class进行划分，一个class可以理解为一个领域服务，熔断保护按方法维度提供
        return HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(interfaceName))
                .andCommandKey(HystrixCommandKey.Factory.asKey(methodName))
                .andCommandPropertiesDefaults(HystrixCommandPropertiesFactory.create(url))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolPropertiesFactory.create(url));
    }


}
