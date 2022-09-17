package com.artzvrzn.order.dto;

import com.artzvrzn.order.domain.OrderStatus;

public class OrderResponse {
    private Long userId;
    private OrderStatus status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
