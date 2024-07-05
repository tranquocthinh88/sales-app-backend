package com.code.salesappbackend.repositories.criterias;

import com.code.salesappbackend.dtos.responses.PageResponse;

public interface ProductRepositoryCustom {
    PageResponse getProductByName(String name, int pageNo, int pageSize);
}
