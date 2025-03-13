package org.example.library2.service;

import org.example.library2.entity.CityEntity;
import java.util.List;
import java.util.Optional;

public interface CityService {

    public List<CityEntity> findAll();

    public Optional<CityEntity> findById(Long id);

    public CityEntity save(CityEntity data);

    public void update(CityEntity data);

}