package com.team2.store.entities;

import javax.persistence.*;

/**
 * Created by Isaiev on 22.02.2016.
 */

@Entity
@Table(name="product")
@NamedQueries({
        @NamedQuery(name = Product.getAllProducts, query = "SELECT role FROM Product role")
})
public class Product {

    public static final String getAllProducts = "getAllProducts";

    @Id
    @GeneratedValue
    private int product_id;

    @Column(name="productName")
    private String productName;

    @Column(name="count")
    private int count;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
