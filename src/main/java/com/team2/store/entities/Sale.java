package com.team2.store.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Isaiev on 22.02.2016.
 */
@Entity
@Table(name="sale")
public class Sale {

    @Id
    @GeneratedValue
    private int sale_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name="count")
    private int count;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="time")
    private long time;

    public int getSale_id() {
        return sale_id;
    }

    public void setSale_id(int sale_id) {
        this.sale_id = sale_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getDate() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
