package com.artzvrzn.order.service.api;

import com.artzvrzn.order.dto.ProductRequest;
import com.artzvrzn.order.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void create(ProductRequest dto);

    void update(Long id, ProductRequest productRequest);

    void delete(Long id);

    List<ProductResponse> getAll();
}
