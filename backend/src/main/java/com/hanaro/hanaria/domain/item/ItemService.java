package com.hanaro.hanaria.domain.item;

import com.hanaro.hanaria.domain.member.Member;
import com.hanaro.hanaria.domain.option.Option;
import com.hanaro.hanaria.domain.option.OptionRepository;
import com.hanaro.hanaria.domain.order.Order;
import com.hanaro.hanaria.domain.order.OrderRepository;
import com.hanaro.hanaria.domain.product.Product;
import com.hanaro.hanaria.domain.product.ProductRepository;
import com.hanaro.hanaria.dto.item.ItemCreateRequestDto;
import com.hanaro.hanaria.dto.order.OrderCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OptionRepository optionRepository;

    @Transactional
    public boolean createAll(List<ItemCreateRequestDto> dtoList, Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        return dtoList.stream()
                .map(dto -> {
                    Product product = productRepository.findById(dto.productId()).orElseThrow();
                    Optional<Option> dessertOption = Optional.ofNullable(dto.dessertOptionId())
                            .flatMap(optionRepository::findById);
                    Optional<Option> drinkOption = Optional.ofNullable(dto.drinkOptionId())
                            .flatMap(optionRepository::findById);
                    Item item = dto.toEntity(order, product, dessertOption.orElse(null), drinkOption.orElse(null));
                    return itemRepository.save(item);
                })
                .allMatch(savedItem -> itemRepository.existsById(savedItem.getId()));
    }
}
