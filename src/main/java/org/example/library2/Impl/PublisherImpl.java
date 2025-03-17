package org.example.library2.Impl;

import org.example.library2.entity.PublisherEntity;
import org.example.library2.repo.PublisherRepo;
import org.example.library2.service.PublisherService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherImpl implements PublisherService {

    private final PublisherRepo publisherRepo;

    public PublisherImpl(PublisherRepo publisherRepo) {
        this.publisherRepo = publisherRepo;
    }

    @Override
    public List<PublisherEntity> findAllPublisher() {
        return publisherRepo.findAll();
    }

    @Override
    public Optional<PublisherEntity> findById(Long id) {
        return publisherRepo.findById(id);
    }

    @Override
    public PublisherEntity save(PublisherEntity data) {
        return publisherRepo.save(data);
    }

    @Override
    public void update(PublisherEntity data) {
        publisherRepo.save(data);
    }

    @Override
    public void deleteById(Long id) {
        publisherRepo.deleteById(id);
    }
}