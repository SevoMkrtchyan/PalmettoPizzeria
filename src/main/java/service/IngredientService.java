package service;

import model.Ingredient;

import java.util.List;

public interface IngredientService {

    void saveIngredients();

    Ingredient save(Ingredient ingredient);

    List<Ingredient> findAll();

    Ingredient findByName(String name);

}
