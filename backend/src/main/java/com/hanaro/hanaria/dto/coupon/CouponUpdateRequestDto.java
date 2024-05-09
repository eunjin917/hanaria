package com.hanaro.hanaria.dto.coupon;

import com.hanaro.hanaria.domain.coupon.Coupon;
import com.hanaro.hanaria.domain.product.Product;

import java.time.LocalDateTime;

public record CouponUpdateRequestDto(
        Long couponId,
        LocalDateTime validAt,
        LocalDateTime expiredAt,
        String name,
        String nameEn,
        Integer price,
        Long productId
) {
    public Coupon toApplied(Coupon coupon, Product product) {
        return Coupon.builder()
                .id(couponId)
                .validAt(validAt)
                .expiredAt(expiredAt)
                .name(name)
                .nameEn(nameEn)
                .price(price)
                .product(product)
                .createdAt(coupon.getCreatedAt())
                .build();
    }
}
