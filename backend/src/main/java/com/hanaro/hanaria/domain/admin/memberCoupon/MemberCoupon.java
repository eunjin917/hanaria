package com.hanaro.hanaria.domain.admin.memberCoupon;

import com.hanaro.hanaria.domain.admin.coupon.Coupon;
import com.hanaro.hanaria.domain.admin.member.Member;
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
public class MemberCoupon {
    @Id
    @Column(name="member_coupon_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    Member member;
    @ManyToOne
    @JoinColumn(name = "coupon_id")
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
