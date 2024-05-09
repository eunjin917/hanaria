package com.hanaro.hanaria.dto.request;

import com.hanaro.hanaria.domain.group.Group;
import com.hanaro.hanaria.domain.request.Request;

public record RequestCreateRequestDto(
        String body,
        Long groupId,
        Long bit
) {
    public Request toEntity(Group group) {
        return Request.builder()
                .body(body)
                .group(group)
                .groupCategory(group.getCategory())
                .bit(bit)
                .build();
    }
}
