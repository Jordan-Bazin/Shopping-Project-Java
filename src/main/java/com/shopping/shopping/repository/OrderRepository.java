package com.shopping.shopping.repository;

import com.shopping.shopping.model.OrderT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderT, Long> {
}
