package org.example.library2.Impl;

import org.example.library2.entity.BookEntity;
import org.example.library2.repo.BookRepo;
import org.example.library2.service.BookService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookImpl implements BookService {

    private final BookRepo bookRepo;

    public BookImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<BookEntity> findAllBook() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<BookEntity> findById(Long id) {
        return bookRepo.findById(id);
    }

    @Override
    public BookEntity save(BookEntity data) {
        return bookRepo.save(data);
    }

    @Override
    public void update(BookEntity data) {
        bookRepo.save(data);
    }

    @Override
    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }
}