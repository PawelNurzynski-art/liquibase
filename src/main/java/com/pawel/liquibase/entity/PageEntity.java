package com.pawel.liquibase.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "page")
public class PageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id = UUID.randomUUID();
    private Integer pageNumber;

    // constructors
    public PageEntity(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public PageEntity() {
    }

    // getters and setters
    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }


    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageEntity that = (PageEntity) o;
        return id.equals(that.id) && pageNumber.equals(that.pageNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pageNumber);
    }


    // toString
    @Override
    public String toString() {
        return "PageEntity{" +
                "id=" + id +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
