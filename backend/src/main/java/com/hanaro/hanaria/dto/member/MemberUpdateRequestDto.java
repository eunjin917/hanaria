package com.hanaro.hanaria.dto.member;

import com.hanaro.hanaria.domain.member.Member;
import com.hanaro.hanaria.domain.member.MemberRole;

public record MemberUpdateRequestDto(
        Long memberId,
        String username,
        String password,
        String nickname,
        String tel,
        Integer point,
        MemberRole role
) {
    // 원래 멤버에다가 이 정보들 합쳐서 반환
    public Member toApplied(Member member) {
        return Member.builder()
                .id(memberId)
                .username(username)
                .password(password)
                .nickname(nickname)
                .tel(tel)
                .point(point)
                .role(role)
                .createdAt(member.getCreatedAt())
                .build();
    }
}
