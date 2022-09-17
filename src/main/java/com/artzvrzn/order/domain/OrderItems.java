package com.artzvrzn.order.domain;

import javax.persistence.*;

@Entity
@Table(name = "order_items", schema = "app")
public class OrderItems {
    @Id
    @Column(name = "order_id", updatable = false)
    private long id;
    @ManyToOne
    @MapsId
    @JoinColumn(name = "order_id", updatable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
