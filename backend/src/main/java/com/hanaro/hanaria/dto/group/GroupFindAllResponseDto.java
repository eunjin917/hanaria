package com.hanaro.hanaria.dto.group;


import com.hanaro.hanaria.domain.group.Group;
import com.hanaro.hanaria.domain.group.GroupCategory;

import java.time.LocalDateTime;

public record GroupFindAllResponseDto(
        Long id,
        LocalDateTime createdAt,
        String name,
        String nameEn,
        GroupCategory category
) {
    public GroupFindAllResponseDto(Group entity) {
        this(entity.getId(), entity.getCreatedAt(), entity.getName(), entity.getNameEn(), entity.getCategory());
    }
}
