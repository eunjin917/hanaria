package com.hanaro.hanaria.domain.order;

import com.hanaro.hanaria.domain.item.ItemService;
import com.hanaro.hanaria.dto.order.OrderCreateRequestDto;
import com.hanaro.hanaria.dto.order.OrderCreateResponseDto;
import com.hanaro.hanaria.dto.order.OrderUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class OrderApiController {
    private final OrderService orderService;
    private final ItemService itemService;

    @PostMapping("/order")
    public ResponseEntity<OrderCreateResponseDto> adminOrderCreate(@RequestBody OrderCreateRequestDto dto) {
        Order order = orderService.create(dto);
        itemService.createAll(dto.items(), order.getId());
        return ResponseEntity.ok(new OrderCreateResponseDto(order.getId()));
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
