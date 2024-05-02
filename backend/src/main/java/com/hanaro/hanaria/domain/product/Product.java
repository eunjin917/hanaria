package com.hanaro.hanaria.domain.product;

import com.hanaro.hanaria.domain.group.Group;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@Entity
@Builder
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "product_created_at")
    @Builder.Default
    LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "product_price")
    Integer price;
    @Column(name = "product_name")
    String name;
    @Column(name = "product_name_en")
    String nameEn;
    @Column(name = "product_image")
    String image;
    @Column(name = "product_recommended")
    @Builder.Default
    boolean recommended = false;
    @Column(name = "product_type")
    ProductType type;
    @ManyToOne
    @JoinColumn(name = "group_id", unique = false)
    Group group;
}
