package com.hanaro.hanaria.dto.product;

import com.hanaro.hanaria.domain.product.Product;

public record ProductFindByCategoryResponseDto(
        Long id,
        Integer price,
        String name,
        String nameEn,
        String image,
        boolean recommended,
        Boolean dessertOptionAvailable,
        Boolean drinkOptionAvailable
) {
    public ProductFindByCategoryResponseDto(Product entity) {
        this(
                entity.getId(),
                entity.getPrice(),
                entity.getName(),
                entity.getNameEn(),
                entity.getImage(),
                entity.isRecommended(),
                true,
                true
        );
    }
}
