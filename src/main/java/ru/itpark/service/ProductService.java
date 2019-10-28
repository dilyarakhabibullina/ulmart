package ru.itpark.service;

import ru.itpark.domain.Product;

import java.util.*;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addItem(Product item) {
        products.add(item);//добавление элемента в конец списка
    }

    public void addAll(Collection<Product> products) {
        this.products.addAll(products);
        //добавление всех элементов через коллекцию
    }

    public List<Product> searchByName(String text) {
        List<Product> product = new ArrayList<>();
        for (Product product1 : product) {
            if (product1.getName().contains(text)) {
                product.add(product1);
            }
        }
        return product;
    }
}
//    public List<Product> searchByName() {
//        ArrayList<Product> result = new ArrayList<>();
//        for (Product item : items) {
//            if (item.getName().contains("ress")) {
//                result.add(item);
//            }
//







