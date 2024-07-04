package com.example.spring_boot_rest.repository;

import com.example.spring_boot_rest.model.Role;
import com.example.spring_boot_rest.model.User;
import com.example.spring_boot_rest.service.Authorities;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.example.spring_boot_rest.service.Authorities.*;

public class UserRepository {
    private CopyOnWriteArrayList<User> listOfUsers;

    public UserRepository() {
        listOfUsers = new CopyOnWriteArrayList();
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> list = null;
        for (User u : listOfUsers) {
            if (u.getUsername().equals(user) && u.getPassword().equals(password)) {
                switch (u.getRole()) {
                    case ANONYMOUS:
                        list = List.of(READ);
                        break;
                    case ADMIN:
                        list = List.of(READ, WRITE, DELETE);
                        break;
                    case USER:
                        list = List.of(READ, WRITE);
                        break;
                }
            }
        }
        return list;
    }

    public void addUser(User user) {
        listOfUsers.add(user);
    }
}
