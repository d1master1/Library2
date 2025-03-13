package org.example.library2.Impl;

import lombok.RequiredArgsConstructor;
import org.example.library2.entity.PublisherEntity;
import org.example.library2.repo.BookRepo;
import org.example.library2.repo.PublisherRepo;
import org.example.library2.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherImpl implements PublisherService {

    private final PublisherRepo publisherRepo;
    private final BookRepo bookRepo;

    @Override
    public List<PublisherEntity> findAll() {
        return List.of();
    }

    @Override
    public Optional<PublisherEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public PublisherEntity save(PublisherEntity data) {
        return null;
    }

    @Override
    public void update(PublisherEntity data) {

    }
}