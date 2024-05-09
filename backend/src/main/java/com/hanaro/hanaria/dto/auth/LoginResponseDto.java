package com.hanaro.hanaria.dto.auth;

import com.hanaro.hanaria.domain.member.Member;
import com.hanaro.hanaria.domain.memberCoupon.MemberCoupon;
import com.hanaro.hanaria.dto.memberCoupon.MemberCouponLoginResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public record LoginResponseDto(
        Long memberId,
        String nickname,
        Integer point,
        List<MemberCouponLoginResponseDto> memberCoupons
) {
    public LoginResponseDto(Member entity, List<MemberCoupon> memberCoupons) {
        this(
                entity.getId(),
                entity.getNickname(),
                entity.getPoint(),
                memberCoupons.stream().map(MemberCouponLoginResponseDto::new).collect(Collectors.toList())
        );
    }
}
