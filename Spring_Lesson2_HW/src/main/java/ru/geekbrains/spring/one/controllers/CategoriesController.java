package ru.geekbrains.spring.one.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.one.model.Categories;

import ru.geekbrains.spring.one.services.CategoriesService;
import ru.geekbrains.spring.one.services.ProductService;

import java.util.List;


@Controller
public class CategoriesController {

//    private CategoriesService categoriesService;
//
//    @Autowired
//    public CategoriesController(ProductService productService) {
//        this.categoriesService = categoriesService;
//    }
//
//    @GetMapping("/categories")
//    public String showAllCategoriesPage(Model model) {
//        List<Categories> categories = categoriesService.findAllCategories();
//        model.addAttribute("categories", categories);
//        return "index";
//    }
}