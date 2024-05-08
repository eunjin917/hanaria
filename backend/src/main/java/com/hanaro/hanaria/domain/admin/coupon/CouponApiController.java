package com.hanaro.hanaria.domain.admin.coupon;

import com.hanaro.hanaria.dto.admin.coupon.CouponCreateRequestDto;
import com.hanaro.hanaria.dto.admin.coupon.CouponUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class CouponApiController {
    private final CouponService couponService;

    @PostMapping("/coupon")
    public String adminCouponCreate(@ModelAttribute CouponCreateRequestDto dto) {
        boolean isAdded = couponService.create(dto);
        if (isAdded) {
            return "<script>alert('쿠폰이 추가되었습니다.');location.href='/admin/coupons';</script>";
        } else {
            return "<script>alert('쿠폰 추가에 실패하였습니다.');history.back();</script>";
        }
    }

    @PutMapping("/coupon")
    public ResponseEntity<String> adminCouponUpdate(@RequestBody CouponUpdateRequestDto dto) {
        boolean isUpdated = couponService.update(dto);
        if (isUpdated) {
            return ResponseEntity.ok("쿠폰정보가 수정되었습니다.");
        } else {
            return ResponseEntity.internalServerError().body("존재하지 않는 쿠폰입니다.");
        }
    }

    @DeleteMapping("/coupon")
    public ResponseEntity<String> adminCouponDelete(@RequestParam(name = "id") Long id) {
        boolean isDeleted = couponService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("쿠폰이 삭제되었습니다.");
        } else {
            return ResponseEntity.internalServerError().body("쿠폰 삭제에 실패하였습니다.");
        }
    }
}
