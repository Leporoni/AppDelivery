package com.leporonitech.appdeliveryapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_product")
@Data
public class Product implements Serializable {

    private static final long serialVersionUID = -3068021182145173811L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    private String description;

    private String imageUri;
}
