package com.cs.payment.services.impl;

import com.cs.payment.dto.OrderDTO;
import com.cs.payment.entities.Payment;
import com.cs.payment.repositories.PaymentRepository;
import com.cs.payment.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Payment placeOrder(OrderDTO order) {
        Payment payment = Payment.builder()
                .order_id(order.getOrderId())
                .amount(order.getTotalPrice())
                .date(order.getDate())
                .payment_status("Payment Successful")
                .build();
        return paymentRepository.save(payment);
    }
}
