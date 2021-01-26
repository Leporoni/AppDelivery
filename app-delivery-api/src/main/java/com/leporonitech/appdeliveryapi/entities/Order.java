package com.leporonitech.appdeliveryapi.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order")
@Data
@NoArgsConstructor
public class Order implements Serializable {

    private static final long serialVersionUID = -2240294678098416906L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private Double latitude;

    private Double longitude;

    private Instant moment;

    private OrderStatus status;

    @ManyToMany
    @JoinTable(name = "tb_order_product",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

    public Order(Object o, String address, Double latitude, Double longitude, Instant now, OrderStatus pending) {
    }
}
