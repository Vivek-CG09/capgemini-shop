package com.cs.payment.services;

import com.cs.payment.dto.OrderDTO;
import com.cs.payment.entities.Payment;

public interface PaymentService {

    Payment placeOrder(OrderDTO order);
}
