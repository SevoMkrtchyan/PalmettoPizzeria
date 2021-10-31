package model;

import java.util.List;
import java.util.Objects;

public class Pizza {

    private int id;
    private String name;
    private List<Ingredient> ingredients;
    private int quantity;
    private PizzaType type;

    public Pizza() {
    }

    public Pizza(String name, List<Ingredient> ingredients, int quantity, PizzaType type) {
        this.name = name;
        if (ingredients.size() > 7) {
            this.ingredients = ingredients.subList(0, 10);
        } else {
            this.ingredients = ingredients;
        }
        this.quantity = quantity;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PizzaType getType() {
        return type;
    }

    public void setType(PizzaType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return id == pizza.id && quantity == pizza.quantity && Objects.equals(name, pizza.name) && Objects.equals(ingredients, pizza.ingredients) && type == pizza.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ingredients, quantity, type);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", quantity=" + quantity +
                ", type=" + type +
                '}';
    }

}
