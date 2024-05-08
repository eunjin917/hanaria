package com.hanaro.hanaria.domain.admin.coupon;

import com.hanaro.hanaria.domain.admin.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@Table(name = "coupon")
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
    @Id
    @Column(name = "coupon_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "coupon_created_at")
    @Builder.Default
    LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "coupon_valid_at")
    LocalDateTime validAt;
    @Column(name = "coupon_expired_at")
    LocalDateTime expiredAt;
    @Column(name = "coupon_name")
    String name;
    @Column(name = "coupon_name_en")
    String nameEn;
    @Column(name = "coupon_price")
    Integer price;
    @ManyToOne
    @JoinColumn(name = "product_id", unique = false)
    Product product;
}
