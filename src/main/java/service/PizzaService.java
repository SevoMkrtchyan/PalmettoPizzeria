package service;

import model.Pizza;

import java.util.List;

public interface PizzaService {

    Pizza save(Pizza pizza);

    List<Pizza> findAll();

    Pizza findByName(String name);

}
