package com.rabbitmq.example.service;

import com.rabbitmq.example.controller.dto.OrderResponse;
import com.rabbitmq.example.entity.OrderEntity;
import com.rabbitmq.example.entity.OrderItem;
import com.rabbitmq.example.listener.dto.OrderCreatedEvent;
import com.rabbitmq.example.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(OrderCreatedEvent orderCreatedEvent){

        OrderEntity entity = new OrderEntity();

        entity.setOrderId(orderCreatedEvent.codigoPedido());
        entity.setCostumerId(orderCreatedEvent.codigoCliente());
        entity.setItems(orderCreatedEvent.itens().stream()
                .map(i -> new OrderItem(i.preco(), i.produto(), i.quantidade()))
                .toList()
        );
        entity.setTotal(getTotal(orderCreatedEvent));

        orderRepository.save(entity);
    }

    private BigDecimal getTotal(OrderCreatedEvent orderCreatedEvent) {
        return orderCreatedEvent.itens()
                .stream()
                .map(i -> i.preco().multiply(BigDecimal.valueOf(i.quantidade())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }


    public OrderRepository findAllByCostumerId(Long costumerId){
        var orders = orderRepository.findAllByCostumerId(costumerId);

        return orders;
    }

}
