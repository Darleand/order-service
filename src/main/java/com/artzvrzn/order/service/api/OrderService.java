package com.artzvrzn.order.service.api;

import com.artzvrzn.order.dto.OrderRequest;
import com.artzvrzn.order.dto.OrderResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {

    Long create(OrderRequest orderRequest);

    List<OrderResponse> get(LocalDateTime from, LocalDateTime to);
}
