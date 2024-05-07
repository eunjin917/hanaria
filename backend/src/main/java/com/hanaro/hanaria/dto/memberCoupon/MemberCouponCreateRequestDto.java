package com.hanaro.hanaria.dto.memberCoupon;

import com.hanaro.hanaria.domain.coupon.Coupon;
import com.hanaro.hanaria.domain.member.Member;
import com.hanaro.hanaria.domain.memberCoupon.MemberCoupon;

import java.time.LocalDateTime;


public record MemberCouponCreateRequestDto(
        LocalDateTime validAt,
        LocalDateTime expiredAt,
        LocalDateTime usedAt,
        Long memberId,
        Long couponId
) {
    public MemberCoupon toEntity(Member member, Coupon coupon) {
        return MemberCoupon.builder()
                .validAt(validAt)
                .expiredAt(expiredAt)
                .usedAt(usedAt)
                .member(member)
                .coupon(coupon)
                .build();
    }
}
