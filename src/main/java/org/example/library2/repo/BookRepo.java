package org.example.library2.repo;

import org.example.library2.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookEntity, Long>{

}