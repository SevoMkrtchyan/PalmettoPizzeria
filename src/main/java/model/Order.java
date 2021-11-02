package model;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Order {

    private int id;
    private Customer customer;
    private List<Pizza> pizzas;
    private LocalTime localTime;
    private Map<Pizza, Integer> pizzasQuantity;

    public Order() {
    }

    public Order(Customer customer, List<Pizza> pizzas, Map<Pizza, Integer> pizzasQuantity) {
        this.customer = customer;
        this.pizzas = pizzas;
        this.pizzasQuantity = pizzasQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public Map<Pizza, Integer> getPizzasQuantity() {
        return pizzasQuantity;
    }

    public void setPizzasQuantity(Map<Pizza, Integer> pizzasQuantity) {
        this.pizzasQuantity = pizzasQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Objects.equals(customer, order.customer) && Objects.equals(pizzas, order.pizzas) && Objects.equals(localTime, order.localTime) && Objects.equals(pizzasQuantity, order.pizzasQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, pizzas, localTime, pizzasQuantity);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", pizzas=" + pizzas +
                ", localTime=" + localTime +
                ", pizzasQuantity=" + pizzasQuantity +
                '}';
    }
}