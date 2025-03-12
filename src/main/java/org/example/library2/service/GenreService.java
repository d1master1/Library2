package org.example.library2.service;

import org.example.library2.entity.GenreEntity;
import org.example.library2.repo.GenreRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    public final GenreRepo repo;

    public GenreService(GenreRepo repo) {
        this.repo = repo;
    }

    public List<GenreEntity> findAll() {
        return repo.findAll();
    }

    public Optional<GenreEntity> findById(Long id) {
        return repo.findById(id);
    }

    public GenreEntity save (GenreEntity data) {
        return repo.save(data);
    }

    public void update (GenreEntity data) {
        repo.save(data);
    }
}