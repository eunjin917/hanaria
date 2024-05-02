package com.hanaro.hanaria.dto.option;

import com.hanaro.hanaria.domain.group.Group;
import com.hanaro.hanaria.domain.option.Option;
import com.hanaro.hanaria.domain.option.OptionCategory;
import com.hanaro.hanaria.domain.product.Product;
import com.hanaro.hanaria.domain.product.ProductType;
import com.hanaro.hanaria.dto.product.ProductFindByIdResponseDto;

import java.time.LocalDateTime;

public record OptionUpdateRequestDto(
        Long optionId,
        LocalDateTime createdAt,
        Integer price,
        OptionCategory category,
        Long productId
) {
    public Option toApplied(Option option, Product product) {
        return Option.builder()
                .id(optionId)
                .price(price)
                .category(category)
                .product(product)
                .createdAt(option.getCreatedAt())
                .build();
    }
}
