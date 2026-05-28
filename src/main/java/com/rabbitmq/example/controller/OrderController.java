package com.rabbitmq.example.controller;

import com.rabbitmq.example.controller.dto.ApiResponse;
import com.rabbitmq.example.controller.dto.OrderResponse;
import com.rabbitmq.example.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }



    @GetMapping("/costumers/{costumerId}/orders")
    public ResponseEntity<ApiResponse<OrderResponse>> listOrders(@PathVariable("costumerId") Long costumerId,
                                                                 @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                 @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize){

        var pageResponse = orderService.findAllByCostumerId(costumerId);

        return ResponseEntity.ok(new ApiResponse<>(
                pageResponse
        ));
    }
}
