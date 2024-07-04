package com.example.spring_boot_rest.service;

import com.example.spring_boot_rest.exception.InvalidCredentials;
import com.example.spring_boot_rest.exception.UnauthorizedUser;
import com.example.spring_boot_rest.model.User;
import com.example.spring_boot_rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorizationService {
    @Autowired
    UserRepository userRepository;

    public List<Authorities> getAuthorities(String username, String password) {
        if (isEmpty(username)) {
            throw new InvalidCredentials("Username is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(username, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + username);
        }
        return userAuthorities;
    }
    public List<Authorities> getAuthorities(User user) {
        return this.getAuthorities(user.getUsername(), user.getPassword());
    }
    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
