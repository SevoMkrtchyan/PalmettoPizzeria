package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pizza {

    private int id;
    private String name;
    private List<Ingredient> ingredients;
    private int quantity;
    private PizzaType type;
    private PizzaBase base;

    public Pizza(String name, List<Ingredient> ingredients, int quantity, PizzaType type, PizzaBase base) {
        this.name = name;
        if (ingredients.size() > 7) {
            this.ingredients = ingredients.subList(0, 10);
        } else {
            this.ingredients = ingredients;
        }
        this.quantity = quantity;
        this.type = type;
        this.base = base;
    }

}
