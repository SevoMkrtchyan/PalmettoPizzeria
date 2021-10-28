package service.impl;

import model.Ingredient;
import model.Order;
import model.Pizza;
import repository.IngredientRepository;
import service.MainService;

public class MainServiceImpl implements MainService {

    private static IngredientRepository ingredientRepository = new IngredientRepository();

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
            message.append("[").append(order.getId()).append(" : ").append(order.getCustomer().getId()).append(" : ").append(pizza.getName()).append(" : ").append(pizza.getQuantity()).append("] \n");
        }
        return String.valueOf(message);
    }

    @Override
    public String printCheck(Order order) {
        StringBuilder check = new StringBuilder();
        check.append("*************************").append("\n");
        check.append("Order: ").append(order.getId()).append("\n");
        check.append("Client: ").append(order.getCustomer().getId()).append("\n");
        double totalAmount = 0;
        for (Pizza pizza : order.getPizzas()) {
            double amount = 0;
            check.append(pizza.getName()).append("\n");
            check.append("----------------").append("\n");
            check.append("Pizza Base (").append(pizza.getBase().name()).append(") ")
                    .append(pizza.getBase().value).append(" €").append("\n");

            amount += pizza.getBase().value;

            for (Ingredient ingredient : pizza.getIngredients()) {
                check.append(ingredient.getName()).append(" ").append(ingredient.getPrice()).append(" € \n");
                amount += ingredient.getPrice();
            }
            check.append("----------------").append("\n");
            check.append("Amount: ").append(amount).append("\n");
            check.append("Quantity: ").append(pizza.getQuantity()).append("\n");
            check.append("----------------").append("\n");
            totalAmount += amount * pizza.getQuantity();
        }
        check.append("Total Amount: ").append(totalAmount).append("\n");
        check.append("*************************").append("\n");
        return String.valueOf(check);
    }


}
