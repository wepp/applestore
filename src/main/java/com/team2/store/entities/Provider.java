package com.team2.store.entities;

import javax.persistence.*;

/**
 * Created by Isaiev on 22.02.2016.
 */

@Entity
@Table(name="provider")
public class Provider {

    @Id
    @GeneratedValue
    private int provider_id;

    @Column(name="name")
    private String name;

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
