package com.hanaro.hanaria.domain.group;


import com.hanaro.hanaria.dto.group.GroupCreateRequestDto;
import com.hanaro.hanaria.dto.group.GroupFindAllResponseDto;
import com.hanaro.hanaria.dto.group.GroupFindByIdResponseDto;
import com.hanaro.hanaria.dto.group.GroupUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    
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
