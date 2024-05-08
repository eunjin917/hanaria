package com.hanaro.hanaria.dto.group;

import com.hanaro.hanaria.domain.group.Group;
import com.hanaro.hanaria.dto.product.ProductFindByCategoryResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public record GroupFindByCategoryResponseDto(
        Long id,
        String name,
        String nameEn,
        List<ProductFindByCategoryResponseDto> productList
) {
    public GroupFindByCategoryResponseDto(Group entity, List<ProductFindByCategoryResponseDto> productList) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getNameEn(),
                productList.stream().map(product -> new ProductFindByCategoryResponseDto
                                (
                                        product.id(),
                                        product.price(),
                                        product.name(),
                                        product.nameEn(),
                                        product.image(),
                                        product.recommended(),
                                        product.dessertOptionAvailable(),
                                        product.drinkOptionAvailable()))
                        .collect(Collectors.toList())
        );
    }
}
