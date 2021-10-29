package util;

import model.Ingredient;
import model.Order;
import model.Pizza;

public class CheckPrinter {


    public static String printCheck(Order order) {
        StringBuilder check = new StringBuilder();
        check.append("*************************").append("\n");
        check.append("Order: ").append(order.getId()).append("\n");
        check.append("Client: ").append(order.getCustomer().getId()).append("\n");
        double totalAmount = 0;
        for (Pizza pizza : order.getPizzas()) {
            double amount = 0;
            check.append(pizza.getName()).append("\n");
            check.append("----------------").append("\n");
            check.append("Pizza Base (").append(pizza.getType().name()).append(") ")
                    .append(pizza.getType().value).append(" €").append("\n");
            amount += pizza.getType().value;
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
