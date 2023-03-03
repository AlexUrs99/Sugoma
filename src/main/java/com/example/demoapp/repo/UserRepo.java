package com.example.demoapp.repo;

import com.example.demoapp.model.entity.Game;
import com.example.demoapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
}
