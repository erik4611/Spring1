package ru.geekbrains.april.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.april.market.model.Product;
import ru.geekbrains.april.market.services.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getOneProductById(@PathVariable Long id) {
        return productService.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createNewProduct(@RequestBody Product product) {
        return productService.save(product);
    }

//    @PutMapping("update/{id}")

    @DeleteMapping("delete/{id}")
    public List<Product> deleteOneProduct(@PathVariable Product product) {
        productService.delete(product);
        return productService.findAll();
    }


}
