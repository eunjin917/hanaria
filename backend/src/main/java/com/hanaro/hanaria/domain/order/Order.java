package com.hanaro.hanaria.domain.order;

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
@Table(name = "`order`")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "order_created_at")
    @Builder.Default
    LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "order_code")
    String code;
    @Column(name = "order_paid_at")
    LocalDateTime paidAt;
    @Column(name = "order_tmp_no")
    Integer tmpNo;
    @Column(name = "order_price")
    Integer price;
    @Column(name = "order_method")
    OrderMethod method;
    @Column(name = "order_status")
    OrderStatus status;
    @ManyToOne
    @JoinColumn(name = "member_id", unique = false)
    Member member;

    public void update(Integer tmpNo, OrderStatus status) {
        this.tmpNo = tmpNo;
        this.status = status;
    }
}
