package com.hanaro.hanaria.dto.admin.payment;

import com.hanaro.hanaria.domain.admin.order.Order;
import com.hanaro.hanaria.domain.admin.payment.Payment;

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
