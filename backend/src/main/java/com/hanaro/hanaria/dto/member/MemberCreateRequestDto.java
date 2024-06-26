package com.hanaro.hanaria.dto.member;

import com.hanaro.hanaria.domain.member.Member;
import com.hanaro.hanaria.domain.member.MemberRole;

public record MemberCreateRequestDto(
        String username,
        String password,
        String nickname,
        String tel,
        Integer point,
        MemberRole role
) {
    public Member toEntity() {
        return Member.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .tel(tel)
                .point(point)
                .role(role)
                .build();
    }
}
