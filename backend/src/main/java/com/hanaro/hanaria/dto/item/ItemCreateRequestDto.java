package com.hanaro.hanaria.dto.item;

import com.hanaro.hanaria.domain.item.Item;
import com.hanaro.hanaria.domain.option.Option;
import com.hanaro.hanaria.domain.order.Order;
import com.hanaro.hanaria.domain.product.Product;

public record ItemCreateRequestDto(
        Integer count,
        Long request,
		Long productId,
        Long dessert_option_id,
        Long drink_option_id
) {
    public Item toEntity(Order order, Product product, Option dessertOption, Option drinkOption) {
        return Item.builder()
                .price(product.getPrice())
                .count(count)
                .request(request)
                .orderId(order)
                .productId(product)
                .dessertOptionId(dessertOption)
                .drinkOptionId(drinkOption)
                .build();
    }
}
