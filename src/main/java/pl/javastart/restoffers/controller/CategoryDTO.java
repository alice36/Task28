package pl.javastart.restoffers.controller;

import pl.javastart.restoffers.model.Offer;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class CategoryDTO {
    private Long id;
    private String name;
    private String description;
    private long offers;

    public CategoryDTO(Long id, String name, String description, long offers) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.offers = offers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getOffers() {
        return offers;
    }

    public void setOffers(long offers) {
        this.offers = offers;
    }
}
