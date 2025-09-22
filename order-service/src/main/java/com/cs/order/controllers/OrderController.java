package com.cs.order.controllers;

import com.cs.order.dto.OrderDTO;
import com.cs.order.dto.PaymentDTO;
import com.cs.order.entities.Order;
import com.cs.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> save(@RequestBody Order order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(order));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> findById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.findById(orderId));
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/all/{orderId}")
    public ResponseEntity<OrderDTO> getAllOrders(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrderWithProductDetails(orderId));
    }

//    @PostMapping
//    public ResponseEntity<PaymentDTO> placeOrder(@RequestBody Order order) {
//
//    }
}
