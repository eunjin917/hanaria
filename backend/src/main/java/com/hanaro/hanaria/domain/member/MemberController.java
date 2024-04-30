package com.hanaro.hanaria.domain.member;

import com.hanaro.hanaria.dto.member.MemberFindAllResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members")
    public String adminMember(Model model,
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


}
