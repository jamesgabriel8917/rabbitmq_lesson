package com.rabbitmq.example.config;

import com.rabbitmq.example.listener.OrderCreatedListener;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {

    public static final String ORDER_QUEUE = "order-created";


    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(){

        return new Jackson2JsonMessageConverter();
    }

}
