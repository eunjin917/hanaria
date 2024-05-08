package com.hanaro.hanaria.domain.admin.group;

import com.hanaro.hanaria.dto.admin.group.GroupCreateRequestDto;
import com.hanaro.hanaria.dto.admin.group.GroupUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
//@Secured({"ADMIN"})
public class GroupApiController {
    private final GroupService groupService;

    @PostMapping("/group")
    public String adminGroupCreate(@ModelAttribute GroupCreateRequestDto dto) {
        boolean isAdded = groupService.create(dto);
        if (isAdded) {
            return "<script>alert('상품그룹이 추가되었습니다.');location.href='/groups';</script>";
        } else {
            return "<script>alert('상품그룹 추가에 실패하였습니다.');history.back();</script>";
        }
    }

    @PutMapping("/group")
    public ResponseEntity<String> adminGroupUpdate(@RequestBody GroupUpdateRequestDto dto) {
        boolean isUpdated = groupService.update(dto);
        if (isUpdated) {
            return ResponseEntity.ok("상품그룹정보가 수정되었습니다.");
        } else {
            return ResponseEntity.internalServerError().body("존재하지 않는 상품그룹입니다.");
        }
    }

    @DeleteMapping("/group")
    public ResponseEntity<String> adminGroupDelete(@RequestParam(name = "id") Long id) {
        boolean isDeleted = groupService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("상품그룹이 삭제되었습니다.");
        } else {
            return ResponseEntity.internalServerError().body("상품그룹 삭제에 실패하였습니다.");
        }
    }
}
