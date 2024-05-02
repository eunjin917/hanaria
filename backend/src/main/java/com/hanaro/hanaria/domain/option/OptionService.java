package com.hanaro.hanaria.domain.option;


import com.hanaro.hanaria.domain.product.Product;
import com.hanaro.hanaria.domain.product.ProductRepository;
import com.hanaro.hanaria.dto.option.OptionCreateRequestDto;
import com.hanaro.hanaria.dto.option.OptionFindAllResponseDto;
import com.hanaro.hanaria.dto.option.OptionFindByIdResponseDto;
import com.hanaro.hanaria.dto.option.OptionUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OptionService {
    private final OptionRepository optionRepository;
    private final ProductRepository productRepository;

    @Transactional
    public boolean create(OptionCreateRequestDto dto) {
        // dto에서 그룹 ID 받아옴, 그걸로 그룹 찾아서 넣어주기
        Product product = productRepository.findById(dto.productId()).orElseThrow();
        Long id = optionRepository.save(dto.toEntity(product)).getId();
        return optionRepository.existsById(id);
    }

    @Transactional(readOnly = true)
    public OptionFindByIdResponseDto findById(Long id) {
        return new OptionFindByIdResponseDto(optionRepository.findById(id).orElseThrow());
    }

    @Transactional(readOnly = true)
    public List<OptionFindAllResponseDto> findAll() {
        List<Option> optionList = optionRepository.findAll();
        return optionList.stream().map(OptionFindAllResponseDto::new).toList();
    }

    @Transactional
    public boolean update(OptionUpdateRequestDto dto) {
        Product product = productRepository.findById(dto.productId()).orElseThrow();
        Optional<Option> optional = optionRepository.findById(dto.optionId());
        if (optional.isEmpty()) return false;
        optionRepository.save(dto.toApplied(optional.get(), product));
        return true;
    }

    @Transactional
    public boolean deleteById(Long id) {
        optionRepository.deleteById(id);
        return !optionRepository.existsById(id);
    }

}
