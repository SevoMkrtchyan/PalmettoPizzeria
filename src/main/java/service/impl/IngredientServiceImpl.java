package service.impl;

import model.Ingredient;
import repository.IngredientRepository;
import service.IngredientService;

import java.util.List;

public class IngredientServiceImpl implements IngredientService {

    private static IngredientRepository ingredientRepository = new IngredientRepository();

    @Override
    public void saveIngredients() {
        Ingredient tomatoPaste = new Ingredient("Tomato paste", 1.0);
        Ingredient cheese = new Ingredient("Cheese", 1.0);
        Ingredient salami = new Ingredient("Salami", 1.5);
        Ingredient bacon = new Ingredient("Bacon", 1.2);
        Ingredient garlic = new Ingredient("Garlic", 0.3);
        Ingredient corn = new Ingredient("Corn", 0.7);
        Ingredient pepperoni = new Ingredient("Pepperoni", 0.6);
        Ingredient olives = new Ingredient("Olives", 0.5);
        ingredientRepository.save(tomatoPaste);
        ingredientRepository.save(cheese);
        ingredientRepository.save(salami);
        ingredientRepository.save(bacon);
        ingredientRepository.save(garlic);
        ingredientRepository.save(corn);
        ingredientRepository.save(pepperoni);
        ingredientRepository.save(olives);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient findByName(String name) {
        return ingredientRepository.findByName(name);
    }

}
