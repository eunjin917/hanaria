package com.hanaro.hanaria.domain.coupon;

import com.hanaro.hanaria.domain.product.ProductService;
import com.hanaro.hanaria.domain.product.ProductType;
import com.hanaro.hanaria.dto.coupon.CouponFindAllResponseDto;
import com.hanaro.hanaria.dto.coupon.CouponFindByIdResponseDto;
import com.hanaro.hanaria.dto.group.GroupFindAllResponseDto;
import com.hanaro.hanaria.dto.product.ProductFindAllResponseDto;
import com.hanaro.hanaria.dto.product.ProductFindByIdResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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
