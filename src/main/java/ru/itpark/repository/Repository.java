package ru.itpark.repository;

import ru.itpark.domain.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Repository {
    private Collection<Product> products = new ArrayList<>();
    private long nextId;


    public void addProduct(Product product) {
        if (product.getId() == 0) {
            product.setId(nextId++);
        }
        products.add(product);
    }

    public Collection<Product> getAllProducts() {
        return products;
    }

//    public Collection<Product> removeById(Product product) {
//        List <Product> removedProducts =new ArrayList<>();
//        long removingId = 2;
//        removedProducts.removeIf(o -> product.getId() == removingId);
//        return removedProducts;
//
//    }



}