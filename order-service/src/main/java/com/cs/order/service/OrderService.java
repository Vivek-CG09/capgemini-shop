package com.cs.order.service;

import com.cs.order.dto.OrderDTO;
import com.cs.order.entities.Order;

import java.util.List;

public interface OrderService {

    OrderDTO save(Order order);

    Order findById(Long orderId);

    List<Order> findAll();

    OrderDTO getOrderWithProductDetails(Long orderId);

//    PaymentDTO placeOrder(Order order);
}
