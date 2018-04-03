package com.yooeee.id.gen.service;

import com.yooeee.id.gen.OrderTypeEnum;
import com.yooeee.id.gen.api.IdService;
import com.yooeee.id.gen.common.Constants;
import com.yooeee.id.gen.common.TimeUtil;

/**
 * @author Administrator
 * @date 2018/4/2
 */
public class IdServiceImpl implements IdService {

    private int appId;
    private int env;


    private long lastTimestamp = -1L;
    private long sequence = 0L;

    public IdServiceImpl(int appId, int env) {

        init(appId, env);

    }

    private void init(int appId, int env) {
        if (appId > Constants.APP_MAX || appId < Constants.MIN) {
            appId = 0;
        }

        this.appId = appId;

        if (env > Constants.ENV_MAX || env < Constants.ENV_MIN) {
            env = 0;
        }

        this.env = env;
    }


    @Override
    public synchronized long getId(String uid, OrderTypeEnum orderTypeEnum) {

        int hashCode = uid.hashCode();
        long timestamp = System.currentTimeMillis();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d  milliseconds",
                    lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & Constants.SEQ_MASK;
            if (sequence == 0) {
                timestamp = TimeUtil.tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }
        lastTimestamp = timestamp;


        return ((timestamp - Constants.EPOCH) << 0x16)
                | (appId << 0x13)
                | (orderTypeEnum.ordinal() << 0x12)
                | (env << 0x10)
                | (sequence << 0x6)
                | (hashCode & 0x3f);
    }


    public static void main(String[] args) {

        IdService service = new IdServiceImpl(1, 2);
        long id = service.getId("123", OrderTypeEnum.GOODS_ORDER_PAY);
        System.out.println(id);
    }


}
