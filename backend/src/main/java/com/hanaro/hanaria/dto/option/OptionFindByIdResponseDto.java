package com.hanaro.hanaria.dto.option;

import com.hanaro.hanaria.domain.option.Option;
import com.hanaro.hanaria.domain.option.OptionCategory;
import com.hanaro.hanaria.dto.product.ProductFindByIdResponseDto;

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
