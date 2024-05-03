package com.hanaro.hanaria.domain.coupon;

import com.hanaro.hanaria.dto.coupon.CouponCreateRequestDto;
import com.hanaro.hanaria.dto.product.ProductCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class CouponApiController {
    private final CouponService couponService;

    @PostMapping("/coupon")
    public String adminCouponCreate(@ModelAttribute CouponCreateRequestDto dto) {
        boolean isAdded = couponService.create(dto);
        if (isAdded) {
            return "<script>alert('쿠폰이 추가되었습니다.');location.href='/coupons';</script>";
        } else {
            return "<script>alert('쿠폰 추가에 실패하였습니다.');history.back();</script>";
        }
    }
}
