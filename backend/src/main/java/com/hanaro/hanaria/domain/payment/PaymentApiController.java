package com.hanaro.hanaria.domain.payment;

import com.hanaro.hanaria.dto.payment.PaymentCreateRequestDto;
import com.hanaro.hanaria.dto.payment.PaymentCreateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
//@Secured({"ADMIN"})
public class PaymentApiController {
    private final PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<PaymentCreateResponseDto> adminPaymentCreate(@RequestBody PaymentCreateRequestDto dto) {
        Payment payment = paymentService.create(dto);
        return ResponseEntity.ok(new PaymentCreateResponseDto(payment, payment.order.getTmpNo()));
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
