package org.example.library2.service;

import org.example.library2.entity.GenreEntity;
import java.util.List;
import java.util.Optional;

public interface GenreService {

    public List<GenreEntity> findAllGenre();

    public Optional<GenreEntity> findById(Long id);

    public GenreEntity save(GenreEntity data);

    public void update(GenreEntity data);

    void deleteById(Long id);
}