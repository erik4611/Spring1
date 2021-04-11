package ru.geekbrains.spring.context;

import java.util.List;

public interface ProductRepository {
    List<Product> getProducts();
    Product getProductById(int id);




//    List<Product> getProductById();
//
//    List getProductById(List<Product> productList, int i);
//
////    public void getProductById(List<Product> productList) {
////
////    }
}
