package com.hanaro.hanaria.domain.memberCoupon;

import com.hanaro.hanaria.domain.coupon.Coupon;
import com.hanaro.hanaria.domain.coupon.CouponRepository;
import com.hanaro.hanaria.domain.member.Member;
import com.hanaro.hanaria.domain.member.MemberRepository;
import com.hanaro.hanaria.domain.product.Product;
import com.hanaro.hanaria.dto.coupon.CouponCreateRequestDto;
import com.hanaro.hanaria.dto.coupon.CouponFindByIdResponseDto;
import com.hanaro.hanaria.dto.coupon.CouponUpdateRequestDto;
import com.hanaro.hanaria.dto.memberCoupon.MemberCouponCreateRequestDto;
import com.hanaro.hanaria.dto.memberCoupon.MemberCouponFindAllResponseDto;
import com.hanaro.hanaria.dto.memberCoupon.MemberCouponFindByIdResponseDto;
import com.hanaro.hanaria.dto.memberCoupon.MemberCouponUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
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
    public MemberCouponFindByIdResponseDto findByMemberIdAndCouponId(Long memberId, Long couponId) {
        return new MemberCouponFindByIdResponseDto(memberCouponRepository.findByMemberIdAndCouponId(memberId, couponId).orElseThrow());
    }

    @Transactional(readOnly = true)
    public List<MemberCouponFindAllResponseDto> findAll() {
        return memberCouponRepository.findAll().stream().map(MemberCouponFindAllResponseDto::new).toList();
    }

    @Transactional
    public boolean update(MemberCouponUpdateRequestDto dto) {
        Member member = memberRepository.findById(dto.memberId()).orElseThrow();
        Coupon coupon = couponRepository.findById(dto.couponId()).orElseThrow();
        Optional<MemberCoupon> optional = memberCouponRepository.findByMemberIdAndCouponId(dto.memberId(), dto.couponId());
        if (optional.isEmpty()) return false;
        memberCouponRepository.save(dto.toApplied(optional.get(), member, coupon));
        return true;
    }

    @Transactional
    public boolean deleteByMemberIdAndCouponId(Long memberId, Long couponId) {
        memberCouponRepository.deleteByMemberIdAndCouponId(memberId, couponId);
        return !memberCouponRepository.existsByMemberIdAndCouponId(memberId, couponId);
    }
}
