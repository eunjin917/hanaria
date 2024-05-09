package com.hanaro.hanaria.dto.group;

import com.hanaro.hanaria.domain.group.Group;
import com.hanaro.hanaria.domain.group.GroupCategory;

public record GroupCreateRequestDto(
        String name,
        String nameEn,
        GroupCategory category
) {
    public Group toEntity() {
        return Group.builder()
                .name(name)
                .nameEn(nameEn)
                .category(category)
                .build();
    }
}
