package com.code.salesappbackend.controllers;

import com.code.salesappbackend.dtos.requests.ProductDto;
import com.code.salesappbackend.dtos.responses.ResponseSuccess;
import com.code.salesappbackend.services.interfaces.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseSuccess<?> getAllProducts() {
        return new ResponseSuccess<>(HttpStatus.OK.value(),
                "get all products successfully",
                productService.findAll());
    }

    @PostMapping
    public ResponseSuccess<?> addProduct(@ModelAttribute @Valid ProductDto productDto) throws Exception {
        return new ResponseSuccess<>(HttpStatus.OK.value(),
                "add product successfully",
                productService.save(productDto));
    }

    @GetMapping("/{id}")
    public ResponseSuccess<?> getProductById(@PathVariable Long id) throws Exception {
        return new ResponseSuccess<>(HttpStatus.OK.value(),
                "get product successfully",
                productService.findById(id));
    }
}
