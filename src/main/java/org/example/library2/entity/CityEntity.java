package org.example.library2.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "city")
public class CityEntity {

    public CityEntity() {

    }

    public CityEntity(Long id, String title, List<PublisherEntity> publishers) {
        this.id = id;
        this.title = title;
        this.publishers = publishers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PublisherEntity> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<PublisherEntity> publishers) {
        this.publishers = publishers;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<PublisherEntity> publishers;
}