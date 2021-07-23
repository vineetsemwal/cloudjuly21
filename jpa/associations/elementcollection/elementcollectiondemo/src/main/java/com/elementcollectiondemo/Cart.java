package com.elementcollectiondemo;

import javax.persistence.*;
import java.util.Map;
import java.util.Objects;


@Entity
public class Cart {

    @GeneratedValue
    @Id
    private Long id;

    private Long userId;




    @ElementCollection(fetch= FetchType.EAGER)
    private Map<Long,Integer> items;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Map<Long, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Long, Integer> items) {
        this.items = items;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
