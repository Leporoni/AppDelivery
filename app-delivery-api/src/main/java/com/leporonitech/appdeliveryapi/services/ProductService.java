package com.leporonitech.appdeliveryapi.services;

import com.leporonitech.appdeliveryapi.dto.ProductDTO;
import com.leporonitech.appdeliveryapi.entities.Product;
import com.leporonitech.appdeliveryapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        List<Product> list = productRepository.findAllByOrderByNameAsc();
        return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }
}
