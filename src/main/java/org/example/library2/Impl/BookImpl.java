package org.example.library2.Impl;

import lombok.RequiredArgsConstructor;
import org.example.library2.entity.BookEntity;
import org.example.library2.repo.BookRepo;
import org.example.library2.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookImpl implements BookService {

    private final BookRepo bookRepo;

    @Override
    public List<BookEntity> findAll() {
        return List.of();
    }

    @Override
    public Optional<BookEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public BookEntity save(BookEntity data) {
        return null;
    }

    @Override
    public void update(BookEntity data) {

    }
}