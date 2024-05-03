package com.hanaro.hanaria.domain;

import com.hanaro.hanaria.dto.CouponFindAllResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;

    @Transactional(readOnly = true)
    public List<CouponFindAllResponseDto> findAll() {
        List<Coupon> couponList = couponRepository.findAll();
        return couponList.stream().map(CouponFindAllResponseDto::new).toList();
    }
}
