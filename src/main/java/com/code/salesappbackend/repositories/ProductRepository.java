package com.code.salesappbackend.repositories;

import com.code.salesappbackend.models.Product;
import com.code.salesappbackend.repositories.criterias.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends BaseRepository<Product, Long>, ProductRepositoryCustom {
    boolean existsByProductName(String productName);
}