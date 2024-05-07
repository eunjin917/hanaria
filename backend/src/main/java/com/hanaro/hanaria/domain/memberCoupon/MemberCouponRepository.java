package com.hanaro.hanaria.domain.memberCoupon;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberCouponRepository extends JpaRepository<MemberCoupon, Long> {
    Optional<MemberCoupon> findByMemberIdAndCouponId(Long memberId, Long couponId);
    void deleteByMemberIdAndCouponId(Long memberId, Long couponId);
    boolean existsByMemberIdAndCouponId(Long memberId, Long couponId);
}
