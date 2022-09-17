package com.artzvrzn.order.controller.rest;

import com.artzvrzn.order.dto.OrderRequest;
import com.artzvrzn.order.dto.OrderResponse;
import com.artzvrzn.order.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = {"/", ""}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> get(@Param("from")LocalDateTime from , @Param("to")LocalDateTime to) {
        return orderService.get(from, to);
    }

    @PostMapping(value = {"", "/"},
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Long create(@RequestBody OrderRequest orderRequest) {
        return orderService.create(orderRequest);
    }
}
