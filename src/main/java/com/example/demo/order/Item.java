package com.example.demo.order;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;

@MappedSuperclass
public abstract class Item {
    @Transient
    private String description;

    protected Item(String description) {
        this.description = description;
    }

    protected Item() {
        this.description = "";
    }

    public String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    public abstract double getPrice();
}
