package repository;

import model.Ingredient;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class IngredientRepository implements GlobalRepository<Ingredient> {

    private static final List<Ingredient> ingredients = new ArrayList<>();

    @Override
    public Ingredient save(Ingredient ingredient) {
        int id = IdGenerator.generateId();
        if (!ingredients.isEmpty()) {
            for (Ingredient ingredientFromDb : ingredients) {
                if (ingredientFromDb.getId() == id) {
                    break;
                } else {
                    ingredient.setId(id);
                }
            }
        } else {
            ingredient.setId(id);
        }
        ingredients.add(ingredient);
        return ingredient;
    }


    public List<Ingredient> findAll() {
        return ingredients;
    }

    @Override
    public Ingredient findById(int id) {
        if (!ingredients.isEmpty()) {
            for (Ingredient ingredient : ingredients) {
                if (ingredient.getId() == id) {
                    return ingredient;
                }
            }
        }
        return null;
    }

    public Ingredient findByName(String name) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equalsIgnoreCase(name)) {
                return ingredient;
            }
        }
        return null;
    }

}
