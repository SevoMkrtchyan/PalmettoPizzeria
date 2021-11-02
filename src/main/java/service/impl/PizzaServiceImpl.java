package service.impl;

import model.Ingredient;
import model.Order;
import model.Pizza;
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

    @Override
    public String addIngredient(Pizza pizza, Ingredient ingredient) {
        Ingredient byName = ingredientRepository.findByName(ingredient.getName());
        if (byName == null) {
            return "Ingredient with " + ingredient.getName() + " not found";
        } else if (pizza.getIngredients().size() == 7) {
            return "Your Pizzas ingredients are ful, cannot add a new ingredient";
        } else if (pizza.getIngredients().contains(ingredient)) {
            return "Your Pizza already contains that ingredient";
        } else {
            pizza.getIngredients().add(byName);
        }
        return "Ingredient successfully added in pizza";
    }

    @Override
    public String displayPizzaAttributes(Order order) {
        StringBuilder message = new StringBuilder();
        for (Pizza pizza : order.getPizzas()) {
            message.append("[").append(order.getId()).append(" : ")
                    .append(order.getCustomer().getId()).append(" : ")
                    .append(pizza.getName()).append(" : ").append("] \n");
        }
        return String.valueOf(message);
    }

    @Override
    public void savePizzas() {
        // TODO: 28.10.21 margarita pizza  2nd task
        List<Ingredient> margaritaIngredients = new ArrayList<>();
        margaritaIngredients.add(ingredientRepository.findByName("Tomato Paste"));
        margaritaIngredients.add(ingredientRepository.findByName("Corn"));
        margaritaIngredients.add(ingredientRepository.findByName("Garlic"));
        margaritaIngredients.add(ingredientRepository.findByName("Bacon"));
        pizzaRepository.save(new Pizza("Margarita", margaritaIngredients, PizzaType.REGULAR));

        List<Ingredient> basePzz = new ArrayList<>();
        basePzz.add(ingredientRepository.findByName("Tomato Paste"));
        basePzz.add(ingredientRepository.findByName("Cheese"));
        basePzz.add(ingredientRepository.findByName("Salami"));
        basePzz.add(ingredientRepository.findByName("Olives"));
        pizzaRepository.save(new Pizza("BasePZZ", basePzz, PizzaType.CALZONE));

        List<Ingredient> pepperoniOro = new ArrayList<>();
        pepperoniOro.add(ingredientRepository.findByName("Pepperoni"));
        pepperoniOro.add(ingredientRepository.findByName("Tomato Paste"));
        pepperoniOro.add(ingredientRepository.findByName("Olives"));
        pizzaRepository.save(new Pizza("PepperoniOro", pepperoniOro, PizzaType.REGULAR));
    }
}