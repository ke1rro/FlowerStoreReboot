package com.example.demo.Flower;

public class CactusFlower extends Flower {

    public CactusFlower(double sepallength, double price) {
        super(sepallength, price, new FlowerSpecs(FlowerColor.GREEN, FlowerType.CACTUS));
    }
}
