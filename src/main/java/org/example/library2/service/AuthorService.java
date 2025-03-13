package org.example.library2.service;

import org.example.library2.entity.AuthorEntity;
import java.util.List;
import java.util.Optional;

public interface AuthorService {

    public List<AuthorEntity> findAll();

    public Optional<AuthorEntity> findById(Long id);

    public AuthorEntity save(AuthorEntity data);

    public void update(AuthorEntity data);

}