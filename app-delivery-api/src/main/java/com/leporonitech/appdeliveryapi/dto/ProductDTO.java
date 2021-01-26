package com.leporonitech.appdeliveryapi.dto;

import com.leporonitech.appdeliveryapi.entities.Product;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 4132731918705125267L;

    private Long id;

    private String name;

    private BigDecimal price;

    private String description;

    private String imageUri;

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        description = entity.getDescription();
        imageUri = entity.getImageUri();
    }
}
