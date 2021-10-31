package model;


public enum PizzaType {

    REGULAR(1),
    CALZONE(0.5);

    public final double value;

    PizzaType(double value) {
        this.value = value;
    }

}
