package com.hanaro.hanaria.dto.memberCoupon;

import com.hanaro.hanaria.domain.memberCoupon.MemberCoupon;

import java.util.List;

public record MemberCouponLoginResponseDto(
        Long id,
        String name,
        Integer price,
        String image
) {
    public MemberCouponLoginResponseDto(MemberCoupon entity) {
        this(
                entity.getId(),
                entity.getCoupon().getName(),
                entity.getCoupon().getPrice(),
                entity.getCoupon().getProduct().getImage()
        );
    };
}
