package org.example.library2.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "genre")
public class GenreEntity {

    public GenreEntity() {

    }

    public GenreEntity(Long id, String title, List<BookEntity> books) {
        this.id = id;
        this.title = title;
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
    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private List<BookEntity> books;
}