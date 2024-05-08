package com.hanaro.hanaria.dto.admin.group;

import com.hanaro.hanaria.domain.admin.group.Group;
import com.hanaro.hanaria.domain.admin.group.GroupCategory;

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
