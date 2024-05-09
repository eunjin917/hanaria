package com.hanaro.hanaria.domain.auth;

import com.hanaro.hanaria.domain.member.Member;
import com.hanaro.hanaria.domain.member.MemberService;
import com.hanaro.hanaria.dto.auth.JoinRequestDto;
import com.hanaro.hanaria.dto.auth.LoginRequestDto;
import com.hanaro.hanaria.dto.auth.LoginResponseDto;
import com.hanaro.hanaria.dto.member.MemberCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<String> authJoin(@RequestBody JoinRequestDto dto) {
        boolean alreadyExist = memberService.existsByUsername(dto.username());
        if (alreadyExist) {
            return ResponseEntity.badRequest().body("이미 가입한 username 입니다.");
        }

        boolean isAdded = memberService.join(dto);
        if (isAdded) {
            return ResponseEntity.ok("회원가입 되었습니다.");
        }

        return ResponseEntity.internalServerError().body("회원가입에 실패하였습니다.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> authLogin(@RequestBody LoginRequestDto dto) {
        Member member = memberService.findByUsernameAndPassword(dto);
        if (member != null) {
            LoginResponseDto loginResponseDto = memberService.login(member);
            return ResponseEntity.ok(loginResponseDto);
        } else {
            return ResponseEntity.badRequest().body("로그인에 실패하였습니다.");
        }
    }
}
