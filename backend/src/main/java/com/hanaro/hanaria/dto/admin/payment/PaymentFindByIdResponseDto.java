package com.hanaro.hanaria.dto.admin.payment;

import com.hanaro.hanaria.domain.admin.payment.Payment;
import com.hanaro.hanaria.dto.admin.order.OrderFindByIdResponseDto;

import java.time.LocalDateTime;

public record PaymentFindByIdResponseDto(
        Long id,
        LocalDateTime createdAt,
        Integer price,
        String cardType,
        String approvalNo,
        OrderFindByIdResponseDto order
) {
    public PaymentFindByIdResponseDto(Payment entity) {
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
