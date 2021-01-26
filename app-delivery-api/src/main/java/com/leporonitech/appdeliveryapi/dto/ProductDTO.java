package com.leporonitech.appdeliveryapi.dto;

import com.leporonitech.appdeliveryapi.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 4132731918705125267L;

    private Long id;

    private String name;

    private BigDecimal price;

    private String description;

    private String imageUri;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, BigDecimal price, String description, String imageUri) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUri = imageUri;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        description = entity.getDescription();
        imageUri = entity.getImageUri();
    }
}
