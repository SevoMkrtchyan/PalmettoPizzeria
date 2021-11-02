package service.impl;

import model.Order;
import model.Pizza;
import repository.OrderRepository;
import repository.PizzaRepository;
import service.OrderService;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private static PizzaRepository pizzaRepository = new PizzaRepository();
    private static OrderRepository orderRepository = new OrderRepository();

    @Override
    public Order save(Order order) {
        List<Pizza> pizzas = new ArrayList<>();
        order.setLocalTime(LocalTime.now());
        for (Pizza pizza : order.getPizzas()) {
            if (pizza.getName().toCharArray().length >= 4 && pizza.getName().toCharArray().length <= 20) {
                if (!pizza.getName().matches("^[A-Za-z]+$")) {
                    pizza.setName(order.getCustomer().getName() + "_" + pizza.getId());
                    pizza = pizzaRepository.save(pizza);
                }
                pizzas.add(pizza);
            }
        }
        order.setPizzas(pizzas);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }


}
