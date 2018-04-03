package com.yooeee.id.gen.client.web;

import com.yooeee.id.gen.client.consumer.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2018/4/3
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("create")
    public String createOrder(String uid){


        return orderService.createOrder(uid);
    }
}
