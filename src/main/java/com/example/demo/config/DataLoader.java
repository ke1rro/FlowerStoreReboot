package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Flower.Flower;
import com.example.demo.Flower.FlowerColor;
import com.example.demo.Flower.FlowerSpecs;
import com.example.demo.Flower.FlowerType;
import com.example.demo.repository.FlowerRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final FlowerRepository flowerRepository;

    @Autowired
    public DataLoader(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Add initial flowers to database
        Flower rose = new Flower(25.0, 12.5, new FlowerSpecs(FlowerColor.RED, FlowerType.ROSE));
        Flower tulip = new Flower(18.0, 8.25, new FlowerSpecs(FlowerColor.BLUE, FlowerType.TULIP));
        Flower chamomile = new Flower(12.0, 5.5, new FlowerSpecs(FlowerColor.GREEN, FlowerType.CHAMOMILE));

        flowerRepository.save(rose);
        flowerRepository.save(tulip);
        flowerRepository.save(chamomile);

        System.out.println("Sample flowers loaded into database");
    }
}
