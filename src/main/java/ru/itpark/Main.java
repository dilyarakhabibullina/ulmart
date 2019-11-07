package ru.itpark;

import ru.itpark.domain.Dress;
import ru.itpark.domain.Oven;
import ru.itpark.domain.Product;
import ru.itpark.repository.Repository;
import ru.itpark.service.ProductService;

import java.util.*;


public class Main {
    private static Repository repository;
    private static ProductService service;

    public static void main(String[] args) {
        final ProductService service = new ProductService(new Repository());
        Repository repository = new Repository();
        service.add(new Product(0, "someproduct", "unknown", 3_000, true));
        service.add(new Dress(0, "dress Dior", "greate", 190_000, true, 4, "blue"));
        service.add(new Oven(0, "panasonic micriwave oven", "awful", 5_000, false, 4, 600));
        service.add(new Oven(0, "sumsung micriwave oven", "not bad", 7_000, true, 400, 800));
        service.add(new Dress(0, "longsleeve dress", "nice", 4_000, true, 1, "green"));
        service.add(new Dress(0, "dress", "nice", 5_500, true, 2, "red"));

        System.out.println(service);
        System.out.println(service.removeById());
        System.out.println(service.searchByPrice());
        System.out.println(service.getSortedByPrice());
        //System.out.println(service.getSortedBy(new HouseByPriceDescComparator()));
        System.out.println(service.getSortedBy(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        }));

    }
}

