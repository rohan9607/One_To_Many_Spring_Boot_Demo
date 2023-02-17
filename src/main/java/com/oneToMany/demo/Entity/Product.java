package com.oneToMany.demo.Entity;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @SequenceGenerator(name="products_id_seq",
            sequenceName="products_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="products_id_seq")
    @Column(name = "id", updatable=false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "qty")
    private int qty;
    @Column(name = "price")
    private int price;
//    Constructors
    public Product() {
    }

    public Product(String name, int qty, int price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

//    Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
