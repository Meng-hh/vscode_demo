package com.example.demo.controller;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

import static com.example.demo.config.RabbitMQConfig.*;

@RestController
@RequestMapping("/message")
public class SendMessageController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/send")
    public void send(){
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE,QUEUE__ROUTING_KEY,"hello rabbitmq",correlationData);
    }
}
