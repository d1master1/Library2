package org.example.library2.service;

import org.example.library2.entity.PublisherEntity;
import java.util.List;
import java.util.Optional;

public interface PublisherService {

    public List<PublisherEntity> findAll();

    public Optional<PublisherEntity> findById(Long id);

    public PublisherEntity save(PublisherEntity data);

    public void update(PublisherEntity data);

}