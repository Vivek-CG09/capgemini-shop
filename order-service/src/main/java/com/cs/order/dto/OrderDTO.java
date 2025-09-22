package com.cs.order.dto;

import com.cs.order.entities.Order;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDTO {

    private Order order;
    private ProductDTO product;
    private PaymentDTO payment;
}
