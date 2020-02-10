package com.chong.mcspcorderservice.service;

import com.chong.common.util.ObjectMapperUtil;
import com.chong.common.util.ResponseUtil;
import com.chong.mcspcorderservice.constants.MasterDataEnum;
import com.chong.mcspcorderservice.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class ReceiveOrderCuidQueueService {

    private static final Logger logger = LoggerFactory.getLogger(ReceiveOrderCuidQueueService.class);

    @Autowired
    SendOrderCuidResultQueueService sendOrderCuidResultQueueService;
    //
//    @Value("${data.rabbitmq.exchange-order}")
//    private String exchangeOrder;
//
//    @Value("${data.rabbitmq.queue-order-create-key.mc-spc-order-service}")
//    private String queueOrderCreateKey;
//
//    @Value("${data.rabbitmq.queue-order-cancel-key.mc-spc-order-service}")
//    private String queueOrderCancelKey;
//
//    @Value("${data.rabbitmq.queue-order-create-result-key.mc-spc-sales-service}")
//    private String queueOrderCreateResultKey;
//
//    @Value("${data.rabbitmq.queue-order-cancel-result-key.mc-spc-sales-service}")
//    private String queueOrderCancelResultKey;

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue("queue.order.create.mc-spc-order-service"),
                    exchange = @Exchange("exchange.order"),
                    key = {"queue.order.create.mc-spc-order-service"})
    })
    public void receiveOrderCreate(Order order) {

        logger.info("rabbitmq:order接收的订单创建请求：");
        logger.info(ObjectMapperUtil.getStringValue(order));
        if(order!=null){
            order.setMemberId(100);
            order.setOrderMoney(new BigDecimal(999.99));
            order.setPayStatus(MasterDataEnum.PAYMENT_STATUS_WAITPAY.getStatusCode());
            order.setSubmitDate(new Date());
            sendOrderCuidResultQueueService.sendOrderCreatResult(ResponseUtil.success("order:订单创建成功",order));

        }

    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue("queue.order.cancel.mc-spc-order-service"),
                    exchange = @Exchange("exchange.order"),
                    key = {"queue.order.cancel.mc-spc-order-service"})
    })
    public void receiveOrderCancel(Order order) {

        logger.info("rabbitmq:order接收订单取消请求：");
        logger.info(ObjectMapperUtil.getStringValue(order));
        if(order!=null){
            sendOrderCuidResultQueueService.sendOrderCancelResult(
                    ResponseUtil.success("order:订单取消成功",order));
        }

    }
}
