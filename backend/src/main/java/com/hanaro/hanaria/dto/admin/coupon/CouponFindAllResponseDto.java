package com.hanaro.hanaria.dto.admin.coupon;

import com.hanaro.hanaria.domain.admin.coupon.Coupon;
import com.hanaro.hanaria.dto.admin.product.ProductFindByIdResponseDto;

import java.time.LocalDateTime;

public record CouponFindAllResponseDto(
        Long id,
        LocalDateTime createdAt,
        LocalDateTime validAt,
        LocalDateTime expiredAt,
        String name,
        String nameEn,
        Integer price,
        ProductFindByIdResponseDto product
) {
    public CouponFindAllResponseDto(Coupon entity) {
        this(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getValidAt(),
                entity.getExpiredAt(),
                entity.getName(),
                entity.getNameEn(),
                entity.getPrice(),
                new ProductFindByIdResponseDto(entity.getProduct())
        );
    }
}
