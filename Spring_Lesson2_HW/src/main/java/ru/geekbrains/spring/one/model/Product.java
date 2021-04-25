package ru.geekbrains.spring.one.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

//    @Column(name = "categories_id")
//    private int categories_id;


    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Categories categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Product() {
    }

    public Product(String title, Categories categories) {
        this.title = title;
        this.categories = categories;
    }

    @Override
    public String toString() {
        return String.format("Product [id = %d, title = %s]", id, title);
    }
}


