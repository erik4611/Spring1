package ru.geekbrains.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.geekbrains.hibernate.Product;

import java.util.List;

public class ProductDao {
    private SessionFactory factory;

    public ProductDao(SessionFactory factory) {
        this.factory = factory;
    }

    public Product findById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    public List<Product> findAll() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = (List<Product>)session.createQuery("from Product", List.class);
            session.getTransaction().commit();
            return products;
        }
    }

    public Product saveOrUpdate(Product product) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return product;
        }
    }

    public void delete(Product product) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        }
    }
}
