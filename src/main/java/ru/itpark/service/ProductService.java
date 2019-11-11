package ru.itpark.service;

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
        return getSortedBy((o1, o2) -> o1.getPrice() - (o2.getPrice()));
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
                product.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
            }
        }
        return product;
    }

    public List<Product> searchByPrice(int min, int max) {
        List<Product> resultByPrice = new ArrayList<>();
        for (Product house : repository.getAllProducts()) {
            if (min < house.getPrice() && max >= house.getPrice()) {
                resultByPrice.add(house);
                resultByPrice.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
            }
        }
        return resultByPrice;
    }

    public List<Product> removeById(int id) {
        ArrayList<Product> product = new ArrayList<>(repository.getAllProducts());
        product.removeIf(o -> o.getId() == id);
        return product;
    }


    public List<Product> searchByCategory() {
        List<Product> listByCategory = new ArrayList<>();
        for (Product product1 : repository.getAllProducts()) {
            if (product1 instanceof Oven) {
                listByCategory.add(product1);
                listByCategory.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
            }
        }
        return listByCategory;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}








