package com.chong.mcspcorderservice.service;

import com.chong.common.entity.ResponseData;
import com.chong.common.util.ObjectMapperUtil;
import com.chong.mcspcorderservice.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SendOrderCuidResultQueueService {

    private static final Logger logger = LoggerFactory.getLogger(SendOrderCuidResultQueueService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${exchange-name.mc-spc-order-service}")
    private String exchangeOrder;

    @Value("${routing-key.order-create.mc-spc-order-service}")
    private String queueOrderCreateKey;

    @Value("${routing-key.order-cancel.mc-spc-order-service}")
    private String queueOrderCancelKey;

    @Value("${routing-key.order-create-result.mc-spc-sales-service}")
    private String queueOrderCreateResultKey;

    @Value("${routing-key.order-cancel-result.mc-spc-sales-service}")
    private String queueOrderCancelResultKey;

    public void sendOrderCreatResult(ResponseData responseData){
        logger.info("rabbitmq:order发送订单创建结果通知：");
        logger.info(ObjectMapperUtil.getStringValue(responseData));

        rabbitTemplate.convertAndSend(exchangeOrder,queueOrderCreateResultKey,responseData);
    }

    public void sendOrderCancelResult(ResponseData responseData){
        logger.info("rabbitmq:order发送订单取消结果通知：");
        logger.info(ObjectMapperUtil.getStringValue(responseData));
        rabbitTemplate.convertAndSend(exchangeOrder,queueOrderCancelResultKey,responseData);
    }
}
