package ru.geekbrains.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.reposytoryes.ProductRepository;
import ru.geekbrains.spring.services.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope("prototype")
public class Cart  {
    private ProductRepository productRepository;
    private ProductService productService;
    public List<Product> getShoppingItems;

    public List<Optional<Product>> getShoppingItems(Long idNum) {
        return shoppingItems;
    }

    public List<Optional<Product>> shoppingItems;



    @Autowired
    public Cart (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Long id) {
        Optional<Product> product = productRepository.findOneById(id);
        if (product != null) {
            this.shoppingItems.add(product);
        }
    }


    @PostConstruct
    private void init() {
        this.shoppingItems = new ArrayList<Optional<Product>>();
    }


}
