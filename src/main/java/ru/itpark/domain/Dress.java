package ru.itpark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Dress extends Product {
    private int size;
    private String color;

    public Dress(int size, String color) {
        this.size = size;
        this.color = color;
    }

    public Dress(int id, String name, String description, int price, boolean isAvailable, int size, String color) {
        super(id, name, description, price, isAvailable);
        this.size = size;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dress{"+ "id=" + getId() + ", name=" + getName()+  ", description=" + getDescription() + ", price="+ getPrice()
                +
                ", size=" + size +
                ", color='" + color + '\'' +
                '}';
    }
}
