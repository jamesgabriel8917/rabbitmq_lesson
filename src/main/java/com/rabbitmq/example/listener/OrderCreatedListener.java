package com.rabbitmq.example.listener;


import com.rabbitmq.example.listener.dto.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;


import static com.rabbitmq.example.config.RabbitMqConfig.ORDER_QUEUE;

public class OrderCreatedListener {

    private final Logger logger = LoggerFactory.getLogger(OrderCreatedListener.class);

    @RabbitListener(queues = ORDER_QUEUE)
    public void listen(Message<OrderCreatedEvent> message){


        logger.info("Message consumed: {}", message );
    };
}
