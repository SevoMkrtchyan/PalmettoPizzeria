import model.*;
import service.impl.CustomerServiceImpl;
import service.impl.IngredientServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.PizzaServiceImpl;
import util.CheckPrinter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Pizza hamov = pizzaService.save(new Pizza("hamov", ingredientList, PizzaType.REGULAR));
        Pizza anham = pizzaService.save(new Pizza("anham", ingredientList1, PizzaType.CALZONE));

        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(hamov);
        pizzas.add(anham);
        System.out.println("pordznakan"+hamov);

        Map<Pizza, Integer> quantity1 = new HashMap<>();
        quantity1.put(hamov, 5);
        quantity1.put(anham, 3);
        System.out.println();
        System.out.println("pordznakan"+hamov);
        Order order = orderService.save(new Order(poxos, pizzas, quantity1));
        System.out.println(order);
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
        Map<Pizza, Integer> vahePizzasCount = new HashMap<>();
        Pizza margarita = pizzaService.findByName("Margarita");
        if (margarita != null) {
            vahePizzas.add(margarita);
            vahePizzasCount.put(margarita, 2);
        }

        Pizza pepperoniOro = pizzaService.findByName("PepperoniOro");
        if (pepperoniOro != null) {
            vahePizzas.add(margarita);
            vahePizzasCount.put(pepperoniOro, 3);
        }

        vaheOrder.setPizzasQuantity(vahePizzasCount);
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
        Map<Pizza, Integer> petrosPizzasCount = new HashMap<>();

        if (basePZZ != null) {
            petrosPizzas.add(basePZZ);
            petrosPizzasCount.put(basePZZ, 12);
        }

        petrosOrder.setPizzasQuantity(petrosPizzasCount);

        petrosOrder.setPizzas(petrosPizzas);
        orderService.save(petrosOrder);
        String petrosCheck = CheckPrinter.printCheck(petrosOrder);
        System.out.println("Petros's order check");
        System.out.println(petrosCheck);
        System.out.println("----------------------------------------");

    }

}