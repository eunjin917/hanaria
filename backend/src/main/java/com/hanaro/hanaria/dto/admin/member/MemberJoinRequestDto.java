package com.hanaro.hanaria.dto.admin.member;

import com.hanaro.hanaria.domain.admin.member.Member;

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
