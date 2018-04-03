package com.yooeee.id.gen.common;

/**
 * @author Administrator
 * @date 2018/4/2
 */
public final class TimeUtil {


    public static long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }


}
