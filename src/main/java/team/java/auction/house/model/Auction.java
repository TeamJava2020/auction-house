package team.java.auction.house.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private AuctionStatus status;
    private double price;

    public Auction() {
    }

    public Auction(Long id, String name, AuctionStatus status, double price) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.price = price;
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

    public AuctionStatus getStatus() {
        return status;
    }

    public void setStatus(AuctionStatus status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auction auction = (Auction) o;
        return Double.compare(auction.price, price) == 0 &&
                Objects.equals(id, auction.id) &&
                Objects.equals(name, auction.name) &&
                status == auction.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, price);
    }
}
