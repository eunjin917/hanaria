package com.hanaro.hanaria.dto.coupon;

import com.hanaro.hanaria.domain.coupon.Coupon;
import com.hanaro.hanaria.domain.product.Product;

import java.time.LocalDateTime;

public record CouponCreateRequestDto(
        LocalDateTime validAt,
        LocalDateTime expiredAt,
        String name,
        String nameEn,
        Integer price,
        Long productId
) {
    public Coupon toEntity(Product product) {
        return Coupon.builder()
                .validAt(validAt)
                .expiredAt(expiredAt)
                .name(name)
                .nameEn(nameEn)
                .price(price)
                .product(product)
                .build();
    }
}
