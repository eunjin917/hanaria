package com.hanaro.hanaria.domain.admin.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductType {
    SINGLE("SINGLE", "단품"),
    COMBO("COMBO", "콤보"),
    SET("SET", "세트");

    private final String value_en;
    private final String value_ko;
}