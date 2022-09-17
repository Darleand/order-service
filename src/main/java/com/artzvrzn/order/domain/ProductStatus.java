package com.artzvrzn.order.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ProductStatus {
    OUT_OF_STOCK, IN_STOCK, RUNNING_LOW, INVALID;

    @JsonCreator
    public static ProductStatus valueOfOrInvalid(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        try {
            return ProductStatus.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return INVALID;
        }
    }
}
