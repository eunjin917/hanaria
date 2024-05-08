package com.hanaro.hanaria.domain.admin.product;


import com.hanaro.hanaria.domain.admin.group.Group;
import com.hanaro.hanaria.domain.admin.group.GroupRepository;
import com.hanaro.hanaria.dto.admin.product.ProductCreateRequestDto;
import com.hanaro.hanaria.dto.admin.product.ProductFindAllResponseDto;
import com.hanaro.hanaria.dto.admin.product.ProductFindByIdResponseDto;
import com.hanaro.hanaria.dto.admin.product.ProductUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final GroupRepository groupRepository;

    @Transactional
    public boolean create(ProductCreateRequestDto dto) {
        // dto에서 그룹 ID 받아옴, 그걸로 그룹 찾아서 넣어주기
        Group group = groupRepository.findById(dto.groupId()).orElseThrow();
        Long id = productRepository.save(dto.toEntity(group)).getId();
        return productRepository.existsById(id);
    }

    @Transactional(readOnly = true)
    public ProductFindByIdResponseDto findById(Long id) {
        return new ProductFindByIdResponseDto(productRepository.findById(id).orElseThrow());
    }

    @Transactional(readOnly = true)
    public List<ProductFindAllResponseDto> findAll() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(ProductFindAllResponseDto::new).toList();
    }

    @Transactional
    public boolean update(ProductUpdateRequestDto dto) {
        Group group = groupRepository.findById(dto.groupId()).orElseThrow();
        Optional<Product> optional = productRepository.findById(dto.productId());
        if (optional.isEmpty()) return false;
        productRepository.save(dto.toApplied(optional.get(), group));
        return true;
    }

    @Transactional
    public boolean deleteById(Long id) {
        productRepository.deleteById(id);
        return !productRepository.existsById(id);
    }

}
