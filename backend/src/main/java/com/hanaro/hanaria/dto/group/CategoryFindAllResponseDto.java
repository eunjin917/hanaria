package com.hanaro.hanaria.dto.group;

import com.hanaro.hanaria.domain.group.Group;
import com.hanaro.hanaria.domain.group.GroupCategory;

public record CategoryFindAllDto (
        Integer id,
        String name,
        String nameEn,
        Integer pageCnt
){
    public CategoryFindAllDto(Integer category, Integer pageCount) {
        this(
                category,
                GroupCategory.values()[category].getValue_ko(),
                GroupCategory.values()[category].getValue_en(),
                pageCount
        );
    }
}
