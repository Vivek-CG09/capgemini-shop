package com.cs.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private Long id;
//    private Long order_id;
    private int amount;
    private String payment_status;
    private LocalDate date;
}
