package ru.itpark;

import ru.itpark.domain.Dress;
import ru.itpark.domain.Oven;
import ru.itpark.domain.Product;
import ru.itpark.repository.Repository;
import ru.itpark.service.ProductService;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        final ProductService service = new ProductService(new Repository());
        service.add(new Product(0, "someproduct", "unknown", 3_000, true, 100));
        service.add(new Dress(0, "dress Dior", "greate", 190_000, true, 450, 200, "blue"));
        service.add(new Oven(0, "panasonic microwave oven", "awful", 5_000, false, 400, 600, 1000));
        service.add(new Oven(0, " a samsung microwave oven", "not bad", 7_000, true, 1401, 800, 350));
        service.add(new Dress(0, "longsleeve dress", "nice", 4_000, true, 800, 1, "green"));
        service.add(new Dress(0, "dress", "nice", 5_500, true, 560, 2, "red"));
        System.out.println(service);
        System.out.println(service.searchByCategory());
        System.out.println(service.removeById(4));
        System.out.println(service.searchByPrice(4000, 5500));
        System.out.println(service.searchByName("micro"));
        System.out.println(service.getSortedByPrice());
        System.out.println(service.getSortedBy((o1, o2) -> -(o1.getPrice() - o2.getPrice())));
        System.out.println(service.getSortedByRate((o1, o2) -> o1.getRate() - o2.getRate()));
        System.out.println(service.getSortedBy((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())));

    }
}

