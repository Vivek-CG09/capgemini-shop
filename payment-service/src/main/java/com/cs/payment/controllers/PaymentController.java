package com.cs.payment.controllers;

import com.cs.payment.dto.OrderDTO;
import com.cs.payment.entities.Payment;
import com.cs.payment.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> placeOrder(@RequestBody OrderDTO order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.placeOrder(order));
    }
}
