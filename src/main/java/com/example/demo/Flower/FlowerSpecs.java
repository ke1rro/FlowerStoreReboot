package com.example.demo.Flower;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class FlowerSpecs {

    @Enumerated(EnumType.STRING)
    private FlowerColor color;

    @Enumerated(EnumType.STRING)
    private FlowerType type;

    public FlowerSpecs(FlowerColor color, FlowerType type) {
        this.color = color;
        this.type = type;
    }

    public boolean isMatch(FlowerSpecs other) {
        if (type != other.type) {
            return false;
        }
        if (color != other.color) {
            return false;
        }
        return true;
    }

}
