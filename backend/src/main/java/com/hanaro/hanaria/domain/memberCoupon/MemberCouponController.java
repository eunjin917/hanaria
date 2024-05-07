package com.hanaro.hanaria.domain.memberCoupon;

import com.hanaro.hanaria.domain.coupon.CouponService;
import com.hanaro.hanaria.domain.member.MemberService;
import com.hanaro.hanaria.dto.coupon.CouponFindAllResponseDto;
import com.hanaro.hanaria.dto.coupon.CouponFindByIdResponseDto;
import com.hanaro.hanaria.dto.member.MemberFindAllResponseDto;
import com.hanaro.hanaria.dto.memberCoupon.MemberCouponFindAllResponseDto;
import com.hanaro.hanaria.dto.memberCoupon.MemberCouponFindByIdResponseDto;
import com.hanaro.hanaria.dto.product.ProductFindAllResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberCouponController {
    private final MemberCouponService memberCouponService;
    private final MemberService memberService;
    private final CouponService couponService;

    @GetMapping("/member-coupons")
    public String adminMemberCoupons(Model model) {
        List<MemberCouponFindAllResponseDto> memberCouponFindAllResponseDtoList = memberCouponService.findAll();
        List<MemberFindAllResponseDto> memberFindAllResponseDtoList = memberService.findAll();
        List<CouponFindAllResponseDto> couponFindAllResponseDtoList = couponService.findAll();
        model.addAttribute("list", memberCouponFindAllResponseDtoList);
        model.addAttribute("members", memberFindAllResponseDtoList);
        model.addAttribute("coupons", couponFindAllResponseDtoList);
        return "/pages/memberCoupon/memberCoupons";
    }

    @GetMapping("/member-coupon/{id}")
    public String adminProductDetail(Model model, @PathVariable(name = "id") Long id) {
        MemberCouponFindByIdResponseDto dto = memberCouponService.findById(id);
        List<MemberFindAllResponseDto> memberFindAllResponseDtoList = memberService.findAll();
        List<CouponFindAllResponseDto> couponFindAllResponseDtoList = couponService.findAll();
        model.addAttribute("memberCoupon", dto);
        model.addAttribute("members", memberFindAllResponseDtoList);
        model.addAttribute("coupons", couponFindAllResponseDtoList);
        return "/pages/memberCoupon/memberCouponDetail";
    }
}
