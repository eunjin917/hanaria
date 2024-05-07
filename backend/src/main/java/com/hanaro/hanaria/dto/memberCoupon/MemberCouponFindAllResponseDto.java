package com.hanaro.hanaria.dto.memberCoupon;

import com.hanaro.hanaria.domain.memberCoupon.MemberCoupon;
import com.hanaro.hanaria.dto.coupon.CouponFindByIdResponseDto;
import com.hanaro.hanaria.dto.member.MemberFindByIdResponseDto;

import java.time.LocalDateTime;


public record MemberCouponFindAllResponseDto (
        Long id,
        LocalDateTime createdAt,
        LocalDateTime validAt,
        LocalDateTime expiredAt,
        LocalDateTime usedAt,
        MemberFindByIdResponseDto member,
        CouponFindByIdResponseDto coupon
) {
    public MemberCouponFindAllResponseDto(MemberCoupon entity) {
        this(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getValidAt(),
                entity.getExpiredAt(),
                entity.getUsedAt(),
                new MemberFindByIdResponseDto(entity.getMember()),
                new CouponFindByIdResponseDto(entity.getCoupon())
        );
    }
}
