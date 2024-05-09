package com.hanaro.hanaria.dto.request;

import com.hanaro.hanaria.domain.group.GroupCategory;
import com.hanaro.hanaria.domain.request.Request;
import com.hanaro.hanaria.dto.group.GroupFindByIdResponseDto;

import java.time.LocalDateTime;

public record RequestFindAllResponseDto(
        Long id,
        LocalDateTime createdAt,
        String body,
        GroupFindByIdResponseDto group,
        GroupCategory groupCategory,
        Long bit
) {
    public RequestFindAllResponseDto(Request entity) {
        this(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getBody(),
                new GroupFindByIdResponseDto(entity.getGroup()),
                entity.getGroupCategory(),
                entity.getBit()
        );
    }
}
