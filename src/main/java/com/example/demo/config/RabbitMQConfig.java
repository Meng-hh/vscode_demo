package com.example.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    /**
     * 定义交换机
     */
    public static final String DELAY_EXCHANGE = "springboot_delay_exchange";
    public static final String DEAD_LETTER_EXCHANGE = "springboot_dead_letter_exchange";
    public static final String TOPIC_EXCHANGE = "springboot_topic_exchange";

    /**
     * 定义队列
     */
    public static final String DELAY_QUEUE = "springboot_queue_delay";
    public static final String DEAD_LETTER_QUEUE = "springboot_queue_dead_letter";
    public static final String QUEUE_A = "springboot_queue_a";

    /**
     * 定义路由规则
     */
    public static final String DELAY_ROUTING_KEY = "springboot_delay.#";
    public static final String DEAD_LETTER_ROUTING_KEY = "springboot_dead_letter.#";
    public static final String QUEUE__ROUTING_KEY = "springboot.#";



//    /**延迟消息
//     * 自定义交换机-作为延迟交换机
//     * 要使用“延迟消息交换”，您只需要声明一个提供"x-delayed-message"交换类型的交换
//     *
//     *
//     * @return
//     */
//    @Bean
//    public CustomExchange delayExchange() {
//        Map<String, Object> args = new HashMap<>();
//        args.put("x-delayed-type", "topic");
//        CustomExchange delayExchange = new CustomExchange(DELAY_EXCHANGE, "x-delayed-message", true, false, args);
//        return delayExchange;
//    }
//
//    /**
//     * 声明一个延时队列,并绑定到自定义的死信交换机上,此处不设置队列自身和消息的过期时间(这样做的话消息延迟时间将被写死),我们统一在发送消息的时候自己设置消息的延迟时间
//     * 消息流转过程:生产者->延时交换机(可以是普通交换机)->延时队列->死信交换机(DLX)->死信队列->消费者
//     * 这里的延迟意味着：将消息路由到队列或其他交换机的延迟
//     *
//     * @return
//     */
//    @Bean
//    public Queue delayQueue() {
//        Map<String, Object> args = new HashMap<>(2);
//        // x-dead-letter-exchange    这里声明当前队列绑定的死信交换机
//        args.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE);
//        // x-dead-letter-routing-key  这里声明当前队列的死信路由key
//        args.put("x-dead-letter-routing-key", DEAD_LETTER_ROUTING_KEY);
//        // "x-message-ttl"定义消息的过期时间单位毫秒
//        args.put("x-message-ttl", 6000);
//        //x-max-length 定义该队列最多接收消息数
//        args.put("x-max-length", 6);
//        return new Queue(DELAY_QUEUE, true, false, false, args);
//    }
//
//    /**
//     * 把延时队列绑定到延时交换机(可以是普通交换机)
//     *
//     * @return
//     */
//    @Bean
//    public Binding bindingDelayQueue() {
//        return BindingBuilder.bind(delayQueue()).to(delayExchange()).with(DELAY_ROUTING_KEY).noargs();
//    }
//
//
//
//    /**死信消息
//     * 声明一个交换机-作为死信交换机
//     * 死信交换(DLX)是普通交换,它们可以是任何通常的类型,并且可以照常声明.
//     *
//     * @return
//     */
//    @Bean
//    public TopicExchange deadLetterExchange() {
//        return new TopicExchange(DEAD_LETTER_EXCHANGE);
//    }
//
//    /**
//     * 声明一个死信队列(实际业务需要监听该队列)
//     * 消息流转过程:生产者->延时交换机(可以是普通交换机)->延时队列->死信交换机(DLX)->死信队列->消费者
//     *
//     * @return
//     */
//    @Bean
//    public Queue deadLetterQueue() {
//        return new Queue(DEAD_LETTER_QUEUE);
//    }
//
//    /**
//     * 把死信队列(实际业务需要监听该队列)绑定到死信交换
//     *
//     * @return
//     */
//    @Bean
//    public Binding bindingDeadLetterQueue() {
//        return BindingBuilder.bind(deadLetterQueue()).to(deadLetterExchange()).with(DEAD_LETTER_ROUTING_KEY);
//    }



    /**实时消息
     * 声明一个主题交换机,默认持久化,不自动删除
     *
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    /**
     * 声明一个队列,默认持久化,不自动删除
     *
     * @return
     */
    @Bean
    public Queue springbootQueueA() {
        return new Queue(QUEUE_A);
    }

    /**
     * 把队列绑定到交换机并指定路由规则
     *
     * @return
     */
    @Bean
    public Binding bindingA() {
        return BindingBuilder.bind(springbootQueueA()).to(topicExchange()).with(QUEUE__ROUTING_KEY);
    }
}