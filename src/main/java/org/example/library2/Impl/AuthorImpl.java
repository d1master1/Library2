package org.example.library2.Impl;

import org.example.library2.entity.AuthorEntity;
import org.example.library2.repo.AuthorRepo;
import org.example.library2.service.AuthorService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorImpl implements AuthorService {

    private final AuthorRepo authorRepo;

    public AuthorImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public List<AuthorEntity> findAllAuthor() {
        return authorRepo.findAll();
    }

    @Override
    public Optional<AuthorEntity> findById(Long id) {
        return authorRepo.findById(id);
    }

    @Override
    public AuthorEntity save(AuthorEntity author) {
        return authorRepo.save(author);
    }

    @Override
    public void update(AuthorEntity author) {
        authorRepo.save(author);
    }

    @Override
    public void deleteById(Long id) {
        authorRepo.deleteById(id);
    }
}