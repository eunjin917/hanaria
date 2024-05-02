package com.hanaro.hanaria.domain.product;

import com.hanaro.hanaria.dto.product.ProductCreateRequestDto;
import com.hanaro.hanaria.dto.product.ProductUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
//@Secured({"ADMIN"})
public class ProductApiController {
    private final ProductService productService;

    @PostMapping("/product")
    public String adminProductCreate(@ModelAttribute ProductCreateRequestDto dto) {
        boolean isAdded = productService.create(dto);
        if (isAdded) {
            return "<script>alert('상품이 추가되었습니다.');location.href='/products';</script>";
        } else {
            return "<script>alert('상품 추가에 실패하였습니다.');history.back();</script>";
        }
    }

    @PutMapping("/product")
    public ResponseEntity<String> adminProductUpdate(@RequestBody ProductUpdateRequestDto dto) {
        boolean isUpdated = productService.update(dto);
        if (isUpdated) {
            return ResponseEntity.ok("상품정보가 수정되었습니다.");
        } else {
            return ResponseEntity.internalServerError().body("존재하지 않는 상품입니다.");
        }
    }

    @DeleteMapping("/product")
    public ResponseEntity<String> adminProductDelete(@RequestParam(name = "id") Long id) {
        boolean isDeleted = productService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("상품이 삭제되었습니다.");
        } else {
            return ResponseEntity.internalServerError().body("상품 삭제에 실패하였습니다.");
        }
    }
}
