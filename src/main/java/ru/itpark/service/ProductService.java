package ru.itpark.service;
//TODO-убрать мусор из репозитория Гитхаб

import ru.itpark.comparator.AscComparator;
import ru.itpark.domain.Dress;
import ru.itpark.domain.Oven;
import ru.itpark.domain.Product;
import ru.itpark.repository.Repository;

import java.util.*;

public class ProductService implements Comparator {
    private final Repository repository;

    public ProductService(Repository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        if (product.getId() != 0) {
            throw new IllegalArgumentException("id must be zero!");
        }
        if (product.getPrice() <= 0) {
            throw new IllegalArgumentException("price must be greater than zero");
        }
        repository.addProduct(product);
    }

    private Collection<Product> product = new ArrayList<>();

    public List<Product> getSortedByPrice() {
        return getSortedBy(new AscComparator());
    }

    public List<Product> getSortedBy(Comparator<Product> comparator) {
        List<Product> result = new LinkedList<>(repository.getAllProducts());
        result.sort(comparator);
        return result;
    }

    public List<Product> searchByName(String text) {
        List<Product> products = new ArrayList<>();
        for (Product product1 : products) {
            if (product1.getName().contains(text)) {
                products.add(product1);
            }
        }
        return products;
    }

    public List<Product> searchByPrice() {
        //  int min = 4000; int max = 100_000;
        List<Product> resultPrice = new ArrayList<>();
        //почему при попытке передать все продукты в список resultPrice (как написано на строчке ниже) при запуске
        // вылезает exception??? Как избежать этого исключения?
        // List<Product> resultPrice = new ArrayList<>(repository.getAllProducts());

        for (Product product : resultPrice) {

            if (product.getPrice() > 4000 && product.getPrice() <= 5500) {
                resultPrice.add(product);
                resultPrice.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getPrice() - o2.getPrice();
                    }
                });
            }
        }


        return resultPrice;
    }


    public List<Product> removeById() {
        ArrayList<Product> product = new ArrayList<>();
        product.add(new Product(1, "someproduct", "unknown", 3_000, true));
        product.add(new Dress(2, "dress Dior", "greate", 190_000, true, 4, "blue"));
        product.add(new Oven(3, "panasonic micriwave oven", "awful", 5_000, false, 4, 600));
        product.removeIf(o -> o.getId() == 1);
        return product;
    }


    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
    @Override
    public String toString() {
        return "ProductService{" +
                "repository=" + repository +
                ", product=" + product +
                '}';
    }

}

//    public List<Product> searchByName() {
//        ArrayList<Product> result = new ArrayList<>();
//        for (Product item : items) {
//            if (item.getName().contains("ress")) {
//                result.add(item);
//            }
//







