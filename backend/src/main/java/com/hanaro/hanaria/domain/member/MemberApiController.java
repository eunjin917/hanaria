package com.hanaro.hanaria.domain.member;

import com.hanaro.hanaria.dto.member.MemberCreateRequestDto;
import com.hanaro.hanaria.dto.member.MemberUpdateRequestDto;
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
    public String adminMemberCreate(@ModelAttribute MemberCreateRequestDto dto) {
        boolean isAdded = memberService.create(dto);
        if (isAdded) {
            return "<script>alert('회원이 추가되었습니다.');location.href='/members';</script>";
        } else {
            return "<script>alert('회원 추가에 실패하였습니다.');history.back();</script>";
        }
    }

    @PutMapping("/member")
    public ResponseEntity<String> adminMemberUpdate(@RequestBody MemberUpdateRequestDto dto) {
        System.out.println(dto);
        boolean isUpdated = memberService.update(dto);
        if (isUpdated) {
            return ResponseEntity.ok("회원정보가 수정되었습니다.");
        } else {
            return ResponseEntity.internalServerError().body("존재하지 않는 회원입니다.");
        }
    }

    @DeleteMapping("/member")
    public ResponseEntity<String> adminMemberDelete(@RequestParam(name = "id") Long id) {
        boolean isDeleted = memberService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("회원이 삭제되었습니다.");
        } else {
            return ResponseEntity.internalServerError().body("회원 삭제에 실패하였습니다.");
        }
    }
}
