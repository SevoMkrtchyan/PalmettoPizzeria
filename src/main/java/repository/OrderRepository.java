package repository;

import model.Order;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements GlobalRepository<Order> {

    private static List<Order> orders = new ArrayList<>();
    private static OrderRepository orderRepository = new OrderRepository();

    @Override
    public Order save(Order order) {

        int id = IdGenerator.generateId();
        if (order.getId() == 0) {
            if (!orders.isEmpty()) {
                for (Order orderFromDb : orders) {
                    if (orderFromDb.getId() == id) {
                        break;
                    } else {
                        order.setId(id);
                    }
                }
            } else {
                order.setId(id);
            }
            orders.add(order);
        } else {
            for (Order order1 : orders) {
                order1.setCustomer(order.getCustomer());
                order1.getPizzas().addAll(order.getPizzas());
                order1.getPizzasQuantity().putAll(order1.getPizzasQuantity());
                orders.add(order1);
                order = order1;
            }
        }

        return order;
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }

    @Override
    public Order findById(int id) {
        if (!orders.isEmpty()) {
            for (Order order : orders) {
                if (order.getId() == id) {
                    return order;
                }
            }
        }
        return null;
    }

}