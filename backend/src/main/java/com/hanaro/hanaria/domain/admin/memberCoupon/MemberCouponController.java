package com.hanaro.hanaria.domain.admin.memberCoupon;

import com.hanaro.hanaria.domain.admin.coupon.CouponService;
import com.hanaro.hanaria.domain.admin.member.MemberService;
import com.hanaro.hanaria.dto.admin.coupon.CouponFindAllResponseDto;
import com.hanaro.hanaria.dto.admin.member.MemberFindAllResponseDto;
import com.hanaro.hanaria.dto.admin.memberCoupon.MemberCouponFindAllResponseDto;
import com.hanaro.hanaria.dto.admin.memberCoupon.MemberCouponFindByIdResponseDto;
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
