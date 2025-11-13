package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Flower.Flower;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Long> {
}

