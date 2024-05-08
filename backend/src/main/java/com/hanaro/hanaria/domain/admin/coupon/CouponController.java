package com.hanaro.hanaria.domain.admin.coupon;

import com.hanaro.hanaria.domain.admin.product.ProductService;
import com.hanaro.hanaria.dto.admin.coupon.CouponFindAllResponseDto;
import com.hanaro.hanaria.dto.admin.coupon.CouponFindByIdResponseDto;
import com.hanaro.hanaria.dto.admin.product.ProductFindAllResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admin")
@Controller
@RequiredArgsConstructor
public class CouponController {
    private final CouponService couponService;
    private final ProductService productService;

    @GetMapping("/coupons")
    public String adminCoupons(Model model) {
        List<CouponFindAllResponseDto> couponFindAllResponseDtoList = couponService.findAll();
        List<ProductFindAllResponseDto> productFindAllResponseDtoList = productService.findAll();
        model.addAttribute("list", couponFindAllResponseDtoList);
        model.addAttribute("products", productFindAllResponseDtoList);
        return "/pages/coupon/coupons";
    }

    @GetMapping("/coupon/{id}")
    public String adminProductDetail(Model model, @PathVariable(name = "id") Long id) {
        CouponFindByIdResponseDto dto = couponService.findById(id);
        List<ProductFindAllResponseDto> productFindAllResponseDtoList = productService.findAll();
        model.addAttribute("coupon", dto);
        model.addAttribute("products", productFindAllResponseDtoList);
        return "/pages/coupon/couponDetail";
    }
}
