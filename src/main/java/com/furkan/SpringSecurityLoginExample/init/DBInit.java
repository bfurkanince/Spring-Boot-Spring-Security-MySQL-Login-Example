package com.furkan.SpringSecurityLoginExample.init;

import com.furkan.SpringSecurityLoginExample.entity.User;
import com.furkan.SpringSecurityLoginExample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DBInit {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void postConstruct() {
        User adminUser = new User();
        adminUser.setId(1);
        adminUser.setUserName("furkanInce");
        adminUser.setPassword("$2a$12$78Cq4gYgYijr3U3tkVxtQu7uSVqvehTEVUnGAK30JpXheQ7E.RaCO");//furkan
        adminUser.setRole("ADMIN");
        userRepository.save(adminUser);

        User normalUser = new User();
        normalUser.setId(2);
        normalUser.setUserName("ince");
        normalUser.setPassword("$2a$12$4OSYzHWestRReEAnFp8f6OE287bXy3KGDFb8MxnlGPWBzDX5uDX9e");//ince
        normalUser.setRole("USER");
        userRepository.save(normalUser);

    }

}
