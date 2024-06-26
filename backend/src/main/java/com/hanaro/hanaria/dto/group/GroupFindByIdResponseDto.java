package com.hanaro.hanaria.dto.group;


import com.hanaro.hanaria.domain.group.Group;
import com.hanaro.hanaria.domain.group.GroupCategory;

import java.time.LocalDateTime;

public record GroupFindByIdResponseDto(
        Long id,
        LocalDateTime createdAt,
        String name,
        String nameEn,
        GroupCategory category
) {
    public GroupFindByIdResponseDto(Group entity) {
        this(entity.getId(), entity.getCreatedAt(), entity.getName(), entity.getNameEn(), entity.getCategory());
    }
}
