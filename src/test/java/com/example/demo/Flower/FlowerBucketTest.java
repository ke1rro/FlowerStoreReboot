package com.example.demo.Flower;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class FlowerBucketTest {

    @Test
    void bucketAggregatesPriceAndSearchesBySpecs() {
        FlowerBucket bucket = new FlowerBucket();
        Flower rose = new Flower(20, 15, new FlowerSpecs(FlowerColor.RED, FlowerType.ROSE));
        Flower tulip = new Flower(18, 9, new FlowerSpecs(FlowerColor.BLUE, FlowerType.TULIP));
        bucket.addFlowers(List.of(rose, tulip));

        assertEquals(24, bucket.getPrice());
        assertTrue(bucket.searchFlowers(new FlowerSpecs(FlowerColor.RED, FlowerType.ROSE)));
    }
}

