package ru.itpark.repository;

import ru.itpark.domain.Product;

import java.util.ArrayList;
import java.util.Collection;


public class Repository {
    private Collection<Product> products = new ArrayList<>();
    private long nextId;


    public void addProduct(Product product) {
        if (product.getId() == 0) {
            product.setId(nextId++);
        }
        products.add(product);
    }


    public void addAll(Collection<Product> products, Product product) {
        this.products.addAll(products);
    }

    public Collection<Product> getAllProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "products=" + products +
                ", nextId=" + nextId +
                '}';
    }
}