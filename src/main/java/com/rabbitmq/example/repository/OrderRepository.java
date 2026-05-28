package com.rabbitmq.example.repository;

import com.rabbitmq.example.entity.OrderEntity;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {

    OrderRepository findAllByCostumerId(Long costumerId);
}


