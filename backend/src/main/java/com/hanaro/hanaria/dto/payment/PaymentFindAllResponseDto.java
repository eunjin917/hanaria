package com.hanaro.hanaria.dto.payment;

import com.hanaro.hanaria.domain.payment.Payment;
import com.hanaro.hanaria.dto.order.OrderFindByIdResponseDto;

import java.time.LocalDateTime;

public record PaymentFindAllResponseDto(
        Long id,
        LocalDateTime createdAt,
        Integer price,
        String cardType,
        String approvalNo,
        OrderFindByIdResponseDto order
) {
    public PaymentFindAllResponseDto(Payment entity) {
        this(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getPrice(),
                entity.getCardType(),
                entity.getApprovalNo(),
                new OrderFindByIdResponseDto(entity.getOrder())
        );
    }
}
