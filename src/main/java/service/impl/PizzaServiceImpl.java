package service.impl;

import model.Ingredient;
import model.Pizza;
import model.PizzaBase;
import model.PizzaType;
import repository.IngredientRepository;
import repository.PizzaRepository;
import service.PizzaService;

import java.util.ArrayList;
import java.util.List;

public class PizzaServiceImpl implements PizzaService {

    private static PizzaRepository pizzaRepository = new PizzaRepository();
    private static IngredientRepository ingredientRepository = new IngredientRepository();

    @Override
    public Pizza save(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @Override
    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    @Override
    public Pizza findByName(String name) {
        return pizzaRepository.findByName(name);
    }

    public void savePizzas() {
        // TODO: 28.10.21 margarita pizza  2nd task
        List<Ingredient> margaritaIngredients = new ArrayList<>();
        margaritaIngredients.add(ingredientRepository.findByName("Tomato Paste"));
        margaritaIngredients.add(ingredientRepository.findByName("Corn"));
        margaritaIngredients.add(ingredientRepository.findByName("Garlic"));
        margaritaIngredients.add(ingredientRepository.findByName("Bacon"));
        pizzaRepository.save(Pizza.builder()
                .name("Margarita")
                .type(PizzaType.REGULAR)
                .ingredients(margaritaIngredients)
                .base(PizzaBase.BASE)
                .build());

        List<Ingredient> basePzz = new ArrayList<>();
        basePzz.add(ingredientRepository.findByName("Tomato Paste"));
        basePzz.add(ingredientRepository.findByName("Cheese"));
        basePzz.add(ingredientRepository.findByName("Salami"));
        basePzz.add(ingredientRepository.findByName("Olives"));
        pizzaRepository.save(Pizza.builder()
                .name("BasePZZ")
                .type(PizzaType.REGULAR)
                .ingredients(basePzz)
                .base(PizzaBase.CALZONE)
                .build());

        List<Ingredient> pepperoniOro = new ArrayList<>();
        pepperoniOro.add(ingredientRepository.findByName("Pepperoni"));
        pepperoniOro.add(ingredientRepository.findByName("Tomato Paste"));
        pepperoniOro.add(ingredientRepository.findByName("Olives"));
        pizzaRepository.save(Pizza.builder()
                .name("PepperoniOro")
                .type(PizzaType.REGULAR)
                .ingredients(pepperoniOro)
                .base(PizzaBase.BASE)
                .build());
    }
}
