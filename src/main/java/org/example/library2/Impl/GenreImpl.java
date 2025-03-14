package org.example.library2.Impl;

import org.example.library2.entity.GenreEntity;
import org.example.library2.repo.BookRepo;
import org.example.library2.repo.GenreRepo;
import org.example.library2.service.GenreService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GenreImpl implements GenreService {

    private final GenreRepo genreRepo;
    private final BookRepo bookRepo;

    public GenreImpl(GenreRepo genreRepo, BookRepo bookRepo) {
        this.genreRepo = genreRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public List<GenreEntity> findAll() {
        return genreRepo.findAll();
    }

    @Override
    public Optional<GenreEntity> findById(Long id) {
        return genreRepo.findById(id);
    }

    @Override
    public GenreEntity save(GenreEntity data) {
        return genreRepo.save(data);
    }

    @Override
    public void update(GenreEntity data) {
        genreRepo.save(data);
    }
}