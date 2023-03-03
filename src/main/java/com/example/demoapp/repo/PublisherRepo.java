package com.example.demoapp.repo;

import com.example.demoapp.model.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Long> {
    Optional<Publisher> findByNameIs(String publisher);
}
