package com.hanaro.hanaria.domain.group;


import com.hanaro.hanaria.domain.product.ProductRepository;
import com.hanaro.hanaria.dto.group.*;
import com.hanaro.hanaria.dto.product.ProductFindByCategoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final ProductRepository productRepository;
    
    @Transactional
    public boolean create(GroupCreateRequestDto dto) {
        Long id = groupRepository.save(dto.toEntity()).getId();
        return groupRepository.existsById(id);
    }

    @Transactional(readOnly = true)
    public GroupFindByIdResponseDto findById(Long id) {
        return new GroupFindByIdResponseDto(groupRepository.findById(id).orElseThrow());
    }

    @Transactional(readOnly = true)
    public List<CategoryFindAllResponseDto> findCategories() {
        return groupRepository.findCategories();
    }

    @Transactional(readOnly = true)
    public List<GroupFindByCategoryResponseDto> findByCategoryIdAndPageNo(Integer categoryValue, int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 6);
        Page<Group> pageContent = groupRepository.findByCategory(GroupCategory.values()[categoryValue], pageable);

        return pageContent.getContent().stream()
                .map(group -> {
                    List<ProductFindByCategoryResponseDto> productList = productRepository.findByGroupId(group.getId()).stream()
                            .map(ProductFindByCategoryResponseDto::new)
                            .collect(Collectors.toList());
                    return new GroupFindByCategoryResponseDto(group, productList);
                })
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<GroupFindAllResponseDto> findAll() {
        List<Group> groupList = groupRepository.findAll();
        return groupList.stream().map(GroupFindAllResponseDto::new).toList();
    }

    @Transactional
    public boolean update(GroupUpdateRequestDto dto) {
        Optional<Group> optional = groupRepository.findById(dto.groupId());
        if (optional.isEmpty()) return false;
        groupRepository.save(dto.toApplied(optional.get()));
        return true;
    }

    @Transactional
    public boolean deleteById(Long id) {
        groupRepository.deleteById(id);
        return !groupRepository.existsById(id);
    }

}
