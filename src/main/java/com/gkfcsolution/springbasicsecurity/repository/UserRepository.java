package com.gkfcsolution.springbasicsecurity.repository;

import com.gkfcsolution.springbasicsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created on 2025 at 14:46
 * File: null.java
 * Project: spring-basic-security
 *
 * @author Frank GUEKENG
 * @date 19/09/2025
 * @time 14:46
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
