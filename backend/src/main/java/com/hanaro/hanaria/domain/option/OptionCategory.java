package com.hanaro.hanaria.domain.option;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OptionCategory {
    DESSERT("DESSERT", "디저트"),
    DRINK("DRINK", "음료");

    private final String value_en;
    private final String value_ko;
}