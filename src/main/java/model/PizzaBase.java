package model;

import lombok.Getter;

public enum PizzaBase {

    BASE(1),
    CALZONE(0.5);

    @Getter
    public final double value;

    PizzaBase(double value) {
        this.value = value;
    }

}
