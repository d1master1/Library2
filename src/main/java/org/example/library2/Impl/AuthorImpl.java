package org.example.library2.Impl;

import lombok.RequiredArgsConstructor;
import org.example.library2.entity.AuthorEntity;
import org.example.library2.repo.AuthorRepo;
import org.example.library2.repo.BookRepo;
import org.example.library2.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorImpl implements AuthorService {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    @Override
    public List<AuthorEntity> findAll() {
        return List.of();
    }

    @Override
    public Optional<AuthorEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public AuthorEntity save(AuthorEntity data) {
        return null;
    }

    @Override
    public void update(AuthorEntity data) {

    }
}