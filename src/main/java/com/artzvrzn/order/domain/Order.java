package com.artzvrzn.order.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders", schema = "app")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "user_id")
    private long userId;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime created;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

}
