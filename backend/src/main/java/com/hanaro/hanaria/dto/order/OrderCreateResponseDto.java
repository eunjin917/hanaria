package com.hanaro.hanaria.dto.order;

import com.hanaro.hanaria.domain.order.Order;

public record OrderCreateResponseDto(
        Long orderId
) {
    public OrderCreateResponseDto(Order entity) {
        this(entity.getId());
    }
}
