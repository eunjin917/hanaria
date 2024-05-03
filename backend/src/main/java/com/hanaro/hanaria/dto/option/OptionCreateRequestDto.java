package com.hanaro.hanaria.dto.option;

import com.hanaro.hanaria.domain.group.GroupCategory;
import com.hanaro.hanaria.domain.option.Option;
import com.hanaro.hanaria.domain.option.OptionCategory;
import com.hanaro.hanaria.domain.product.Product;

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
