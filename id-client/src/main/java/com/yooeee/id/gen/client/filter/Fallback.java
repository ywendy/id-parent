package com.yooeee.id.gen.client.filter;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author Administrator
 * @date 2018/4/3
 */
@SPI
public interface Fallback {
    Object invoke();
}
