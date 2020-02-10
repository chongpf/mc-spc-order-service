package com.chong.mcspcorderservice.controller;

import com.chong.common.entity.ResponseData;
import com.chong.common.util.AppProperties;
import com.chong.common.util.ResponseUtil;
import com.chong.mcspcorderservice.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private AppProperties properties;
//    private ReceiveOrderCuidQueueService receiveOrderCuidQueueService;
//    private SendOrderCuidResultQueueService sendOrderCuidResultQueueService;
    @Autowired
    public OrderController(AppProperties properties
//            ,ReceiveOrderCuidQueueService receiveOrderCuidQueueService
//            ,SendOrderCuidResultQueueService sendOrderCuidResultQueueService
    ){
        this.properties = properties;
//        this.receiveOrderCuidQueueService = receiveOrderCuidQueueService;
//        this.sendOrderCuidResultQueueService = sendOrderCuidResultQueueService;
    }

    @GetMapping(value="/{orderId}")
    public ResponseData getOrder(@PathVariable("orderId") String orderId){
        Order order = new Order();
        order.setId(Integer.parseInt(orderId));
        return ResponseUtil.success(properties.getInstanceId(),order);
    }

//    @PostMapping(value="/create/{orderId}")
//    public ResponseData createOrder(@PathVariable("orderId") String orderId){
//        Order order = new Order();
//        order.setId(Integer.parseInt(orderId));
//        receiveOrderCuidQueueService.receiveOrderCreate(order);
//        return ResponseUtil.success(properties.getInstanceId(),order);
//    }
//
//
//    @PostMapping(value="/cancel/{orderId}")
//    public ResponseData cancelOrder(@PathVariable("orderId") String orderId){
//        Order order = new Order();
//        order.setId(Integer.parseInt(orderId));
//        receiveOrderCuidQueueService.receiveOrderCancel(order);
//        return ResponseUtil.success(properties.getInstanceId(),order);
//    }
}
