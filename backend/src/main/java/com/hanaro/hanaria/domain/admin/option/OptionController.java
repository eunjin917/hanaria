package com.hanaro.hanaria.domain.admin.option;

import com.hanaro.hanaria.domain.admin.product.ProductService;
import com.hanaro.hanaria.dto.admin.option.OptionFindAllResponseDto;
import com.hanaro.hanaria.dto.admin.option.OptionFindByIdResponseDto;
import com.hanaro.hanaria.dto.admin.product.ProductFindAllResponseDto;
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
public class OptionController {

    private final OptionService optionService;
    private final ProductService productService;

    @GetMapping("/options")
    public String adminProducts(Model model
    ) {
        List<OptionFindAllResponseDto> optionFindAllResponseDtoList = optionService.findAll();
        List<ProductFindAllResponseDto> productFindAllResponseDtoList = productService.findAll();
        model.addAttribute("list", optionFindAllResponseDtoList);
        model.addAttribute("products", productFindAllResponseDtoList);
        model.addAttribute("categories", OptionCategory.values());
        return "/pages/option/options";
    }

    @GetMapping("/option/{id}")
    public String adminProductDetail(Model model, @PathVariable(name = "id") Long id) {
        OptionFindByIdResponseDto dto = optionService.findById(id);
        List<ProductFindAllResponseDto> productFindAllResponseDtoList = productService.findAll();
        model.addAttribute("option", dto);
        model.addAttribute("products", productFindAllResponseDtoList);
        model.addAttribute("categories", OptionCategory.values());
        return "/pages/option/optionDetail";
    }

}
