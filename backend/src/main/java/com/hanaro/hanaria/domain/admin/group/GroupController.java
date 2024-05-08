package com.hanaro.hanaria.domain.admin.group;

import com.hanaro.hanaria.dto.admin.group.GroupFindAllResponseDto;
import com.hanaro.hanaria.dto.admin.group.GroupFindByIdResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admin")
@Controller
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/groups")
    public String adminGroups(Model model
    ) {
        List<GroupFindAllResponseDto> groupFindAllResponseDtoList = groupService.findAll();
        model.addAttribute("list", groupFindAllResponseDtoList);
        model.addAttribute("categories", GroupCategory.values());
        return "/pages/group/groups";
    }

    @GetMapping("/group/{id}")
    public String adminGroupDetail(Model model, @PathVariable(name = "id") Long id) {
        GroupFindByIdResponseDto dto = groupService.findById(id);
        model.addAttribute("group", dto);
        model.addAttribute("categories", GroupCategory.values());
        return "/pages/group/groupDetail";
    }

}
