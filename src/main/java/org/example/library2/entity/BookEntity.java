package org.example.library2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class BookEntity {

    public BookEntity() {

    }

    public BookEntity(Long id, AuthorEntity author, PublisherEntity publisher, GenreEntity genre, String year) {
        this.id = id;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public PublisherEntity getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherEntity publisher) {
        this.publisher = publisher;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisher;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genre;
    private String year;
}