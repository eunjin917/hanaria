package com.hanaro.hanaria.dto.admin.option;

import com.hanaro.hanaria.domain.admin.option.Option;
import com.hanaro.hanaria.domain.admin.option.OptionCategory;
import com.hanaro.hanaria.dto.admin.product.ProductFindByIdResponseDto;

import java.time.LocalDateTime;

public record
OptionFindByIdResponseDto(
        Long id,
        LocalDateTime createdAt,
        Integer price,
        OptionCategory category,
        ProductFindByIdResponseDto product
) {
    public OptionFindByIdResponseDto(Option entity) {
        this(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getPrice(),
                entity.getCategory(),
                new ProductFindByIdResponseDto(entity.getProduct()));
    }
}
