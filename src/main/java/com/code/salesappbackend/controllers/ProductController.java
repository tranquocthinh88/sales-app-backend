package com.code.salesappbackend.controllers;

import com.code.salesappbackend.dtos.requests.ProductDto;
import com.code.salesappbackend.dtos.responses.ResponseSuccess;
import com.code.salesappbackend.repositories.criterias.ProductCriteria;
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
    private final ProductCriteria productCriteria;

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
                productService.findProductById(id));
    }

    @GetMapping("/page-product")
    public ResponseSuccess<?> pageProduct(@RequestParam(defaultValue = "1") int pageNo,
                                          @RequestParam(defaultValue = "10") int pageSize,
                                          @RequestParam(required = false) String[] sort,
                                          @RequestParam(required = false) String[] search)  throws Exception{
        return new ResponseSuccess<>(
                HttpStatus.OK.value(),
                "get product page",
                productService.getProductsForUserRole(pageNo, pageSize, search, sort)
        );
    }

    @GetMapping("/test-criteria")
    public ResponseSuccess<?> testCriteria(@RequestParam(defaultValue = "1") int pageNo,
                                           @RequestParam(defaultValue = "10") int pageSize,
                                           @RequestParam(required = false) String sort,
                                           @RequestParam(required = false) String... search) {
        return new ResponseSuccess<>(
                HttpStatus.OK.value(),
                "get product page",
                null
        );
    }
}
