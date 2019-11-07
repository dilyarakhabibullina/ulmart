package ru.itpark.comparator;

import ru.itpark.domain.Product;

import java.util.Comparator;

public class AscComparator implements Comparator <Product>{
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getPrice()-o2.getPrice();
    }
}
