package ru.geekbrains.spring.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.Product;
import ru.geekbrains.spring.reposytoryes.ProductRepository;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository studentRepository) {
        this.productRepository = studentRepository;
    }

    public Optional<Product> findOneById(Long id) {
        return productRepository.findOneById(id);
    }
    public void save(Product product) {
        productRepository.save(product);
    }


    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
