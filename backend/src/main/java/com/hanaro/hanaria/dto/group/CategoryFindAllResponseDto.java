package com.hanaro.hanaria.dto.group;

import com.hanaro.hanaria.domain.group.GroupCategory;

public record CategoryFindAllResponseDto(
        Integer id,
        String name,
        String nameEn,
        Integer pageCnt
){
    public CategoryFindAllResponseDto(Integer category, Integer pageCount) {
        this(
                category,
                GroupCategory.values()[category].getValue_ko(),
                GroupCategory.values()[category].getValue_en(),
                pageCount
        );
    }
}
