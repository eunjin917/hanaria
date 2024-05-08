package com.hanaro.hanaria.domain.admin.option;

import com.hanaro.hanaria.dto.admin.option.OptionCreateRequestDto;
import com.hanaro.hanaria.dto.admin.option.OptionUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
//@Secured({"ADMIN"})
public class OptionApiController {
    private final OptionService optionService;

    @PostMapping("/option")
    public String adminOptionCreate(@ModelAttribute OptionCreateRequestDto dto) {
        boolean isAdded = optionService.create(dto);
        if (isAdded) {
            return "<script>alert('상품옵션이 추가되었습니다.');location.href='/admin/options';</script>";
        } else {
            return "<script>alert('상품옵션 추가에 실패하였습니다.');history.back();</script>";
        }
    }

    @PutMapping("/option")
    public ResponseEntity<String> adminOptionUpdate(@RequestBody OptionUpdateRequestDto dto) {
        boolean isUpdated = optionService.update(dto);
        if (isUpdated) {
            return ResponseEntity.ok("상품옵션정보가 수정되었습니다.");
        } else {
            return ResponseEntity.internalServerError().body("존재하지 않는 상품옵션입니다.");
        }
    }

    @DeleteMapping("/option")
    public ResponseEntity<String> adminOptionDelete(@RequestParam(name = "id") Long id) {
        boolean isDeleted = optionService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("상품옵션이 삭제되었습니다.");
        } else {
            return ResponseEntity.internalServerError().body("상품옵션 삭제에 실패하였습니다.");
        }
    }
}
