package org.example.library2.Impl;

import org.example.library2.entity.AuthorEntity;
import org.example.library2.repo.AuthorRepo;
import org.example.library2.repo.BookRepo;
import org.example.library2.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorImpl implements AuthorService {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    @Autowired
    public AuthorImpl(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public List<AuthorEntity> findAll() {
        return authorRepo.findAll();
    }

    @Override
    public Optional<AuthorEntity> findById(Long id) {
        return authorRepo.findById(id);
    }

    @Override
    public AuthorEntity save(AuthorEntity data) {
        return authorRepo.save(data);
    }

    @Override
    public void update(AuthorEntity data) {
        authorRepo.save(data);
    }

}