package com.example.ford.project.repository;

import com.example.ford.project.model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {
    Librarian findByEmail(String email);
}
