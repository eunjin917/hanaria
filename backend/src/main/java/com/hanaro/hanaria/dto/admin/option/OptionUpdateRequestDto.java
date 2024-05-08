package com.hanaro.hanaria.dto.admin.option;

import com.hanaro.hanaria.domain.admin.option.Option;
import com.hanaro.hanaria.domain.admin.option.OptionCategory;
import com.hanaro.hanaria.domain.admin.product.Product;

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
