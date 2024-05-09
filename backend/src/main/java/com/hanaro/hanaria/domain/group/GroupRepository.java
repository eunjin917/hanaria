package com.hanaro.hanaria.domain.group;


import com.hanaro.hanaria.dto.group.CategoryFindAllResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Page<Group> findByCategory(GroupCategory category, Pageable pageable);

    @Query(value = "SELECT group_category AS category, CEILING(COUNT(group_id) / 6) AS pageCount FROM `group` GROUP BY group_category ORDER BY group_category", nativeQuery = true)
    List<IPageCountByGroupCategory> findPageCountByGroupCategory();

    default List<CategoryFindAllResponseDto> findCategories(){
        List<IPageCountByGroupCategory> tuples = findPageCountByGroupCategory();
        return tuples.stream().map((tuple) -> new CategoryFindAllResponseDto(tuple.getCategory(), tuple.getPageCount())).toList();
    }

    interface IPageCountByGroupCategory{
        Integer getCategory();
        Integer getPageCount();
    }

}
