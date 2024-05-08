package com.hanaro.hanaria.domain.admin.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    PAYING("Paying", "결제진행중"),
    PREPARING("Preparing", "상품준비중"),
    PREPARED("Prepared", "상품준비완료"),
    RECEIVED("Received", "상품수령완료"),
    REFUNDED("Refunded", "환불처리");

    private final String value_en;
    private final String value_ko;
}