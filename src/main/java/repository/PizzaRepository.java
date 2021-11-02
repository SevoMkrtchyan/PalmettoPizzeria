package repository;

import model.Pizza;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class PizzaRepository implements GlobalRepository<Pizza> {

    private static List<Pizza> pizzas = new ArrayList<>();

    @Override
    public Pizza save(Pizza pizza) {
        int id = IdGenerator.generateId();
        if (pizza.getId() == 0) {
            if (!pizzas.isEmpty()) {
                for (Pizza pizzaFromDb : pizzas) {
                    if (pizzaFromDb.getId() == id) {
                        pizza.setId(id + pizzas.size());
                    } else {
                        pizza.setId(id);
                    }
                }
            } else {
                pizza.setId(id);
            }
        } else {
            for (Pizza pizza1 : pizzas) {
                if (pizza1.getId() == pizza.getId()) {
                    pizza1.setName(pizza.getName());
                    pizza1.getIngredients().addAll(pizza.getIngredients());
                    pizza1.setType(pizza.getType());
                    pizzas.add(pizza1);
                    pizza = pizza1;
                }
            }
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
