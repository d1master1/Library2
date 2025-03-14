package org.example.library2.Impl;

import org.example.library2.entity.CityEntity;
import org.example.library2.repo.BookRepo;
import org.example.library2.repo.CityRepo;
import org.example.library2.service.CityService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CityImpl implements CityService {

    private final CityRepo cityRepo;
    private final BookRepo publisherRepo;

    public CityImpl(CityRepo cityRepo, BookRepo publisherRepo) {
        this.cityRepo = cityRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public List<CityEntity> findAll() {
        return cityRepo.findAll();
    }

    @Override
    public Optional<CityEntity> findById(Long id) {
        return cityRepo.findById(id);
    }

    @Override
    public CityEntity save(CityEntity data) {
        return cityRepo.save(data);
    }

    @Override
    public void update(CityEntity data) {
        cityRepo.save(data);
    }
}