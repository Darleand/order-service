package com.artzvrzn.order.service;

import com.artzvrzn.order.dao.OrderRepository;
import com.artzvrzn.order.dao.ProductRepository;
import com.artzvrzn.order.domain.Product;
import com.artzvrzn.order.domain.ProductStatus;
import com.artzvrzn.order.dto.OrderRequest;
import com.artzvrzn.order.dto.OrderResponse;
import com.artzvrzn.order.service.api.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, ModelMapper mapper) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    private final ProductRepository productRepository;
    private final ModelMapper mapper;


    @Override
    public Long create(OrderRequest orderRequest) {
        if (orderRequest.getUserId() == null) {
            throw new IllegalArgumentException("User id has not been passed");
        }
        List<Product> products = productRepository.findAllById(orderRequest.getProductsMap().keySet());
        List<Product> outOfStock = products
                .stream()
                .filter(p -> p.getStatus().equals(ProductStatus.OUT_OF_STOCK))
                .collect(Collectors.toList());
        if (!outOfStock.isEmpty()) {
            String message = outOfStock
                    .stream()
                    .map(p -> String.valueOf(p.getId()))
                    .collect(Collectors.joining(","));
            throw new IllegalArgumentException(String.format("Products %s currently if out of stock", message));
        }
        return null;
    }

    @Override
    public List<OrderResponse> get(LocalDateTime from, LocalDateTime to) {
        return null;
    }
}
