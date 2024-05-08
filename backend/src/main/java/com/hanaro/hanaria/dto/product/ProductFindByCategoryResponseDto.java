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
                entity.getType().ordinal() == 2,    // 세트일 때만 디저트 true
                entity.getType().ordinal() > 0  // 콤보, 세트일 때만 음료 false
        );
    }
}
