package com.pawel.liquibase.dto;

public class BookDto {
    private String title;
    private String author;
    private Integer pagesNumber;
    private Integer releaseYear;
    private String coverType;

    // constructors
    public BookDto() {
    }

    // getters
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

    // setters
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
}
