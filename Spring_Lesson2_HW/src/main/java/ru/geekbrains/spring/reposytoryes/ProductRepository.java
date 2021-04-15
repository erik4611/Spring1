package ru.geekbrains.spring.reposytoryes;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.geekbrains.spring.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Book", 100),
                new Product(2L, "Pencil", 50),
                new Product(3L, "Paper", 150),
                new Product(4L, "Scotch", 250),
                new Product(5L, "Table", 150)
        ));
    }

    public List<Product> findAll() {
        return products;
    }

    public void save(Product student) {
        products.add(student);
    }

    public Optional<Product> findOneById(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }


}
