package com.hanaro.hanaria.domain.memberCoupon;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberCouponRepository extends JpaRepository<MemberCoupon, Long> {
    List<MemberCoupon> findAllByMemberId(Long memberId);
}
