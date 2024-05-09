package com.hanaro.hanaria.domain.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findAllByOrderId(Long id);

    @Query("SELECT SUM(p.price) FROM Payment p WHERE p.order.id = :orderId")
    Integer sumPriceByOrderId(Long orderId);
}
