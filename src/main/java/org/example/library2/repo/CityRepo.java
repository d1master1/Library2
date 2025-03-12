package org.example.library2.repo;

import org.example.library2.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<CityEntity, Long>{

}