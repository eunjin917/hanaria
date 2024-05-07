package com.hanaro.hanaria.dto.memberCoupon;

import com.hanaro.hanaria.domain.coupon.Coupon;
import com.hanaro.hanaria.domain.member.Member;
import com.hanaro.hanaria.domain.memberCoupon.MemberCoupon;

import java.time.LocalDateTime;


public record MemberCouponUpdateRequestDto(
        LocalDateTime createdAt,
        LocalDateTime expiredAt,
        Long memberId,
        Long couponId
) {
    public MemberCoupon toApplied(MemberCoupon memberCoupon, Member member, Coupon coupon) {
        return MemberCoupon.builder()
                .createdAt(createdAt)
                .expiredAt(expiredAt)
                .member(member)
                .coupon(coupon)
                .build();
    }
}
