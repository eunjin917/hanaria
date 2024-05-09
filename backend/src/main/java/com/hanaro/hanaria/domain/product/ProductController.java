package com.hanaro.hanaria.domain.product;

import com.hanaro.hanaria.domain.group.GroupService;
import com.hanaro.hanaria.dto.group.GroupFindAllResponseDto;
import com.hanaro.hanaria.dto.product.ProductFindAllResponseDto;
import com.hanaro.hanaria.dto.product.ProductFindByIdResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final GroupService groupService;

    @GetMapping("/products")
    public String adminProducts(Model model
    ) {
        List<ProductFindAllResponseDto> productFindAllResponseDtoList = productService.findAll();
        List<GroupFindAllResponseDto> groupFindAllResponseDtoList = groupService.findAll();
        model.addAttribute("list", productFindAllResponseDtoList);
        model.addAttribute("groups", groupFindAllResponseDtoList);
        model.addAttribute("types", ProductType.values());
        return "/pages/product/products";
    }

    @GetMapping("/product/{id}")
    public String adminProductDetail(Model model, @PathVariable(name = "id") Long id) {
        ProductFindByIdResponseDto dto = productService.findById(id);
        List<GroupFindAllResponseDto> groupFindAllResponseDtoList = groupService.findAll();
        model.addAttribute("product", dto);
        model.addAttribute("groups", groupFindAllResponseDtoList);
        model.addAttribute("types", ProductType.values());
        return "/pages/product/productDetail";
    }

}
