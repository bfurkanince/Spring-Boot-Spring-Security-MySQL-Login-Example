package com.furkan.SpringSecurityLoginExample.service;

import com.furkan.SpringSecurityLoginExample.entity.User;
import com.furkan.SpringSecurityLoginExample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        if(user.isPresent()){
            return new CustomUserDetails(user.get());
        }
        throw new UsernameNotFoundException("User not found.");
    }
}
