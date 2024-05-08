package com.hanaro.hanaria.domain.admin.memberCoupon;

import com.hanaro.hanaria.domain.admin.coupon.Coupon;
import com.hanaro.hanaria.domain.admin.coupon.CouponRepository;
import com.hanaro.hanaria.domain.admin.member.Member;
import com.hanaro.hanaria.domain.admin.member.MemberRepository;
import com.hanaro.hanaria.dto.admin.memberCoupon.MemberCouponCreateRequestDto;
import com.hanaro.hanaria.dto.admin.memberCoupon.MemberCouponFindAllResponseDto;
import com.hanaro.hanaria.dto.admin.memberCoupon.MemberCouponFindByIdResponseDto;
import com.hanaro.hanaria.dto.admin.memberCoupon.MemberCouponUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberCouponService {
    private final MemberCouponRepository memberCouponRepository;
    private final MemberRepository memberRepository;
    private final CouponRepository couponRepository;

    @Transactional
    public boolean create(MemberCouponCreateRequestDto dto) {
        Member member = memberRepository.findById(dto.memberId()).orElseThrow();
        Coupon coupon = couponRepository.findById(dto.couponId()).orElseThrow();
        MemberCoupon entity = memberCouponRepository.save(dto.toEntity(member, coupon));
        if (entity.getMember().equals(member) && entity.getCoupon().equals(coupon)) {
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    public MemberCouponFindByIdResponseDto findById(Long id) {
        return new MemberCouponFindByIdResponseDto(memberCouponRepository.findById(id).orElseThrow());
    }

    @Transactional(readOnly = true)
    public List<MemberCouponFindAllResponseDto> findAll() {
        return memberCouponRepository.findAll().stream().map(MemberCouponFindAllResponseDto::new).toList();
    }

    @Transactional
    public boolean update(MemberCouponUpdateRequestDto dto) {
        Member member = memberRepository.findById(dto.memberId()).orElseThrow();
        Coupon coupon = couponRepository.findById(dto.couponId()).orElseThrow();
        Optional<MemberCoupon> optional = memberCouponRepository.findById(dto.memberCouponId());
        if (optional.isEmpty()) return false;
        memberCouponRepository.save(dto.toApplied(optional.get(), member, coupon));
        return true;
    }

    @Transactional
    public boolean deleteById(Long id) {
        memberCouponRepository.deleteById(id);
        return !memberCouponRepository.existsById(id);
    }
}
