package com.code.salesappbackend.controllers;

import com.code.salesappbackend.dtos.requests.ProductDetailDto;
import com.code.salesappbackend.dtos.responses.ResponseSuccess;
import com.code.salesappbackend.exceptions.DataNotFoundException;
import com.code.salesappbackend.mapper.ProductDetailMapper;
import com.code.salesappbackend.services.interfaces.ProductDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/productDetails")
@RequiredArgsConstructor
public class ProductDetailController {
    private final ProductDetailService productDetailService;
    private final ProductDetailMapper productDetailMapper;

    @PostMapping
    public ResponseSuccess<?> addProductDetail(
            @RequestBody @Valid ProductDetailDto productDetailDto)
            throws Exception {
        return new ResponseSuccess<>(
                HttpStatus.OK.value(),
                "create product detail successfully",
                productDetailService.save(productDetailMapper
                        .productDetailDto2ProductDetail(productDetailDto))
        );
    }

    @PatchMapping("/{id}")
    public ResponseSuccess<?> updateProductDetail(@PathVariable Long id, @RequestBody Map<String, ?> data)
            throws DataNotFoundException {
        return new ResponseSuccess<>(
                HttpStatus.OK.value(),
                "updated address",
                productDetailService.updatePatch(id, data)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseSuccess<?> deleteProductDetail(@PathVariable Long id) {
        productDetailService.deleteById(id);
        return  new ResponseSuccess<>(
                HttpStatus.OK.value(),
                "deleted product detail with id: " + id
        );
    }
}