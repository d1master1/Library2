package org.example.library2.service;

import org.example.library2.entity.CityEntity;
import org.example.library2.repo.CityRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CityService {
    private final CityRepo repo;

    public CityService(CityRepo repo) {
        this.repo = repo;
    }

    public List<CityEntity> findAll() {
        return repo.findAll();
    }

    public Optional<CityEntity> findById(Long id) {
        return repo.findById(id);
    }

    public CityEntity save (CityEntity data) {
        return repo.save(data);
    }

    public void update (CityEntity data) {
        repo.save(data);
    }
}