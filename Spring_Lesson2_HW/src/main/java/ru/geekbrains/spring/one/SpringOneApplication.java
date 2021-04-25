package ru.geekbrains.spring.one;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.geekbrains.spring.one.model.Categories;

@SpringBootApplication
public class SpringOneApplication {
	// Домашнее задание
	// 1. Добавьте сущность Category (id, title). К каждой категории относится
	// какое-то количество товаров (Товар может относиться только к одной категории)
	// 2. В таблице с товарами отпечататейте название категории
	// 3. * Попробуйте сделать фильтр продуктов по категории
	// .../app/?category=food
	// Должен показать товары категории food

	public static void main(String[] args) {
		SpringApplication.run(SpringOneApplication.class, args);
		PrepareData.productPrepareData();

		SessionFactory factory = new Configuration()
				.configure("resources/hibernate.cfg.xml")
				.buildSessionFactory();

		Session session = null;
		try {
			session = factory.getCurrentSession();

            session.beginTransaction();
			Categories category = session.get(Categories.class, 1L);
            System.out.println(category.getProducts());
            session.getTransaction().commit();



		} finally {
			factory.close();
			if (session != null) {
				session.close();
			}
		}
	}
}

