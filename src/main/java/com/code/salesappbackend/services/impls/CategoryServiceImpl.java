package com.code.salesappbackend.services.impls;

import com.code.salesappbackend.exceptions.DataExistsException;
import com.code.salesappbackend.models.Category;
import com.code.salesappbackend.repositories.CategoryRepository;
import com.code.salesappbackend.services.interfaces.BaseService;
import com.code.salesappbackend.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, Long> implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(BaseService<Category, Long> repository) {
        super(repository);
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void checkExistsCategoryName(String categoryName) throws DataExistsException {
        if(categoryRepository.existsByCategoryName(categoryName)){
            throw new DataExistsException("Category already exists");
        }
    }
}
