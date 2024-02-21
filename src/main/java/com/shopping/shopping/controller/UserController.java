package com.shopping.shopping.controller;

import com.shopping.shopping.exceptions.ProductNotFoundException;
import com.shopping.shopping.model.UserT;
import com.shopping.shopping.repository.UserRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    EntityModel<UserT> one(@PathVariable Long id) {
        UserT user = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        return EntityModel.of(user,
                linkTo(methodOn(UserController.class).one(id)).withSelfRel());
    }
}
