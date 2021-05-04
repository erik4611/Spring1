package ru.geekbrains.april.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.april.market.model.Product;
import ru.geekbrains.april.market.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

//    public Optional<Product> updateProductById(Product product,Long id, String title, int price) {
//        return productRepository.findById(id).get(title).
//    }

    public List<Product> delete(Product product) {
        productRepository.deleteById(product.getId());
        return (List<Product>) productRepository;
    }
}
