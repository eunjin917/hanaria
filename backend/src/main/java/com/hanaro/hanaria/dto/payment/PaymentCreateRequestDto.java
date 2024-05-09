package com.hanaro.hanaria.dto.payment;

import com.hanaro.hanaria.domain.order.Order;
import com.hanaro.hanaria.domain.payment.Payment;

public record PaymentCreateRequestDto(
        Integer price,
        String cardType,
        Long orderId
) {
    public Payment toEntity(Order order, String approvalNo) {
        return Payment.builder()
                .price(price)
                .cardType(cardType)
                .approvalNo(approvalNo)
                .order(order)
                .build();
    }
}
