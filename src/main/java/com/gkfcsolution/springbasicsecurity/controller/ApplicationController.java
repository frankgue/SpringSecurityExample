package com.gkfcsolution.springbasicsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2025 at 11:37
 * File: null.java
 * Project: spring-basic-security
 *
 * @author Frank GUEKENG
 * @date 19/09/2025
 * @time 11:37
 */
@RestController
@RequestMapping("/rest/auth")
public class ApplicationController {
    @GetMapping("/getMsg")
    public String greeting(){
        return "Spring Security Example";
    }
}
