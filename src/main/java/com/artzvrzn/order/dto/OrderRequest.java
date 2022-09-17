package com.artzvrzn.order.dto;

import com.artzvrzn.order.domain.Product;

import java.util.List;
import java.util.Map;

public class OrderRequest {
    private Long userId;
    private Map<Long, Integer> productsMap;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Map<Long, Integer> getProductsMap() {
        return productsMap;
    }

    public void setProductsMap(Map<Long, Integer> productsMap) {
        this.productsMap = productsMap;
    }
}
