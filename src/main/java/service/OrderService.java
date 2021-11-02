package service;

import model.Order;

import java.util.List;

public interface OrderService {

    Order save(Order order);

    List<Order> findAll();
}