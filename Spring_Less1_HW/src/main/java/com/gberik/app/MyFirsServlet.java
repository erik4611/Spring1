package com.gberik.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFirsServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(MyFirsServlet.class);

    Product product0 = new Product(0, "brick", 4);
    Product product1 = new Product(1, "paper", 5);
    Product product2 = new Product(2, "disk", 6);
    Product product3 = new Product(3, "ball", 3);
    Product product4 = new Product(4, "hammer", 1);
    Product product5 = new Product(5, "crane", 5);
    Product product6 = new Product(6, "container", 2);
    Product product7 = new Product(7, "socket", 6);
    Product product8 = new Product(8, "splitter", 7);
    Product product9 = new Product(9, "wheel", 1);




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().printf("<!DOCTYPE html" + "<html>" + "<head>" + "<meta charset=utf-8>" + "</head>");
        resp.getWriter().printf("<body>");
        Product[] arr = {product0, product1, product2, product3, product4, product5, product6, product7, product8, product9};

        for (int i = 0; i < 9; i++) {
            resp.getWriter().printf("<h1>" + " " + arr[i].getId()+ " " + arr[i].getTitle()+ " " + arr[i].getCost() + "</h1>");
            resp.setContentType("text/html");
        }


//        for (int i = 0; i < 10; i++) {
//            resp.getWriter().printf("<h1>" + i + "</h1>");
//        }


    }
}
