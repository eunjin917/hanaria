package com.hanaro.hanaria.dto.admin.product;

import com.hanaro.hanaria.domain.admin.group.Group;
import com.hanaro.hanaria.domain.admin.product.Product;
import com.hanaro.hanaria.domain.admin.product.ProductType;

public record ProductCreateRequestDto(
        Integer price,
        String name,
        String nameEn,
        String image,
        boolean recommended,
        ProductType type,
        Long groupId
) {
    public Product toEntity(Group group) {
        return Product.builder()
                .price(price)
                .name(name)
                .nameEn(nameEn)
                .image(image)
                .recommended(recommended)
                .type(type)
                .group(group)
                .build();
    }
}
