package com.hanaro.hanaria.domain.admin.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderMethod {
    HERE("HERE", "매장"),
    TOGO("TOGO", "포장");

    private final String value_en;
    private final String value_ko;
}