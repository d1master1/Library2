package org.example.library2.repo;

import org.example.library2.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<PublisherEntity, Long>{

}