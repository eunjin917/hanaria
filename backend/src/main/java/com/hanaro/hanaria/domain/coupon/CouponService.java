package com.hanaro.hanaria.domain.coupon;

import com.hanaro.hanaria.domain.group.Group;
import com.hanaro.hanaria.domain.product.Product;
import com.hanaro.hanaria.domain.product.ProductRepository;
import com.hanaro.hanaria.dto.coupon.CouponCreateRequestDto;
import com.hanaro.hanaria.dto.coupon.CouponFindAllResponseDto;
import com.hanaro.hanaria.dto.coupon.CouponFindByIdResponseDto;
import com.hanaro.hanaria.dto.coupon.CouponUpdateRequestDto;
import com.hanaro.hanaria.dto.product.ProductCreateRequestDto;
import com.hanaro.hanaria.dto.product.ProductFindByIdResponseDto;
import com.hanaro.hanaria.dto.product.ProductUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public CouponFindByIdResponseDto findById(Long id) {
        return new CouponFindByIdResponseDto(couponRepository.findById(id).orElseThrow());
    }

    @Transactional(readOnly = true)
    public List<CouponFindAllResponseDto> findAll() {
        List<Coupon> couponList = couponRepository.findAll();
        return couponList.stream().map(CouponFindAllResponseDto::new).toList();
    }

    @Transactional
    public boolean update(CouponUpdateRequestDto dto) {
        Product product = productRepository.findById(dto.productId()).orElseThrow();
        Optional<Coupon> optional = couponRepository.findById(dto.couponId());
        if (optional.isEmpty()) return false;
        couponRepository.save(dto.toApplied(optional.get(), product));
        return true;
    }
}
