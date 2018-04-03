package com.yooeee.id.gen.common;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Administrator
 * @date 2018/4/3
 */
public class ThreadFactoryImpl implements ThreadFactory {

    private final String threadNamePrefix;
    private final AtomicLong threadIndex = new AtomicLong(0);


    public ThreadFactoryImpl(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r,threadNamePrefix+this.threadIndex.incrementAndGet());
    }
}
