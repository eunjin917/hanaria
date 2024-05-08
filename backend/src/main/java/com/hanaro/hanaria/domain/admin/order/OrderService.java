package com.hanaro.hanaria.domain.admin.order;


import com.hanaro.hanaria.domain.admin.member.Member;
import com.hanaro.hanaria.domain.admin.member.MemberRepository;
import com.hanaro.hanaria.dto.admin.order.OrderCreateRequestDto;
import com.hanaro.hanaria.dto.admin.order.OrderFindAllResponseDto;
import com.hanaro.hanaria.dto.admin.order.OrderFindByIdResponseDto;
import com.hanaro.hanaria.dto.admin.order.OrderUpdateRequestDto;
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
    public boolean create(OrderCreateRequestDto dto) {
        // dto에서 그룹 ID 받아옴, 그걸로 그룹 찾아서 넣어주기
        System.out.println(dto);
        Member member = memberRepository.findById(dto.memberId()).orElse(null);
        String code = UUID.randomUUID().toString();
        Integer tmpNo = orderRepository.getNextOrderTmpNoForToday();
        Long id = orderRepository.save(dto.toEntity(member, code, tmpNo)).getId();
        return orderRepository.existsById(id);
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
    public boolean deleteById(Long id) {
        orderRepository.deleteById(id);
        return !orderRepository.existsById(id);
    }

}
