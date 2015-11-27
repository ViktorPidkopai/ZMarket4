package ua.org.oa.podkopayv.zmarket4.test;

import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.org.oa.podkopayv.zmarket4.gson.ProductToJson;
import ua.org.oa.podkopayv.zmarket4.model.Category;
import ua.org.oa.podkopayv.zmarket4.model.Product;
import ua.org.oa.podkopayv.zmarket4.repository.ProductRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);

        Product newProduct = new Product();
        Category category = new Category();
        category.setId(1);
        category.setTitle("Pets");
        newProduct.setName("Rabbit");
        newProduct.setCategory(category);
        newProduct.setPrice(143298);
        System.out.println(newProduct);
        productRepository.create(newProduct);

        int minPrice = 6000;
        int maxPrice = 10000;

//        System.out.println("Product with price from " + minPrice + " to " + maxPrice);
//        long startTime = System.currentTimeMillis();
//        List<Product> productByPriceRange = productRepository.getByPriceRange(minPrice, maxPrice);
//        long endTime = System.currentTimeMillis();
//        System.out.println("time = " + (endTime - startTime) + " ms");
//        for (Product p : productByPriceRange) {
//            System.out.println(p);
//        }

        Gson gson = new Gson();
        List<Product> products = productRepository.getAll();
        System.out.println("all:");
        for (Product p : products) {
            String json = ProductToJson.convert(p);
            System.out.println(json);
        }


//        List<String> categories = productRepository.getCategories();
//        System.out.println("categories:");
//        for (String c : categories) {
//            System.out.println(c);
//        }
//
//        List<Product> products1 = productRepository.getByCategory(category);
//        System.out.println("product by category: " + category.getTitle());
//        for (Product p : products1) {
//            System.out.println(p);
//        }


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
