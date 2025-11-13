package com.example.demo.Flower;

public class RomashkaFlower extends Flower {

    public RomashkaFlower(double sepallength, double price, FlowerColor color) {
        super(sepallength, price, new FlowerSpecs(color, FlowerType.CHAMOMILE));
    }
}
