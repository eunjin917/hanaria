package com.hanaro.hanaria.domain.payment;


import com.hanaro.hanaria.domain.order.Order;
import com.hanaro.hanaria.domain.order.OrderRepository;
import com.hanaro.hanaria.domain.order.OrderStatus;
import com.hanaro.hanaria.dto.order.OrderUpdateRequestDto;
import com.hanaro.hanaria.dto.payment.*;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public Payment create(PaymentCreateRequestDto dto) {
        Order order = orderRepository.findById(dto.orderId()).orElseThrow();
        // 0부터 999999 사이의 랜덤한 승인번호 생성
        int randomNumber = (int) (Math.random() * 1000000);
        String approvalNo = String.format("%06d", randomNumber);

        return paymentRepository.save(dto.toEntity(order, approvalNo));
    }

    @Transactional(readOnly = true)
    public PaymentFindByIdResponseDto findById(Long id) {
        return new PaymentFindByIdResponseDto(paymentRepository.findById(id).orElseThrow());
    }

    @Transactional(readOnly = true)
    public List<PaymentFindAllResponseDto> findAll() {
        List<Payment> paymentList = paymentRepository.findAll();
        return paymentList.stream().map(PaymentFindAllResponseDto::new).toList();
    }

    @Transactional
    public boolean deleteById(Long id) {
        paymentRepository.deleteById(id);
        return !paymentRepository.existsById(id);
    }

    @Transactional(readOnly = true)
    public List<PaymentFindByOrderIdResponseDto> findByOrderId(Long id) {
        List<Payment> paymentList = paymentRepository.findAllByOrderId(id);
        return paymentList.stream().map(PaymentFindByOrderIdResponseDto::new).toList();
    }

    @Transactional
    public PaymentCreateResponseDto checkFinish(Payment payment) {
        Order order = payment.order;
        Integer priceSum = paymentRepository.sumPriceByOrderId(order.getId());

        if (Objects.equals(priceSum, order.getPrice())) {
            // 임시번호 생성
            Integer tmpNo = orderRepository.getNextOrderTmpNoForToday();
            // 임시번호 + 상태 업데이트
            order.update(tmpNo, OrderStatus.PREPARING);
            orderRepository.save(order);

            return new PaymentCreateResponseDto(payment, tmpNo);
        }
        else {
            return new PaymentCreateResponseDto(payment, null);
        }
    }
}
