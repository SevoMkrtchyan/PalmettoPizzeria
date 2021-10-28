package repository;

import model.Ingredient;
import model.Pizza;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class PizzaRepository implements GlobalRepository<Pizza> {

    private static List<Pizza> pizzas = new ArrayList<>();
    private IngredientRepository ingredientRepository = new IngredientRepository();

    @Override
    public Pizza save(Pizza pizza) {
        int id = IdGenerator.generateId();
        if (!pizzas.isEmpty()) {
            for (Pizza pizzaFromDb : pizzas) {
                if (pizzaFromDb.getId() == id) {
                    break;
                } else {
                    pizza.setId(id);
                }
            }
        } else {
            pizza.setId(id);
        }
        pizzas.add(pizza);
        return pizza;
    }

    @Override
    public List<Pizza> findAll() {
        return pizzas;
    }

    @Override
    public Pizza findById(int id) {
        if (!pizzas.isEmpty()) {
            for (Pizza pizza : pizzas) {
                if (pizza.getId() != id) {
                    return null;
                }
                return pizza;
            }
        }
        return null;
    }

    public Pizza findByName(String name) {
        for (Pizza pizza : pizzas) {
            if (pizza.getName().equalsIgnoreCase(name)) {
                return pizza;
            }
        }
        return null;
    }

}
