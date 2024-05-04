package com.hanaro.hanaria.dto.coupon;

import com.hanaro.hanaria.domain.coupon.Coupon;
import com.hanaro.hanaria.dto.product.ProductFindByIdResponseDto;

import java.time.LocalDateTime;

public record CouponFindByIdResponseDto(
        Long id,
        LocalDateTime createdAt,
        LocalDateTime expiredAt,
        String name,
        String nameEn,
        Integer price,
        ProductFindByIdResponseDto product
) {
    public CouponFindByIdResponseDto(Coupon entity) {
        this(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getExpiredAt(),
                entity.getName(),
                entity.getNameEn(),
                entity.getPrice(),
                new ProductFindByIdResponseDto(entity.getProduct())
        );
    }
}
