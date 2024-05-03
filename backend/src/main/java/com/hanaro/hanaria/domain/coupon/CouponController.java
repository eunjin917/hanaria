package com.hanaro.hanaria.domain.coupon;

import com.hanaro.hanaria.domain.product.ProductService;
import com.hanaro.hanaria.dto.coupon.CouponFindAllResponseDto;
import com.hanaro.hanaria.dto.product.ProductFindAllResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CouponController {
    private final CouponService couponService;
    private final ProductService productService;

    @GetMapping("/coupons")
    public String adminCoupons(Model model
    ) {
        List<CouponFindAllResponseDto> couponFindAllResponseDtoList = couponService.findAll();
        List<ProductFindAllResponseDto> productFindAllResponseDtoList = productService.findAll();
        model.addAttribute("list", couponFindAllResponseDtoList);
        model.addAttribute("products", productFindAllResponseDtoList);
        return "/pages/coupon/coupons";
    }
}
