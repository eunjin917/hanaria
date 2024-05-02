package com.hanaro.hanaria.dto.product;

import com.hanaro.hanaria.domain.product.Product;
import com.hanaro.hanaria.domain.product.ProductType;
import com.hanaro.hanaria.dto.group.GroupFindByIdResponseDto;

import java.time.LocalDateTime;

public record ProductFindByIdResponseDto(
        Long id,
        LocalDateTime createdAt,
        Integer price,
        String name,
        String nameEn,
        String image,
        boolean recommended,
        ProductType type,
        GroupFindByIdResponseDto group
) {
    public ProductFindByIdResponseDto(Product entity) {
        this(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getPrice(),
                entity.getName(),
                entity.getNameEn(),
                entity.getImage(),
                entity.isRecommended(),
                entity.getType(),
                new GroupFindByIdResponseDto(entity.getGroup()));
    }
}
