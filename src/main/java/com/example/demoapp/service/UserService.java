package com.example.demoapp.service;


import com.example.demoapp.model.entity.User;
import com.example.demoapp.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public Optional<User> getUser(Long id) {
        return userRepo.findById(id);
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
