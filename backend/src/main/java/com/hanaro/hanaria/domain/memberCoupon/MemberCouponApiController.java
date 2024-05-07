package com.hanaro.hanaria.domain.memberCoupon;

import com.hanaro.hanaria.dto.coupon.CouponCreateRequestDto;
import com.hanaro.hanaria.dto.coupon.CouponUpdateRequestDto;
import com.hanaro.hanaria.dto.memberCoupon.MemberCouponCreateRequestDto;
import com.hanaro.hanaria.dto.memberCoupon.MemberCouponUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class MemberCouponApiController {
    private final MemberCouponService memberCouponService;

    @PostMapping("/member-coupon")
    public String adminMemberCouponCreate(@ModelAttribute MemberCouponCreateRequestDto dto) {
        boolean isAdded = memberCouponService.create(dto);
        if (isAdded) {
            return "<script>alert('회원쿠폰이 추가되었습니다.');location.href='/member-coupons';</script>";
        } else {
            return "<script>alert('회원쿠폰 추가에 실패하였습니다.');history.back();</script>";
        }
    }

    @PutMapping("/member-coupon")
    public ResponseEntity<String> adminMemberCouponUpdate(@RequestBody MemberCouponUpdateRequestDto dto) {
        boolean isUpdated = memberCouponService.update(dto);
        if (isUpdated) {
            return ResponseEntity.ok("회원쿠폰정보가 수정되었습니다.");
        } else {
            return ResponseEntity.internalServerError().body("존재하지 않는 회원쿠폰입니다.");
        }
    }

    @DeleteMapping("/member-coupon")
    public ResponseEntity<String> adminMemberCouponDelete(@RequestParam(name = "memberId") Long memberId, @RequestParam(name = "couponId") Long couponId) {
        boolean isDeleted = memberCouponService.deleteByMemberIdAndCouponId(memberId, couponId);
        if (isDeleted) {
            return ResponseEntity.ok("회원쿠폰이 삭제되었습니다.");
        } else {
            return ResponseEntity.internalServerError().body("회원쿠폰 삭제에 실패하였습니다.");
        }
    }
}
