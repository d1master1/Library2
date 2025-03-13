package org.example.library2.service;

import org.example.library2.entity.BookEntity;
import org.example.library2.repo.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    private final BookRepo repo;

    public BookService(BookRepo repo) {
        this.repo = repo;
    }

    public List<BookEntity> findAll() {
        return repo.findAll();
    }

    public Optional<BookEntity> findById(Long id) {
        return repo.findById(id);
    }

    public BookEntity save (BookEntity data) {
        return repo.save(data);
    }

    public void update (BookEntity data) {
        repo.save(data);
    }
}