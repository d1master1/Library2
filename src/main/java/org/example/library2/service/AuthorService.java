package org.example.library2.service;

import org.example.library2.entity.AuthorEntity;
import org.example.library2.repo.AuthorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepo repo;

    public AuthorService(AuthorRepo repo) {
        this.repo = repo;
    }

    public List<AuthorEntity> findAll() {
        return repo.findAll();
    }

    public Optional<AuthorEntity> findById(Long id) {
        return repo.findById(id);
    }

    public AuthorEntity save (AuthorEntity data) {
        return repo.save(data);
    }

    public void update (AuthorEntity data) {
        repo.save(data);
    }
}