package com.hanaro.hanaria.domain.coupon;

import com.hanaro.hanaria.dto.coupon.CouponFindAllResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CouponController {
    private final CouponService couponService;

    @GetMapping("/products")
    public String adminProducts(Model model
    ) {
        List<CouponFindAllResponseDto> couponFindAllResponseDtoList = couponService.findAll();
        model.addAttribute("list", couponFindAllResponseDtoList);
        return "/pages/coupon/coupons";
    }
}
