package ru.geekbrains.spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.io.IOException;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        InMemoryProducts inMemoryProducts = context.getBean("inMemoryProducts", InMemoryProducts.class);
        System.out.println("Доступные продукты: " + inMemoryProducts.getProducts());

        Cart cart = context.getBean("cart", Cart.class);


        System.out.println("Введите id продукта для добавления в корзину");
        Scanner in = new Scanner(System.in);
        int idNum1 = in.nextInt();

        cart.addProduct(idNum1);

        System.out.println("Продукты в корзине: " + cart.getShoppingItems(idNum1));

        cart.deleteProduct(idNum1);
        System.out.println("Продукты в корзине: " + cart.getShoppingItems(idNum1));
        context.close();

    }
}
