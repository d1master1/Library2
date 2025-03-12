package org.example.library2.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "publisher")
public class PublisherEntity {

    public PublisherEntity() {

    }

    public PublisherEntity(Long id, String title, CityEntity city, List<BookEntity> books) {
        this.id = id;
        this.title = title;
        this.city = city;
        this.books = books;
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

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<BookEntity> books;
}