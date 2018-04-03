package com.yooeee.id.gen.server.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yooeee.id.gen.OrderTypeEnum;
import com.yooeee.id.gen.api.IdService;
import com.yooeee.id.gen.service.IdServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Administrator
 * @date 2018/4/3
 */
@Service(version = "1.0.0")
public class IdServiceProxyImpl implements  IdService,InitializingBean {

    @Value("${com.yooeee.id.gen.app_id}")
    private int appId;

    @Value("${com.yooeee.id.gen.env}")
    private int env;

    private IdService idService;


    @Override
    public long getId(String uid, OrderTypeEnum orderTypeEnum) {
        return this.idService.getId(uid,orderTypeEnum);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.idService = new IdServiceImpl(appId,env);
    }
}
