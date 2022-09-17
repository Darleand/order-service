package com.artzvrzn.order.dao;

import com.artzvrzn.order.domain.Product;
import com.artzvrzn.order.domain.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p FROM app.products AS p INNER JOIN app.order_items AS i ON p.id = i.product_id " +
            "ORDER BY i.quantity", nativeQuery = true)
    List<Product> findAllAndSortByOrderQuantity();
}
