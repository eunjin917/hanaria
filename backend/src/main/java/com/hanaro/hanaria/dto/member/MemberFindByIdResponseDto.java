package com.hanaro.hanaria.dto.member;

import com.hanaro.hanaria.domain.member.Member;
import com.hanaro.hanaria.domain.member.MemberRole;

import java.time.LocalDateTime;

public record MemberFindByIdResponseDto(
        Long id,
        LocalDateTime createdAt,
        String username,
        String password,
        String nickname,
        MemberRole role,
        Integer point,
        String tel
) {
    public MemberFindByIdResponseDto(Member entity) {
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
