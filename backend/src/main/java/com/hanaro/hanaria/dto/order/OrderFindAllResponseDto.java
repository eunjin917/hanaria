package com.hanaro.hanaria.dto.order;

import com.hanaro.hanaria.domain.order.Order;
import com.hanaro.hanaria.domain.order.OrderMethod;
import com.hanaro.hanaria.domain.order.OrderStatus;
import com.hanaro.hanaria.dto.member.MemberFindByIdResponseDto;

import java.time.LocalDateTime;

public record
OrderFindAllResponseDto(
        Long id,
        LocalDateTime createdAt,
        String code,
        LocalDateTime paidAt,
        Integer tmpNo,
        Integer price,
        OrderMethod method,
        OrderStatus status,
        MemberFindByIdResponseDto member
) {
    public OrderFindAllResponseDto(Order entity) {
        this(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getCode(),
                entity.getPaidAt(),
                entity.getTmpNo(),
                entity.getPrice(),
                entity.getMethod(),
                entity.getStatus(),
                entity.getMember() != null ? new MemberFindByIdResponseDto(entity.getMember()) : null
        );
    }
}
