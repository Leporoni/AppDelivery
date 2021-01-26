package com.leporonitech.appdeliveryapi.repositories;

import com.leporonitech.appdeliveryapi.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
