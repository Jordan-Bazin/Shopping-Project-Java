package com.shopping.shopping.controller;

import com.shopping.shopping.exceptions.ProductNotFoundException;
import com.shopping.shopping.model.Product;
import com.shopping.shopping.repository.ProductRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductRepository repository;

    ProductController(ProductRepository repository) { this.repository = repository;}
    @GetMapping("/all")
    List<Product> all() { return repository.findAll();}

    @GetMapping("/{id}")
    EntityModel<Product> one(@PathVariable Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        return EntityModel.of(product,
                linkTo(methodOn(ProductController.class).one(id)).withSelfRel(),
                linkTo(methodOn(ProductController.class).all()).withRel("product"));
    }
}
