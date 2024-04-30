package com.hanaro.hanaria.dto.member;

import com.hanaro.hanaria.domain.member.Member;

public record MemberJoinRequestDto(
        String username,
        String password,
        String nickname,
        String tel
) {
    public Member toEntity() {
        return Member.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .tel(tel)
                .build();
    }
}
