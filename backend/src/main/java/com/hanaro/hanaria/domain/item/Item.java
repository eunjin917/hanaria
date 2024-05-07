package com.hanaro.hanaria.domain.item;

import com.hanaro.hanaria.domain.option.Option;
import com.hanaro.hanaria.domain.order.Order;
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
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "item_created_at")
    @Builder.Default
    LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "item_price")
    Integer price;
    @Column(name = "item_count")
    Integer count;
    @Column(name = "item_request")
    Long request;
    @ManyToOne
    @JoinColumn(name = "order_id")
    Order orderId;
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product productId;
    @ManyToOne
    @JoinColumn(name = "dessert_option_id")
    Option dessertOption;
    @ManyToOne
    @JoinColumn(name = "drink_option_id")
    Option drinkOption;
}