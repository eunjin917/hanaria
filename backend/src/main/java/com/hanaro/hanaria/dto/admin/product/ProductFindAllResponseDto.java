package com.hanaro.hanaria.dto.admin.product;

import com.hanaro.hanaria.domain.admin.product.Product;
import com.hanaro.hanaria.domain.admin.product.ProductType;
import com.hanaro.hanaria.dto.admin.group.GroupFindByIdResponseDto;

import java.time.LocalDateTime;

public record ProductFindAllResponseDto(
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
    public ProductFindAllResponseDto(Product entity) {
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
