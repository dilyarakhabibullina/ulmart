package ru.itpark;

import ru.itpark.domain.Dress;
import ru.itpark.domain.Oven;
import ru.itpark.domain.Product;
import ru.itpark.repository.Repository;
import ru.itpark.service.ProductService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class Main {
    private static Repository repository;
    private static ProductService service;

    public static void main(String[] args) {
        List<Product> product = new ArrayList<>();
        product.add(new Product(1, "someproduct", "unknown", 3_000, true));
        product.add(new Dress(5, "dress Dior", "greate", 190_000, true, 4, "blue"));
        product.add(new Oven(3, "micriwave", "awful", 5_000, false, 4, 600));
        product.add(new Oven(4, "micriwave", "not bad", 7_000, true, 400, 800));
        product.add(new Dress(2, "dress", "nice", 3, true, 1, "green"));
        product.add(new Dress(6, "longsleeve dress", "nice", 4_000, true, 1, "green"));
        long removingId = 3;
        product.removeIf(o -> o.getId() == removingId);
        System.out.println(product);



        //Я хочу вызвать метод searchByName из класса ProductService. Почему вот на этой строке выбрасывается nullpointerexception?
          //  System.out.println(service.searchByName("ress"));

        //Вот этот кусок кода работает!
        List<Product> result = new ArrayList<>();

        for (Product product1 : product) {
            if (product1.getName().contains("ress")) {
                result.add(product1);

            }}
        Collections.sort(result, (o1, o2) -> o1.getId() < o2.getId() ? -1 : o1.getId()==o2.getId() ? 0:1);
        System.out.println(result);

//            class ItemSearchByNameComparator implements Comparator<Product> {
//                public int compare(Product o1, Product o2) {
//                    return (int) (o1.getId() - o2.getId());
//                }
            }
        }

