package com.example.demo.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.Flower.Flower;
import com.example.demo.Flower.FlowerColor;
import com.example.demo.Flower.FlowerSpecs;
import com.example.demo.Flower.FlowerType;
import com.example.demo.order.SimpleItem;

class ItemDecoratorTest {

    private SimpleItem baseItem;
    private Flower flower;

    @BeforeEach
    void setUp() {
        baseItem = new SimpleItem("Bucket", 50);
        flower = new Flower(25.0, 12.5, new FlowerSpecs(FlowerColor.RED, FlowerType.ROSE));
    }

    @Test
    void decoratorsStackPriceAndDescription() {
        RibbonDecorator decorated = new RibbonDecorator(new PaperDecorator(baseItem));

        assertEquals(50 + 13 + 40, decorated.getPrice());
        assertTrue(decorated.getDescription().contains("wrapped in paper"));
        assertTrue(decorated.getDescription().contains("with ribbon"));
    }

    @Test
    void paperDecoratorAddsCorrectPrice() {
        PaperDecorator decorated = new PaperDecorator(baseItem);

        assertEquals(50 + 13, decorated.getPrice());
        assertEquals("Bucket wrapped in paper", decorated.getDescription());
    }

    @Test
    void ribbonDecoratorAddsCorrectPrice() {
        RibbonDecorator decorated = new RibbonDecorator(baseItem);

        assertEquals(50 + 40, decorated.getPrice());
        assertEquals("Bucket with ribbon", decorated.getDescription());
    }

    @Test
    void basketDecoratorAddsCorrectPrice() {
        BasketDecorator decorated = new BasketDecorator(baseItem);

        assertEquals(50 + 4, decorated.getPrice());
        assertEquals("Bucket in a basket", decorated.getDescription());
    }

    @Test
    void multipleDecoratorsCanBeStacked() {
        BasketDecorator decorated = new BasketDecorator(
            new RibbonDecorator(
                new PaperDecorator(baseItem)
            )
        );

        assertEquals(50 + 13 + 40 + 4, decorated.getPrice());
        assertTrue(decorated.getDescription().contains("wrapped in paper"));
        assertTrue(decorated.getDescription().contains("with ribbon"));
        assertTrue(decorated.getDescription().contains("in a basket"));
    }

    @Test
    void decoratorsWorkWithFlowers() {
        PaperDecorator decorated = new PaperDecorator(flower);

        assertEquals(12.5 + 13, decorated.getPrice());
        assertTrue(decorated.getDescription().contains("ROSE"));
        assertTrue(decorated.getDescription().contains("wrapped in paper"));
    }

    @Test
    void allThreeDecoratorsOnFlower() {
        BasketDecorator decorated = new BasketDecorator(
            new RibbonDecorator(
                new PaperDecorator(flower)
            )
        );

        // Original price 12.5 + Paper 13 + Ribbon 40 + Basket 4 = 69.5
        assertEquals(12.5 + 13 + 40 + 4, decorated.getPrice());
        assertTrue(decorated.getDescription().contains("ROSE"));
    }
}

