package com.hanaro.hanaria.domain.request;

import com.hanaro.hanaria.dto.group.GroupCreateRequestDto;
import com.hanaro.hanaria.dto.request.RequestCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class RequestApiController {
    private final RequestService requestService;

    @PostMapping("/request")
    public String adminRequestCreate(@ModelAttribute RequestCreateRequestDto dto) {
        boolean isAdded = requestService.create(dto);
        if (isAdded) {
            return "<script>alert('요청사항이 추가되었습니다.');location.href='/requests';</script>";
        } else {
            return "<script>alert('요청사항 추가에 실패하였습니다.');history.back();</script>";
        }
    }
}
