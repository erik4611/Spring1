package ru.geekbrains.spring.one.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.one.model.Categories;
import ru.geekbrains.spring.one.repositories.CategoriesRepository;

import java.util.List;

@Service
public class CategoriesService {
    private CategoriesRepository categoriesRepository;
    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public List<Categories> findAllCategories() {
        return categoriesRepository.findAllCategories();
    }
}
