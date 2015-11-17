package ua.org.oa.podkopayv.zmarket4.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.org.oa.podkopayv.zmarket4.model.Product;
import ua.org.oa.podkopayv.zmarket4.repository.ProductRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        System.out.println("Context created!");
        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
//        MyAutowiredTest mat = context.getBean("myAutowiredTest", MyAutowiredTest.class);
//        System.out.println(mat.getMessage());

//        List<Product> products = productRepository.getAll();

//        System.out.println("ZMarket4");
//        for (Product p : products) {
//            System.out.println(p);
//        }

        List<Product> productByPriceRange = productRepository.getByPriceRange(6000, 10000);
//        System.out.println("Products by price range");
//        for (Product p : productByPriceRange) {
//            System.out.println(p);
//        }

//        for (Product p : products) {
//            Gson gson = new Gson();
//            String json = gson.toJson(p);
//            System.out.println(json);
//        }
//
//        Gson gson = new Gson();
//        String json = gson.toJson(12345);
//        System.out.println(json);

//        System.out.println(productRepository.getCategories());

    }

}
