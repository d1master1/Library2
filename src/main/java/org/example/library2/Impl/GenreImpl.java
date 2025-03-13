package org.example.library2.Impl;

import lombok.RequiredArgsConstructor;
import org.example.library2.entity.GenreEntity;
import org.example.library2.repo.BookRepo;
import org.example.library2.repo.GenreRepo;
import org.example.library2.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreImpl implements GenreService {

    private final GenreRepo genreRepo;
    private final BookRepo bookRepo;

    @Override
    public List<GenreEntity> findAll() {
        return List.of();
    }

    @Override
    public Optional<GenreEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public GenreEntity save(GenreEntity data) {
        return null;
    }

    @Override
    public void update(GenreEntity data) {

    }
}