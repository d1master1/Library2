package org.example.library2.service;

import org.example.library2.entity.PublisherEntity;
import org.example.library2.repo.PublisherRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {
    public final PublisherRepo repo;

    public PublisherService(PublisherRepo repo) {
        this.repo = repo;
    }

    public List<PublisherEntity> findAll() {
        return repo.findAll();
    }

    public Optional<PublisherEntity> findById(Long id) {
        return repo.findById(id);
    }

    public PublisherEntity save (PublisherEntity data) {
        return repo.save(data);
    }

    public void update (PublisherEntity data) {
        repo.save(data);
    }
}