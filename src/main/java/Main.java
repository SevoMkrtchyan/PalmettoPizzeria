import model.*;
import service.impl.CustomerServiceImpl;
import service.impl.IngredientServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.PizzaServiceImpl;
import util.CheckPrinter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static IngredientServiceImpl ingredientService = new IngredientServiceImpl();
    private static CustomerServiceImpl customerService = new CustomerServiceImpl();
    private static PizzaServiceImpl pizzaService = new PizzaServiceImpl();
    private static OrderServiceImpl orderService = new OrderServiceImpl();

    public static void main(String[] args) {
        ingredientService.saveIngredients();
        pizzaService.savePizzas();

        // ordering pizza
        Customer poxos = customerService.save(new Customer("Poxos"));
        Customer petros = customerService.save(new Customer("Petros"));
        Customer vahe = customerService.save(new Customer("Vahe"));

        System.out.println(poxos.getName() + " wants to order pizza");
        System.out.println("Generating order");

        List<Ingredient> ingredients = ingredientService.findAll();
        ingredients.forEach(System.out::println);

        List<Ingredient> ingredientList = new ArrayList<>();

        ingredientList.add(ingredientService.findByName("Bacon"));
        ingredientList.add(ingredientService.findByName("Garlic"));
        ingredientList.add(ingredientService.findByName("Corn"));
        ingredientList.add(ingredientService.findByName("Pepperoni"));
        ingredientList.add(ingredientService.findByName("Olives"));

        List<Ingredient> ingredientList1 = new ArrayList<>();

        ingredientList1.add(ingredientService.findByName("Tomato Paste"));
        ingredientList1.add(ingredientService.findByName("Bacon"));
        ingredientList1.add(ingredientService.findByName("Garlic"));
        ingredientList1.add(ingredientService.findByName("Pepperoni"));
        ingredientList1.add(ingredientService.findByName("Olives"));

        Pizza hamov = pizzaService.save(new Pizza("hamov", ingredientList, 2, PizzaType.REGULAR));
        Pizza anham = pizzaService.save(new Pizza("anham", ingredientList1, 5, PizzaType.CALZONE));

        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(hamov);
        pizzas.add(anham);

        Order order = orderService.save(new Order(poxos,pizzas));

        System.out.println("---------------------------------------");
        String s = pizzaService.displayPizzaAttributes(order);
        System.out.println(s);
        System.out.println("---------------------------------------");
        String check = CheckPrinter.printCheck(order);
        System.out.println(check);
        System.out.println("----------------------------------------");
        List<Pizza> pizzaList = pizzaService.findAll();
        pizzaList.forEach(System.out::println);
        System.out.println("----------------------------------------");

        Order vaheOrder = new Order();
        vaheOrder.setCustomer(vahe);
        List<Pizza> vahePizzas = new ArrayList<>();
        Pizza margarita = pizzaService.findByName("Margarita");
        Pizza pepperoniOro = pizzaService.findByName("PepperoniOro");
        if (margarita != null) {
            margarita.setQuantity(2);
            vahePizzas.add(margarita);
        }

        if (pepperoniOro != null) {
            pepperoniOro.setQuantity(3);
            vahePizzas.add(margarita);
        }
        vaheOrder.setPizzas(vahePizzas);
        orderService.save(vaheOrder);
        String printCheck = CheckPrinter.printCheck(vaheOrder);
        System.out.println("Vahe's order check");
        System.out.println(printCheck);
        System.out.println("----------------------------------------");

        Order petrosOrder = new Order();
        petrosOrder.setCustomer(petros);
        List<Pizza> petrosPizzas = new ArrayList<>();
        Pizza basePZZ = pizzaService.findByName("BasePZZ");
        if (basePZZ != null) {
            basePZZ.setQuantity(12);
            petrosPizzas.add(basePZZ);
        }
        petrosOrder.setPizzas(petrosPizzas);
        orderService.save(petrosOrder);
        String petrosCheck = CheckPrinter.printCheck(petrosOrder);
        System.out.println("Petros's order check");
        System.out.println(petrosCheck);
        System.out.println("----------------------------------------");

    }

}
