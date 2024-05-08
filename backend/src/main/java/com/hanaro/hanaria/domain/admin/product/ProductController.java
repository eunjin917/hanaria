package com.hanaro.hanaria.domain.admin.product;

import com.hanaro.hanaria.domain.admin.group.GroupService;
import com.hanaro.hanaria.dto.admin.group.GroupFindAllResponseDto;
import com.hanaro.hanaria.dto.admin.product.ProductFindAllResponseDto;
import com.hanaro.hanaria.dto.admin.product.ProductFindByIdResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admin")
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
