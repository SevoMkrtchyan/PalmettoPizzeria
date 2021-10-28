package service;

import model.Ingredient;
import model.Order;
import model.Pizza;

public interface MainService {

    String addIngredient(Pizza pizza, Ingredient ingredient);

    String displayPizzaAttributes(Order order);

    String printCheck(Order order);

}
