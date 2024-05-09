package com.hanaro.hanaria.domain.request;

import com.hanaro.hanaria.domain.group.Group;
import com.hanaro.hanaria.domain.group.GroupRepository;
import com.hanaro.hanaria.domain.payment.Payment;
import com.hanaro.hanaria.dto.group.GroupCreateRequestDto;
import com.hanaro.hanaria.dto.payment.PaymentFindAllResponseDto;
import com.hanaro.hanaria.dto.request.RequestCreateRequestDto;
import com.hanaro.hanaria.dto.request.RequestFindAllResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;
    private final GroupRepository groupRepository;

    @Transactional
    public boolean create(RequestCreateRequestDto dto) {
        Group group = groupRepository.findById(dto.groupId()).orElseThrow();
        Long id = requestRepository.save(dto.toEntity(group)).getId();
        return requestRepository.existsById(id);
    }

    @Transactional(readOnly = true)
    public List<RequestFindAllResponseDto> findAll() {
        List<Request> requestList = requestRepository.findAll();
        return requestList.stream().map(RequestFindAllResponseDto::new).toList();
    }

    @Transactional
    public boolean deleteById(Long id) {
        requestRepository.deleteById(id);
        return !requestRepository.existsById(id);
    }
}
