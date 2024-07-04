package com.example.spring_boot_rest.configuration;

import com.example.spring_boot_rest.model.User;
import com.example.spring_boot_rest.repository.UserRepository;
import com.example.spring_boot_rest.service.AuthorizationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.spring_boot_rest.model.Role.*;
import static com.example.spring_boot_rest.model.Role.ANONYMOUS;

@Configuration
public class Config {
    @Bean
    public UserRepository receiveUserRepository() {
        UserRepository userRepository = new UserRepository();
        userRepository.addUser(new User("Sergey", "123", ADMIN));
        userRepository.addUser(new User("Ivan", "123", USER));
        userRepository.addUser(new User("Sveta", "123", USER));
        userRepository.addUser(new User("Anon", "", ANONYMOUS));
        return userRepository;
    }
    @Bean
    public AuthorizationService receiveAuthorizationService() {
        return new AuthorizationService();
    }
}
