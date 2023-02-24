package com.pawel.liquibase.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id = UUID.randomUUID();
    private String title;
    private String author;
    private Integer pagesNumber;
    private Integer releaseYear;
    private String coverType;

    // constructors
    public BookEntity(String title, String author, Integer pagesNumber, Integer releaseYear, String coverType) {
        this.title = title;
        this.author = author;
        this.pagesNumber = pagesNumber;
        this.releaseYear = releaseYear;
        this.coverType = coverType;
    }

    public BookEntity() {
    }

    // getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPagesNumber() {
        return pagesNumber;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPagesNumber(Integer pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }


    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return id.equals(that.id) && title.equals(that.title) && author.equals(that.author) && pagesNumber.equals(that.pagesNumber) && releaseYear.equals(that.releaseYear) && coverType.equals(that.coverType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, pagesNumber, releaseYear, coverType);
    }


    // toString
    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pageNumber=" + pagesNumber +
                ", releaseYear=" + releaseYear +
                ", coverType='" + coverType + '\'' +
                '}';
    }
}
