package org.example.library2.repo;

import org.example.library2.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<AuthorEntity, Long> {

}