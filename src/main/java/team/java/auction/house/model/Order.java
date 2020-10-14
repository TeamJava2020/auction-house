package team.java.auction.house.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String clientName;
    private String item;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    public Order() {
    }

    public Order(Long id, String name, String clientName, String item, OrderStatus status) {
        this.id = id;
        this.name = name;
        this.clientName = clientName;
        this.item = item;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(name, order.name) &&
                Objects.equals(clientName, order.clientName) &&
                Objects.equals(item, order.item) &&
                status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, clientName, item, status);
    }
}
