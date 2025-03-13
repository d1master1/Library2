package org.example.library2.Impl;

import lombok.RequiredArgsConstructor;
import org.example.library2.entity.CityEntity;
import org.example.library2.repo.BookRepo;
import org.example.library2.repo.CityRepo;
import org.example.library2.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityImpl implements CityService {

    private final CityRepo cityRepo;
    private final BookRepo bookRepo;

    @Override
    public List<CityEntity> findAll() {
        return List.of();
    }

    @Override
    public Optional<CityEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public CityEntity save(CityEntity data) {
        return null;
    }

    @Override
    public void update(CityEntity data) {

    }
}