package com.hanaro.hanaria.dto;

import com.hanaro.hanaria.domain.Coupon;
import com.hanaro.hanaria.domain.product.Product;
import com.hanaro.hanaria.dto.product.ProductFindByIdResponseDto;

import java.time.LocalDateTime;

public record CouponFindAllResponseDto(
        Long id,
        LocalDateTime createdAt,
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
                entity.getExpiredAt(),
                entity.getName(),
                entity.getNameEn(),
                entity.getPrice(),
                new ProductFindByIdResponseDto(entity.getProduct())
        );
    }
}
