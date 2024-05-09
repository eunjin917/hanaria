package com.hanaro.hanaria.dto.option;

import com.hanaro.hanaria.domain.option.Option;
import com.hanaro.hanaria.domain.product.Product;

public record OptionFindByCategoryResponseDto(
        Long id,
        Integer price,
        Long productId,
        String productName,
        String productNameEn,
        String productImage
) {
    public OptionFindByCategoryResponseDto(Option entity) {
        this (
                entity.getId(),
                entity.getPrice(),
                entity.getProduct().getId(),
                entity.getProduct().getName(),
                entity.getProduct().getNameEn(),
                entity.getProduct().getImage()
        );
    }
}
