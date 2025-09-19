package com.gkfcsolution.springbasicsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2025 at 12:56
 * File: null.java
 * Project: spring-basic-security
 *
 * @author Frank GUEKENG
 * @date 19/09/2025
 * @time 12:56
 */
@RestController
@RequestMapping("/noAuth/rest")
public class NoAuthController {

    @GetMapping("/sayHi")
    public String sayHello(){
        return "Hello No Authentication Need";
    }
}
