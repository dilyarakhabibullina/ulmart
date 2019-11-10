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

    //TODO- сделать сервис addAll и использовать его в main
    private Collection<Product> product = new ArrayList<>();

    public List<Product> getSortedByPrice() {
        return getSortedBy(new AscComparator());
        //TODO- use lambda
    }

    public List<Product> getSortedBy(Comparator<Product> comparator) {
        List<Product> result = new LinkedList<>(repository.getAllProducts());
        result.sort(comparator);
        return result;
    }
    public List<Product> getSortedByRate(Comparator<Product> comparator) {
        List<Product> result = new LinkedList<>(repository.getAllProducts());
        result.sort(comparator);
        return result;
    }
    public List<Product> searchByName(String text) {
        List<Product> product = new ArrayList<>();
        for (Product product1 : repository.getAllProducts()) {
            if (product1.getName().contains(text)) {
                product.add(product1);
                product.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getName().compareToIgnoreCase(o2.getName());
                    }
                });
            }
        }
        return product;
    }

    public List<Product> searchByPrice(int min, int max) {
        List<Product> resultByPrice = new ArrayList<>();
        for (Product house : repository.getAllProducts()) {
            if (min < house.getPrice() && max >= house.getPrice()) {
                resultByPrice.add(house);
                resultByPrice.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return  o1.getName().compareToIgnoreCase(o2.getName());
                    }
                });
            }
        }
        return resultByPrice;
    }

    public List<Product> removeById(int id) {
        ArrayList<Product> product = new ArrayList<>(repository.getAllProducts());
//        product.add(new Product(1, "someproduct", "unknown", 3_000, true));
//        product.add(new Dress(2, "dress Dior", "greate", 190_000, true, 4, "blue"));
//        product.add(new Oven(3, "panasonic micriwave oven", "awful", 5_000, false, 4, 600));
        product.removeIf(o -> o.getId() == id);
        return product;
    }


    public List<Product> searchByCategory() {
        List<Product> listByCategory = new ArrayList<>();
        for (Product product1 : repository.getAllProducts()) {
            if (product1 instanceof Oven) {
                listByCategory.add(product1);
                listByCategory.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getName().compareToIgnoreCase(o2.getName());
                    }
                });
            }
        }
        return listByCategory;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}








