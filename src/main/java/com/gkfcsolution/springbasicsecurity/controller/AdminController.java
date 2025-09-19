package com.gkfcsolution.springbasicsecurity.controller;

import com.gkfcsolution.springbasicsecurity.model.User;
import com.gkfcsolution.springbasicsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2025 at 14:48
 * File: null.java
 * Project: spring-basic-security
 *
 * @author Frank GUEKENG
 * @date 19/09/2025
 * @time 14:48
 */
@RestController
@RequestMapping("/secure/rest")
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/admin/add")
    public String addUserByAdmin(@RequestBody User user){
        String pwd = user.getPassword();
        String encryptedPwd = passwordEncoder.encode(pwd);
        user.setPassword(encryptedPwd);
        userRepository.save(user);
        return "user added successfully";
    }
}
