package com.hanaro.hanaria.dto.admin.payment;

import com.hanaro.hanaria.domain.admin.payment.Payment;

import java.time.LocalDateTime;

public record PaymentFindByOrderIdResponseDto(
        Long id,
        LocalDateTime createdAt,
        Integer price,
        String cardType,
        String approvalNo
) {
    public PaymentFindByOrderIdResponseDto(Payment entity) {
        this(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getPrice(),
                entity.getCardType(),
                entity.getApprovalNo()
        );
    }
}
