package com.hanaro.hanaria.domain.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberRole {
    USER("USER", "사용자"),
    ADMIN("ADMIN", "관리자");

    private final String value_en;
    private final String value_ko;
}