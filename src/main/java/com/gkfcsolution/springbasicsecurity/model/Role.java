package com.gkfcsolution.springbasicsecurity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created on 2025 at 14:07
 * File: null.java
 * Project: spring-basic-security
 *
 * @author Frank GUEKENG
 * @date 19/09/2025
 * @time 14:07
 */
@Entity
@Table(name = "app_role")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;
    private String role; // Ex: "ROLE_ADMIN", "ROLE_USER"
//    @ManyToMany(mappedBy = "roles")
//    private Set<User> user;
}
