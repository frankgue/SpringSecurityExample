package com.gkfcsolution.springbasicsecurity.Service.auth;

import com.gkfcsolution.springbasicsecurity.model.User;
import com.gkfcsolution.springbasicsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created on 2025 at 16:51
 * File: null.java
 * Project: spring-basic-security
 *
 * @author Frank GUEKENG
 * @date 19/09/2025
 * @time 16:51
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not exist with name : " + username));
        CustomUserDetails userDetails = null;
        if (user != null) {
            userDetails = new CustomUserDetails();
            System.out.println("User => " + user.toString());
            userDetails.setUser(user);
            System.out.println("userDetails => " + userDetails.toString());
        } else {
            throw new UsernameNotFoundException("User not exist with name : " + username);
        }
        return userDetails;
    }
}
