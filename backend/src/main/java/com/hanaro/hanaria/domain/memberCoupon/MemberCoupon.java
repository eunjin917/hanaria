package com.hanaro.hanaria.domain.memberCoupon;

import com.hanaro.hanaria.domain.coupon.Coupon;
import com.hanaro.hanaria.domain.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@Table(name = "member_coupon")
@NoArgsConstructor
@AllArgsConstructor
@IdClass(MemberCoupon.class)
public class MemberCoupon {
    @Id
    @ManyToOne
    @JoinColumn(name = "member_id", unique = false)
    Member member;
    @Id
    @ManyToOne
    @JoinColumn(name = "coupon_id", unique = false)
    Coupon coupon;
    @Column(name = "member_coupon_created_at")
    @Builder.Default
    LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "member_coupon_valid_at")
    LocalDateTime validAt;
    @Column(name = "member_coupon_expired_at")
    LocalDateTime expiredAt;
    @Column(name = "member_coupon_used_at")
    LocalDateTime usedAt;
}
