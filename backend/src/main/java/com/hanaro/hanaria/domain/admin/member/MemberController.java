package com.hanaro.hanaria.domain.admin.member;

import com.hanaro.hanaria.dto.admin.member.MemberFindAllResponseDto;
import com.hanaro.hanaria.dto.admin.member.MemberFindByIdResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/admin")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members")
    public String adminMembers(Model model,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "limit", defaultValue = "5") int limit,
                               @RequestParam(name = "searchType", defaultValue = "") String searchType,
                               @RequestParam(name = "searchValue", defaultValue = "") String searchValue,
                               @RequestParam(name = "sortType", defaultValue = "usernameAsc") String sortType
    ) {
        Page<MemberFindAllResponseDto> memberResponseDtoPage = memberService.findPage(page, limit, searchType, searchValue, sortType);
        model.addAttribute("paging", memberResponseDtoPage);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchValue", searchValue);
        model.addAttribute("sortType", sortType);
        return "/pages/member/members";
    }

    @GetMapping("/member/{id}")
    public String adminMemberDetail(Model model, @PathVariable(name = "id") Long id) {
        MemberFindByIdResponseDto dto = memberService.findById(id);
        model.addAttribute("member", dto);
        return "/pages/member/memberDetail";
    }


}
