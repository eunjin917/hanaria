package com.hanaro.hanaria.dto.admin.option;

import com.hanaro.hanaria.domain.admin.option.Option;
import com.hanaro.hanaria.domain.admin.option.OptionCategory;
import com.hanaro.hanaria.domain.admin.product.Product;

public record OptionCreateRequestDto(
        Integer price,
        OptionCategory category,
        Long productId
) {
    public Option toEntity(Product product) {
        return Option.builder()
                .price(price)
                .category(category)
                .product(product)
                .build();
    }
}
