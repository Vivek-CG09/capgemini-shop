package com.cs.order.service.impl;

import com.cs.order.dto.OrderDTO;
import com.cs.order.dto.PaymentDTO;
import com.cs.order.dto.ProductDTO;
import com.cs.order.entities.Order;
import com.cs.order.repositories.OrderRepository;
import com.cs.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final RestClient restClient;

    @Override
    public OrderDTO save(Order order) {
        order.setDate(LocalDate.now());
        PaymentDTO payment = restClient.post()
                .uri("http://PAYMENT-SERVICE/api/v1/payments")
                .body(order)
                .retrieve()
                .body(PaymentDTO.class);
        Order savedOrder = orderRepository.save(order);
        OrderDTO orderWithProductDetails = getOrderWithProductDetails(savedOrder.getId());

        return OrderDTO.builder()
                .product(orderWithProductDetails.getProduct())
                .order(savedOrder)
                .payment(payment)
                .build();
    }

    @Override
    public Order findById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow();
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderDTO getOrderWithProductDetails(Long orderId) {
        Order order = findById(orderId);
        Long productId = order.getProductId();
        ProductDTO product = restClient.get()
                .uri("http://PRODUCT-SERVICE/api/v1/products/" + productId)
                .retrieve()
                .body(ProductDTO.class);
        OrderDTO orderDTO = OrderDTO.builder()
                .order(order)
                .product(product)
                .build();
        orderDTO.setProduct(product);
        return orderDTO;
    }

}