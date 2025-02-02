package com.code.salesappbackend.controllers;

import com.code.salesappbackend.dtos.requests.CategoryDto;
import com.code.salesappbackend.dtos.responses.Response;
import com.code.salesappbackend.dtos.responses.ResponseSuccess;
import com.code.salesappbackend.mapper.CategoryMapper;
import com.code.salesappbackend.models.Category;
import com.code.salesappbackend.services.interfaces.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public Response getCategories() {
        return new ResponseSuccess<>(HttpStatus.OK.value(),
                "get category successfully",
                categoryService.findAll());
    }

    @PostMapping
    public ResponseSuccess<?> addCategory(@RequestBody @Valid CategoryDto categoryDto) throws Exception {
        Category category = categoryMapper.categoryDto2Category(categoryDto);
       return new ResponseSuccess<>(HttpStatus.OK.value(),
               "create category successfully",
               categoryService.save(category));
    }

    @PutMapping("/{id}")
    public ResponseSuccess<?> updateCategory(@PathVariable Long id, @RequestBody @Valid Category category) throws Exception {
        category.setId(id);
        return new ResponseSuccess<>(HttpStatus.OK.value(),
                "update category successfully",
                categoryService.update(id, category));
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
        return "Delete address";
    }

    @PatchMapping("/{id}")
    public ResponseSuccess<?> patchCategory(@PathVariable Long id, @RequestBody Map<String, ?> data)
            throws Exception {
        return new ResponseSuccess<>(HttpStatus.OK.value(),
                "updated category",
                categoryService.updatePatch(id, data));
    }
}
