package com.hanaro.hanaria.domain.option;

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
@Table(name = "`option`")
@NoArgsConstructor
@AllArgsConstructor
public class Option {
    @Id
    @Column(name = "option_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "option_created_at")
    @Builder.Default
    LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "option_price")
    Integer price;
    @Column(name = "option_category")
    OptionCategory category;
    @ManyToOne
    @JoinColumn(name = "product_id", unique = false)
    Product product;
}
