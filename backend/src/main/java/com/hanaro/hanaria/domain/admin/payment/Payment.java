package com.hanaro.hanaria.domain.admin.payment;

import com.hanaro.hanaria.domain.admin.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@Entity
@Builder
@Table(name = "payment")
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "payment_created_at")
    @Builder.Default
    LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "payment_price")
    Integer price;
    @Column(name = "payment_card_type")
    String cardType;
    @Column(name = "payment_approval_no")
    String approvalNo;
    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;
}
