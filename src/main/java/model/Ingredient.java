package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class Ingredient {

    private int id;
    private String name;
    private double price;

    public Ingredient(){
    }


    public Ingredient(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Ingredient(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
