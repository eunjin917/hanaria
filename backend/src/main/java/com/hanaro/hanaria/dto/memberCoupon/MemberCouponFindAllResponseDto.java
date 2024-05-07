package com.hanaro.hanaria.dto.memberCoupon;

import com.hanaro.hanaria.domain.memberCoupon.MemberCoupon;
import com.hanaro.hanaria.dto.coupon.CouponFindByIdResponseDto;
import com.hanaro.hanaria.dto.member.MemberFindByIdResponseDto;

import java.time.LocalDateTime;


public record MemberCouponFindAllResponseDto (
        LocalDateTime createdAt,
        LocalDateTime expiredAt,
        MemberFindByIdResponseDto member,
        CouponFindByIdResponseDto coupon
) {
    public MemberCouponFindAllResponseDto(MemberCoupon entity) {
        this(
                entity.getCreatedAt(),
                entity.getExpiredAt(),
                new MemberFindByIdResponseDto(entity.getMember()),
                new CouponFindByIdResponseDto(entity.getCoupon())
        );
    }
}
