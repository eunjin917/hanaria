package com.hanaro.hanaria.domain.order;


import com.hanaro.hanaria.domain.member.Member;
import com.hanaro.hanaria.domain.member.MemberRepository;
import com.hanaro.hanaria.dto.order.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Order create(OrderCreateRequestDto dto) {
        Member member = memberRepository.findById(dto.memberId()).orElse(null);
        String code = UUID.randomUUID().toString();
        return orderRepository.save(dto.toEntity(member, code));
    }

    @Transactional(readOnly = true)
    public OrderFindByIdResponseDto findById(Long id) {
        return new OrderFindByIdResponseDto(orderRepository.findById(id).orElseThrow());
    }

    @Transactional(readOnly = true)
    public List<OrderFindAllResponseDto> findAll() {
        List<Order> optionList = orderRepository.findAll();
        return optionList.stream().map(OrderFindAllResponseDto::new).toList();
    }

    @Transactional
    public boolean update(OrderUpdateRequestDto dto) {
        Member member = memberRepository.findById(dto.memberId()).orElse(null);
        Optional<Order> optional = orderRepository.findById(dto.orderId());
        if (optional.isEmpty()) return false;
        orderRepository.save(dto.toApplied(optional.get(), member));
        return true;
    }

    @Transactional
    public boolean updateTmpNo() {
        Integer tmpNo = orderRepository.getNextOrderTmpNoForToday();
        return true;
    }



    @Transactional
    public boolean deleteById(Long id) {
        orderRepository.deleteById(id);
        return !orderRepository.existsById(id);
    }

}
