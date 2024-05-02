package com.hanaro.hanaria.dto.product;

import com.hanaro.hanaria.domain.group.Group;
import com.hanaro.hanaria.domain.product.Product;
import com.hanaro.hanaria.domain.product.ProductType;

public record ProductUpdateRequestDto(
        Long productId,
        Integer price,
        String name,
        String nameEn,
        String image,
        boolean recommended,
        ProductType type,
        Long groupId
) {
    public Product toApplied(Product product, Group group) {
        return Product.builder()
                .id(productId)
                .price(price)
                .name(name)
                .nameEn(nameEn)
                .image(image)
                .recommended(recommended)
                .type(type)
                .group(group)
                .createdAt(product.getCreatedAt())
                .build();
    }
}
