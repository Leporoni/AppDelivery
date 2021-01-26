package com.leporonitech.appdeliveryapi.services;

import com.leporonitech.appdeliveryapi.dto.OrderDTO;
import com.leporonitech.appdeliveryapi.dto.ProductDTO;
import com.leporonitech.appdeliveryapi.entities.Order;
import com.leporonitech.appdeliveryapi.entities.OrderStatus;
import com.leporonitech.appdeliveryapi.entities.Product;
import com.leporonitech.appdeliveryapi.repositories.OrderRepository;
import com.leporonitech.appdeliveryapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> list = orderRepository.findOrdersWithProducts();
        return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO insert(OrderDTO orderDTO){
        Order order = new Order(null, orderDTO.getAddress(), orderDTO.getLatitude(), orderDTO.getLongitude(),
                Instant.now(), OrderStatus.PENDING);
        for(ProductDTO p : orderDTO.getProducts()){
            Product product = productRepository.getOne(p.getId());
            order.getProducts().add(product);
        }
        order = orderRepository.save(order);
        return new OrderDTO(order);
    }
}
