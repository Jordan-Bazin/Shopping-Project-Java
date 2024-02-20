package com.shopping.shopping;

import com.shopping.shopping.model.Product;
import com.shopping.shopping.repository.OrderRepository;
import com.shopping.shopping.repository.ProductOrderRepository;
import com.shopping.shopping.repository.ProductRepository;
import com.shopping.shopping.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class LoadData {
    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, OrderRepository orderRepository, ProductRepository productRepository, ProductOrderRepository productOrderRepository) {
        return args-> {
            log.info("Preloading " + productRepository.save(new Product("iPhone 9", "An apple mobile which is nothing like apple", 549, 69, 94, "Apple", "smartphones", "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg")));
        };
    }
}
