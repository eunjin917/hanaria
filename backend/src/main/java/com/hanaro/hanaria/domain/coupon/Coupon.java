package com.hanaro.hanaria.domain;

import com.hanaro.hanaria.domain.product.Product;
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
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "product_created_at")
    @Builder.Default
    LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "product_expired_at")
    LocalDateTime expiredAt;
    @Column(name = "product_name")
    String name;
    @Column(name = "product_name_en")
    String nameEn;
    @Column(name = "product_price")
    Integer price;
    @ManyToOne
    @JoinColumn(name = "product_id", unique = false)
    Product product;
}
