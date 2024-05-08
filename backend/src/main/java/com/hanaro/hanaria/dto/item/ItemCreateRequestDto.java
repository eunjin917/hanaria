package com.hanaro.hanaria.dto.item;

import com.hanaro.hanaria.domain.item.Item;
import com.hanaro.hanaria.domain.option.Option;
import com.hanaro.hanaria.domain.product.Product;

public record ItemFindByOrderRequestDto(
        Integer count,
        Long request,
		Product productId,
        Option dessert_option_id,
        Option drink_option_id
) {
    public ItemFindByOrderRequestDto(Item entity) {
        this(
            entity.getCount(),
            entity.getRequest(),
            entity.getProductId(),
            entity.getDessertOptionId(),
            entity.getDrinkOptionId()
        );
    }
}
