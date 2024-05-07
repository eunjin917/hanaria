package com.hanaro.hanaria.dto.memberCoupon;

import com.hanaro.hanaria.domain.coupon.Coupon;
import com.hanaro.hanaria.domain.member.Member;
import com.hanaro.hanaria.domain.memberCoupon.MemberCoupon;

import java.time.LocalDateTime;


public record MemberCouponUpdateRequestDto(
        Long memberCouponId,
        LocalDateTime validAt,
        LocalDateTime expiredAt,
        LocalDateTime usedAt,
        Long memberId,
        Long couponId
) {
    public MemberCoupon toApplied(MemberCoupon memberCoupon, Member member, Coupon coupon) {
        return MemberCoupon.builder()
                .validAt(validAt)
                .expiredAt(expiredAt)
                .usedAt(usedAt)
                .id(memberCoupon.getId())
                .member(member)
                .coupon(coupon)
                .createdAt(memberCoupon.getCreatedAt())
                .build();
    }
}
