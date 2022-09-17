package com.artzvrzn.order.service;

import com.artzvrzn.order.dao.ProductRepository;
import com.artzvrzn.order.domain.Product;
import com.artzvrzn.order.domain.ProductStatus;
import com.artzvrzn.order.dto.ProductRequest;
import com.artzvrzn.order.dto.ProductResponse;
import com.artzvrzn.order.service.api.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackOn = Exception.class)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public void create(ProductRequest dto) {
        Product entity = mapper.map(dto, Product.class);
        entity.setStatus(ProductStatus.IN_STOCK);
        productRepository.save(entity);
    }

    @Override
    public void update(Long id, ProductRequest dto) {
        Product entity = productRepository.findById(id).orElseThrow(() -> productDoesNotExist(id));
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if (dto.getPrice() != null) {
            entity.setPrice(dto.getPrice());
        }
        if (!dto.getProductStatus().equals(ProductStatus.INVALID) || dto.getProductStatus() != null) {
            entity.setStatus(dto.getProductStatus());
        }
        productRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        Product entity = productRepository.findById(id).orElseThrow(() -> productDoesNotExist(id));
        if (entity.getStatus().equals(ProductStatus.IN_STOCK) || entity.getStatus().equals(ProductStatus.RUNNING_LOW)) {
            productRepository.deleteById(id);
        } else {
            throw new IllegalStateException(
                    String.format("Product cannot be deleted, because its status is %s", entity.getStatus()));
        }
    }

    @Override
    public List<ProductResponse> getAll() {
        List<Product> products =  productRepository.findAllAndSortByOrderQuantity();
        return products.stream().map(e -> mapper.map(e, ProductResponse.class)).collect(Collectors.toList());
    }

    private static IllegalArgumentException productDoesNotExist(long id) {
        return new IllegalArgumentException(String.format("Product with id %s not found", id));
    }
}
