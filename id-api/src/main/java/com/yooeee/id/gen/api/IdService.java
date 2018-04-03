package com.yooeee.id.gen.api;

import com.yooeee.id.gen.OrderTypeEnum;

/**
 * @author Administrator
 * @date 2018/4/2.
 */
public interface IdService {

    /**
     * 根据uid,orderType 生成id
     * @param uid
     * @param orderTypeEnum
     * @return
     */
    public long getId(String uid, OrderTypeEnum orderTypeEnum);

}
