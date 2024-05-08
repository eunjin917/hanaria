package com.hanaro.hanaria.dto.order;

import com.hanaro.hanaria.domain.member.Member;
import com.hanaro.hanaria.domain.order.OrderMethod;
import com.hanaro.hanaria.domain.order.OrderStatus;
import com.hanaro.hanaria.dto.item.ItemCreateRequestDto;
import com.hanaro.hanaria.domain.order.Order;

import java.time.LocalDateTime;
import java.util.List;

public record OrderCreateRequestDto(
        Integer price,
        boolean isForHere,
        Long memberId,
        List<ItemCreateRequestDto> items
) {
    public Order toEntity(Member member, String code) {
        return Order.builder()
                .code(code)
                .paidAt(LocalDateTime.now())
                .tmpNo(null)
                .price(price)
                .method(isForHere ? OrderMethod.HERE : OrderMethod.TOGO)
                .status(OrderStatus.PAYING)
                .member(member)
                .build();
    }
}
