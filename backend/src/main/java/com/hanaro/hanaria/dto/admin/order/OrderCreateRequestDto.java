package com.hanaro.hanaria.dto.admin.order;

import com.hanaro.hanaria.domain.admin.member.Member;
import com.hanaro.hanaria.domain.admin.order.Order;
import com.hanaro.hanaria.domain.admin.order.OrderMethod;
import com.hanaro.hanaria.domain.admin.order.OrderStatus;

public record OrderCreateRequestDto(
        OrderMethod method,
        OrderStatus status,
        Long memberId
) {
    public Order toEntity(Member member, String code, Integer tmpNo) {
        return Order.builder()
                .price(0)
                .method(method)
                .status(status)
                .member(member)
                .code(code)
                .tmpNo(tmpNo)
                .build();
    }
}
