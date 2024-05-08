package com.hanaro.hanaria.dto.admin.order;

import com.hanaro.hanaria.domain.admin.order.Order;
import com.hanaro.hanaria.domain.admin.order.OrderMethod;
import com.hanaro.hanaria.domain.admin.order.OrderStatus;
import com.hanaro.hanaria.dto.admin.member.MemberFindByIdResponseDto;

import java.time.LocalDateTime;

public record
OrderFindByIdResponseDto(
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
    public OrderFindByIdResponseDto(Order entity) {
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
