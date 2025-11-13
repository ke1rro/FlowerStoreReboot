package com.example.demo.Flower;

import com.example.demo.order.Item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "flowers")
public class Flower extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sepal_length")
    private double sepallength;

    @Column(name = "price")
    private double price;

    @Embedded
    private FlowerSpecs specs;

    public Flower() {
        super("Flower");
    }

    public Flower(Flower flower) {
        super(flower.getDescription());
        this.sepallength = flower.sepallength;
        this.price = flower.price;
        this.specs = new FlowerSpecs(flower.getColor(), flower.getSpecs().getType());
    }

    public Flower(double sepallength, double price, FlowerSpecs specs) {
        super(buildDescription(specs));
        this.sepallength = sepallength;
        this.price = price;
        this.specs = specs;
    }

    public void setColor(FlowerColor color) {
        specs.setColor(color);
        refreshDescription();
    }

    public void setType(FlowerType type) {
        specs.setType(type);
        refreshDescription();
    }

    public FlowerColor getColor() {
        return specs.getColor();
    }

    public FlowerSpecs getSpecs() {
        return specs;
    }

    @Override
    public double getPrice() {
        return price;
    }

    private void refreshDescription() {
        setDescription(buildDescription(specs));
    }

    private static String buildDescription(FlowerSpecs specs) {
        if (specs == null) {
            return "Flower";
        }
        return specs.getType() + " (" + specs.getColor() + ")";
    }

    @Override
    public String toString() {
        return ("Flower [sepallength=" + sepallength
                + ", price="
                + price + ", color=" + specs.getColor()
                + ", type=" + specs.getType() + "]");
    }

}
