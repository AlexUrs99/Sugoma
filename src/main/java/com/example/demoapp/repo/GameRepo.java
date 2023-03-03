package com.example.demoapp.repo;

import com.example.demoapp.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepo extends JpaRepository<Game, Long> {

    Optional<Game> findByNameIs(String name);
    Optional<Game> deleteByNameIs(String name);

}
