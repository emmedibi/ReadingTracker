package com.example.reading_tracker.bean;

import com.example.reading_tracker.enumeration.Lang;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    @NotEmpty(message = "Entity name must be provided.")
    @Size(min=1)
    private String title;

    @Column(name = "author_name")
    @NotEmpty(message = "Entity name must be provided.")
    @Size(min=1)
    private String author_name;

    @Column(name = "author_surname")
    @NotEmpty(message = "Entity name must be provided.")
    @Size(min=1)
    private String author_surname;

    @Column(name = "number_of_pages")
    @NotNull()
    @Min(0)
    private int number_of_pages;

    @Column(name = "language")
    @Min(0)
    @Max(1)
    private int language;

    @Column(name = "image_path")
    @Size(min=1)
    private String image_path;

    @Column(name = "already_published")
    @NotNull
    private Boolean is_already_published;

    @Column(name = "price")
    @NotNull()
    @Min(0)
    private float price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "release_date") // data di publicazione
    private LocalDate release_date;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_reading_date") // data di publicazione
    private LocalDate start_reading_date;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_reading_date") // data di publicazione
    private LocalDate end_reading_date;

    // Relatioships
    @ManyToOne
    @JoinColumn(name = "saga_id")
    private Saga saga;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable( name= "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Collection<Genre> genres;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable( name= "book_bookshelf",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "bookshelf_id"))
    private Collection<Bookshelf> bookshelves;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable( name= "book_tags",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "tags_id"))
    private Collection<Tag> tags;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Review> reviews;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Comment> comments;


    // GETTER AND SETTER
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

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_surname() {
        return author_surname;
    }

    public void setAuthor_surname(String author_surname) {
        this.author_surname = author_surname;
    }

    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(int number_of_pages) {
        this.number_of_pages = number_of_pages;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public Boolean getIs_already_published() {
        return is_already_published;
    }

    public void setIs_already_published(Boolean is_already_published) {
        this.is_already_published = is_already_published;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public LocalDate getStart_reading_date() {
        return start_reading_date;
    }

    public void setStart_reading_date(LocalDate start_reading_date) {
        this.start_reading_date = start_reading_date;
    }

    public LocalDate getEnd_reading_date() {
        return end_reading_date;
    }

    public void setEnd_reading_date(LocalDate end_reading_date) {
        this.end_reading_date = end_reading_date;
    }

    public Saga getSaga() {
        return saga;
    }

    public void setSaga(Saga saga) {
        this.saga = saga;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Collection<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Collection<Genre> genres) {
        this.genres = genres;
    }


    public Collection<Bookshelf> getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(Collection<Bookshelf> bookshelves) {
        this.bookshelves = bookshelves;
    }

    public Collection<Tag> getTags() {
        return tags;
    }

    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
