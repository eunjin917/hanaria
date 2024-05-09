package com.hanaro.hanaria.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT MAX(o.tmpNo) FROM Order o WHERE DATE(o.createdAt) = CURRENT_DATE")
    Optional<Integer> findMaxOrderTmpNoForToday();

    default Integer getNextOrderTmpNoForToday() {
        Optional<Integer> maxOrderTmpNo = findMaxOrderTmpNoForToday();
        return maxOrderTmpNo.orElse(0) + 1;
    }
}
