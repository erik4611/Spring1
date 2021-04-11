package ru.geekbrains.spring.context;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InMemoryProducts implements ProductRepository {
    private List<Product> products;

    @Override
    public List<Product> getProducts() {
        return products;
    }


    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1, "Brick", 100),
                new Product(2, "Steel", 150),
                new Product(3, "Concrete", 200),
                new Product(4, "Plastic", 400),
                new Product(5, "Glue", 250)
        ));
    }
//    @Override
//    public List getProductById(List<Product> productList, int i) {
//        List b = productList.stream()
//                .filter(e ->e.toString().contains("i"))
//                .collect(Collectors.toList());
//        return b;
//    }

    public Product getProductById (int id) {
        return products.stream().filter((p) ->
                p.getId() == id).findFirst().orElse(null);
    }



}