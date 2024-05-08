package com.hanaro.hanaria.domain.admin.order;

import com.hanaro.hanaria.dto.admin.order.OrderCreateRequestDto;
import com.hanaro.hanaria.dto.admin.order.OrderUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
//@Secured({"ADMIN"})
public class OrderApiController {
    private final OrderService orderService;

    @PostMapping("/order")
    public String adminOrderCreate(@ModelAttribute OrderCreateRequestDto dto) {
        boolean isAdded = orderService.create(dto);
        if (isAdded) {
            return "<script>alert('주문이 추가되었습니다.');location.href='/admin/orders';</script>";
        } else {
            return "<script>alert('주문 추가에 실패하였습니다.');history.back();</script>";
        }
    }

    @PutMapping("/order")
    public ResponseEntity<String> adminOrderUpdate(@RequestBody OrderUpdateRequestDto dto) {
        boolean isUpdated = orderService.update(dto);
        if (isUpdated) {
            return ResponseEntity.ok("주문정보가 수정되었습니다.");
        } else {
            return ResponseEntity.internalServerError().body("존재하지 않는 주문입니다.");
        }
    }

    @DeleteMapping("/order")
    public ResponseEntity<String> adminOrderDelete(@RequestParam(name = "id") Long id) {
        boolean isDeleted = orderService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("주문이 삭제되었습니다.");
        } else {
            return ResponseEntity.internalServerError().body("주문 삭제에 실패하였습니다.");
        }
    }
}
