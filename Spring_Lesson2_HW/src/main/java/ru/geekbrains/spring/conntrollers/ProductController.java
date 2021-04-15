package ru.geekbrains.spring.conntrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.Cart;
import ru.geekbrains.spring.Product;
import ru.geekbrains.spring.reposytoryes.ProductRepository;
import ru.geekbrains.spring.services.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private ProductRepository productRepository;
    private List<Product> cart = (List<Product>) new Cart(productRepository);

    @Autowired
    public ProductController(ProductService studentService) {
        this.productService = studentService;
    }

    // [http://localhost:8189/app]/products/all
    @GetMapping("/all")
    public String showAllProductsPage(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

//    // [http://localhost:8189/app]/products/allincart
//    @GetMapping("/allincart")
//    public String showAllProductsInCartPage(Model model) {
//        List<Product> products = cart.add
//
//        model.addAttribute("products", products);
//        return "products";
//    }

    @GetMapping("/{id}")
    public String showProductInfo(@PathVariable(name = "id") Long id, Model model) {
        Optional<Product> product = productService.findOneById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
        }
        return "product_info";
    }



}

