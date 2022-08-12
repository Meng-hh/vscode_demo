package com.example.demo;

import com.example.demo.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import static com.example.demo.config.RabbitMQConfig.*;


@SpringBootTest()
class DemoApplicationTests {

    @Resource
    private RabbitTemplate rabbitTemplate;
    @Test
    void contextLoads() {

    }

    @Test
    void testSendMessage()  {
        String QUEUE_NAME = "q_test_01";
        try {
            Connection connection = ConnectionUtil.getConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            String message="hello rabbitmq";
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes(StandardCharsets.UTF_8));
            System.out.println("Sent"+message+" ");
            channel.close();
            connection.close();
        } catch (Throwable e) {
            System.out.println(e.getCause());
        }
    }

    @Test
    void testSbSend(){

    }

}
