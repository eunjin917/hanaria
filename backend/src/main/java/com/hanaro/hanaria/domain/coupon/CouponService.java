package com.hanaro.hanaria.domain.coupon;

import com.hanaro.hanaria.domain.group.Group;
import com.hanaro.hanaria.domain.product.Product;
import com.hanaro.hanaria.domain.product.ProductRepository;
import com.hanaro.hanaria.dto.coupon.CouponCreateRequestDto;
import com.hanaro.hanaria.dto.coupon.CouponFindAllResponseDto;
import com.hanaro.hanaria.dto.product.ProductCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;
    private final ProductRepository productRepository;

    @Transactional
    public boolean create(CouponCreateRequestDto dto) {
        Product product = productRepository.findById(dto.productId()).orElseThrow();
        Long id = couponRepository.save(dto.toEntity(product)).getId();
        return couponRepository.existsById(id);
    }

    @Transactional(readOnly = true)
    public List<CouponFindAllResponseDto> findAll() {
        List<Coupon> couponList = couponRepository.findAll();
        return couponList.stream().map(CouponFindAllResponseDto::new).toList();
    }
}
