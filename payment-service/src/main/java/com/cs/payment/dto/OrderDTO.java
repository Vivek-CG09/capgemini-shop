package com.cs.payment.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    private Long orderId;
    private int totalPrice;
    private String status;
    private LocalDate date;
}
