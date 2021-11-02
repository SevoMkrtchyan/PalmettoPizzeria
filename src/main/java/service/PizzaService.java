package service;

import model.Ingredient;
import model.Order;
import model.Pizza;

import java.util.List;

public interface PizzaService {

    Pizza save(Pizza pizza);

    List<Pizza> findAll();

    Pizza findByName(String name);

    String addIngredient(Pizza pizza, Ingredient ingredient);

    String displayPizzaAttributes(Order order);

    void savePizzas();

}