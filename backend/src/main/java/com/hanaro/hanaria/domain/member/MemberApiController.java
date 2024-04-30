package com.hanaro.hanaria.domain.member;

import com.hanaro.hanaria.dto.CommonResponseDto;
import com.hanaro.hanaria.dto.member.MemberJoinRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
//@Secured({"ADMIN"})
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping("/member")
    public String newMember(@ModelAttribute MemberJoinRequestDto dto) {
        boolean isAdded = memberService.join(dto);
        if (isAdded) {
            return "<script>alert('회원 추가됨');location.href='/members';</script>";
        } else {
            return "<script>alert('회원 추가 실패');history.back();</script>";
        }
    }

    @DeleteMapping("/member")
    public ResponseEntity adminMemberDelete(@RequestParam(name = "id") Long id) {
        boolean isDeleted = memberService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("회원이 삭제되었습니다.");
        } else {
            return ResponseEntity.internalServerError().body("회원 삭제에 실패하였습니다.");
        }
    }
}
