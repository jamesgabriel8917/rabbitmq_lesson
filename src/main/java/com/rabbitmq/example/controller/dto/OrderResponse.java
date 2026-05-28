package com.rabbitmq.example.controller.dto;

import com.rabbitmq.example.entity.OrderEntity;

import java.math.BigDecimal;

public record OrderResponse(Long orderId,
                            Long costumerId,
                            BigDecimal total) {

    public static OrderResponse fromEntity(OrderEntity entity) {

        return new OrderResponse(entity.getOrderId(), entity.getCostumerId(), entity.getTotal());
    }
}
