package com.yooeee.id.gen.client.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yooeee.id.gen.OrderTypeEnum;
import com.yooeee.id.gen.api.IdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @date 2018/4/3
 */
@Component
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Reference(version = "1.0.0")
    private IdService idService;

    public String createOrder(String uid){
        long orderNo = this.idService.getId(uid, OrderTypeEnum.GOODS_ORDER_PAY);
        logger.info("orderNo="+orderNo);

        return String.valueOf(orderNo);
    }

}
