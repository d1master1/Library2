package org.example.library2.service;

import org.example.library2.entity.BookEntity;
import java.util.List;
import java.util.Optional;

public interface BookService {

    public List<BookEntity> findAll();

    public Optional<BookEntity> findById(Long id);

    public BookEntity save(BookEntity data);

    public void update(BookEntity data);

}