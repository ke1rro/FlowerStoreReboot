package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Flower.Flower;
import com.example.demo.repository.FlowerRepository;

@Service
public class FlowerService {
    private final FlowerRepository flowerRepository;

    @Autowired
    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<Flower> findAll() {
        return flowerRepository.findAll();
    }

    public Flower addFlower(Flower flower) {
        return flowerRepository.save(flower);
    }
}

