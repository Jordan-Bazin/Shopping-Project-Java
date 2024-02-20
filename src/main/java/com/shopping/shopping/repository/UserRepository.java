package com.shopping.shopping.repository;

import com.shopping.shopping.model.UserT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserT, Long> {

}
