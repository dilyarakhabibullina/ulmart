package ru.itpark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Oven extends Product {
    private int capacity;
    private int power;

    public Oven(int capacity, int power) {
        this.capacity = capacity;
        this.power = power;
    }

    public Oven(int id, String name, String description, int price, boolean isAvailable, int capacity, int power) {
        super(id, name, description, price, isAvailable);
        this.capacity = capacity;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Oven{" + " id=" + getId() + ", name =" + getName()+  ", description=" + getDescription() + ", price="+ getPrice()
+                ", capacity=" + capacity +
                ", power=" + power +
                '}';
    }
}
