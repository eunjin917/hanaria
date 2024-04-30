package com.hanaro.hanaria.dto.member;

import com.hanaro.hanaria.domain.member.Member;
import com.hanaro.hanaria.domain.member.MemberRole;

import java.time.LocalDateTime;

public record MemberFindAllResponseDto(
        Long id,
        LocalDateTime createdAt,
        String username,
        String password,
        String nickname,
        MemberRole role,
        Integer point,
        String tel
) {
    public MemberFindAllResponseDto(Member entity) {
        this(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getNickname(),
                entity.getRole(),
                entity.getPoint(),
                entity.getTel());
    }
}
