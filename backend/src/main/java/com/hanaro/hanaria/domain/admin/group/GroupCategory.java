package com.hanaro.hanaria.domain.admin.group;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GroupCategory {
    BURGER("BURGER", "버거"),
    DESSERT("DESSERT", "디저트"),
    DRINK("DRINK", "음료");

    private final String value_en;
    private final String value_ko;
}