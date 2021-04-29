package ru.geekbrains.spring.one.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.one.model.Product;
import ru.geekbrains.spring.one.services.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

//    @GetMapping("/")
//    public Object showAllProductsPage(Model model, @RequestParam(name = "p", defaultValue = "1") int pageIndex,
//                                      @RequestParam(name = "high", required = false) int minPrice,
//                                      @RequestParam(name = "low", required = false) int maxPrice) {
//        if (pageIndex < 1) {
//            pageIndex = 1;
//        }
//        if (minPrice != 0) {
//            return productService.searchHighPrice(minPrice);
//        }
//        if (maxPrice != 0) {
//            return productService.searchLowPrice(maxPrice);
//        }
//        Page<Product> page = productService.findAll(pageIndex - 1, 4);
//        model.addAttribute("page", page);
//        return "index";
//    }

//    @GetMapping ("products/search_by_price")


    @GetMapping("/")
    public String showAllProductsPage(Model model, @RequestParam(name = "p", defaultValue = "1") int pageIndex) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        Page<Product> page = productService.findAll(pageIndex -1,4);
        model.addAttribute("page", page);
        return "index";
    }

    @GetMapping("/products/sort")
    public String showProductsWherePriceBetween (Model model,
                                                 @RequestParam(name = "priceMin") int min,
                                                 @RequestParam(name = "priceMax") int max,
                                                 @RequestParam(name = "p", defaultValue = "1") int pageId) {
        Page<Product> page = productService.findAllByPriceBetween(min,max,pageId-1,4);
        model.addAttribute("page", page);
        return "index";
    }


    @GetMapping("/products/{id}")
    public String showProductInfo(@PathVariable(name = "id") Long id, Model model) {
        productService.findOneById(id).ifPresent(p -> model.addAttribute("product", p));
        return "product_info";
    }

    @GetMapping("/products/add")
    public String showCreateProductForm() {
        return "create_product_form";
    }

    @GetMapping("/products/{id}/price/inc")
    public String incrementProductPrice(@PathVariable Long id) {
        productService.incrementPriceById(id, 10);
        return "redirect:/";
    }

    @PostMapping("/products/add")
    public String createNewProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }
}
