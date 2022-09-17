package com.artzvrzn.order.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum OrderStatus {
    CREATED, IN_PROGRESS, COMPLETED, INVALID;

    @JsonCreator
    public static OrderStatus valueOfOrInvalid(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        try {
            return OrderStatus.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return INVALID;
        }
    }
}
