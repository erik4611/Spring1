package ru.geekbrains.spring.context;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart  {
    private ProductRepository productRepository;

    public List<Product> getShoppingItems;

    public List<Product> getShoppingItems(int idNum) {
        return shoppingItems;
    }

    public List<Product> shoppingItems;



    @Autowired
    public Cart (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(int id) {
        Product product = productRepository.getProductById(id);
        if (product != null) {
            this.shoppingItems.add(product);
        }
    }
    public void deleteProduct (int id) {
        this.shoppingItems.remove(productRepository.getProductById(id));
    }

    @PostConstruct
    private void init() {
        this.shoppingItems = new ArrayList<>();
    }



}
