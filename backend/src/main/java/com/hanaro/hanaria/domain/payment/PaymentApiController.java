package com.hanaro.hanaria.domain.payment;

import com.hanaro.hanaria.domain.order.Order;
import com.hanaro.hanaria.domain.order.OrderService;
import com.hanaro.hanaria.dto.order.OrderUpdateRequestDto;
import com.hanaro.hanaria.dto.payment.PaymentCreateRequestDto;
import com.hanaro.hanaria.dto.payment.PaymentCreateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class PaymentApiController {
    private final PaymentService paymentService;
    private final OrderService orderService;

    @PostMapping("/payment")
    public ResponseEntity<PaymentCreateResponseDto> adminPaymentCreate(@RequestBody PaymentCreateRequestDto dto) {
        Payment payment = paymentService.create(dto);
        PaymentCreateResponseDto responseDto = paymentService.checkFinish(payment);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/payment")
    public ResponseEntity<String> adminPaymentDelete(@RequestParam(name = "id") Long id) {
        boolean isDeleted = paymentService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("결제정보가 삭제되었습니다.");
        } else {
            return ResponseEntity.internalServerError().body("결제정보 삭제에 실패하였습니다.");
        }
    }
}
