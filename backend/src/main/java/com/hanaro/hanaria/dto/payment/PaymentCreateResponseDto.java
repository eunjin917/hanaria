package com.hanaro.hanaria.dto.payment;

import com.hanaro.hanaria.domain.payment.Payment;

public record PaymentCreateResponseDto(
        String approvalNo,
        Integer tmpNo
) {
    public PaymentCreateResponseDto(Payment entity, Integer tmpNo) {
        this(
                entity.getApprovalNo(),
                tmpNo
        );
    }
}
