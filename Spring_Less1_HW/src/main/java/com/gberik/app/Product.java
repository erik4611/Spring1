package com.gberik.app;

public class Product {
    int id;
    String title;
    int cost;

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public Product(int id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
