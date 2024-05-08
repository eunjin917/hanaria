package com.hanaro.hanaria.dto.admin.group;

import com.hanaro.hanaria.domain.admin.group.Group;
import com.hanaro.hanaria.domain.admin.group.GroupCategory;

public record GroupUpdateRequestDto(
        Long groupId,
        String name,
        String nameEn,
        GroupCategory category
) {
    public Group toApplied(Group group) {
        return Group.builder()
                .id(groupId)
                .name(name)
                .nameEn(nameEn)
                .category(category)
                .createdAt(group.getCreatedAt())
                .build();
    }
}
