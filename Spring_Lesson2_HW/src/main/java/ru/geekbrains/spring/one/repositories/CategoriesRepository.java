package ru.geekbrains.spring.one.repositories;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.one.model.Categories;
import ru.geekbrains.spring.one.utils.HibernateUtils;

import java.util.List;

@Component
public class CategoriesRepository {

    private HibernateUtils hibernateUtils;

    @Autowired
    public CategoriesRepository(HibernateUtils hibernateUtils) {
        this.hibernateUtils = hibernateUtils;
    }

    public List<Categories> findAllCategories() {
        try (Session session = hibernateUtils.getCurrentSession()) {
            session.beginTransaction();
            List<Categories> categories = session.createQuery("from Categories").getResultList();
            session.getTransaction().commit();
            return categories;
        }
    }
}
