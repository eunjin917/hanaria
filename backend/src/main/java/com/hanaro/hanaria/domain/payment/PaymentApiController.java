package com.hanaro.hanaria.domain.payment;

import com.hanaro.hanaria.dto.payment.PaymentCreateRequestDto;
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
    public String adminPaymentCreate(@ModelAttribute PaymentCreateRequestDto dto) {
        boolean isAdded = paymentService.create(dto);
        if (isAdded) {
            return "<script>alert('결제정보가 추가되었습니다.');location.href='/payments';</script>";
        } else {
            return "<script>alert('결제정보 추가에 실패하였습니다.');history.back();</script>";
        }
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
