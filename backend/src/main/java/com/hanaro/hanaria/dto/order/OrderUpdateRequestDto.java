package com.hanaro.hanaria.dto.order;

import com.hanaro.hanaria.domain.member.Member;
import com.hanaro.hanaria.domain.order.Order;
import com.hanaro.hanaria.domain.order.OrderMethod;
import com.hanaro.hanaria.domain.order.OrderStatus;

import java.time.LocalDateTime;

public record OrderUpdateRequestDto(
        Long orderId,
        LocalDateTime paidAt,
        OrderMethod method,
        OrderStatus status,
        Long memberId
) {
    public Order toApplied(Order order, Member member) {
        return Order.builder()
                .id(orderId)
                .paidAt(paidAt)
                .method(method)
                .status(status)
                .member(member)
                .code(order.getCode())
                .tmpNo(order.getTmpNo())
                .price(order.getPrice())
                .createdAt(order.getCreatedAt())
                .build();
    }
}
