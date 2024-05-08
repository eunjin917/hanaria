package com.hanaro.hanaria.domain.admin.coupon;

import com.hanaro.hanaria.domain.admin.product.Product;
import com.hanaro.hanaria.domain.admin.product.ProductRepository;
import com.hanaro.hanaria.dto.admin.coupon.CouponCreateRequestDto;
import com.hanaro.hanaria.dto.admin.coupon.CouponFindAllResponseDto;
import com.hanaro.hanaria.dto.admin.coupon.CouponFindByIdResponseDto;
import com.hanaro.hanaria.dto.admin.coupon.CouponUpdateRequestDto;
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

    @Transactional
    public boolean deleteById(Long id) {
        couponRepository.deleteById(id);
        return !couponRepository.existsById(id);
    }
}
