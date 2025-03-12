package org.example.library2.repo;

import org.example.library2.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<GenreEntity, Long>{

}