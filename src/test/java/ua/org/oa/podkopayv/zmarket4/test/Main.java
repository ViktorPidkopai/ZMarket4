package ua.org.oa.podkopayv.zmarket4.test;

import com.google.gson.Gson;
import ua.org.oa.podkopayv.zmarket4.model.Product;
import ua.org.oa.podkopayv.zmarket4.repository.ProductRepository;
import ua.org.oa.podkopayv.zmarket4.repository.StorageRepositories;

import java.util.List;

public class Main {

    public static void main(String[] args) {



        ProductRepository productRepository = StorageRepositories.getInstance().getProductRepository();

        List<Product> products = productRepository.getAll();

        System.out.println("ZMarket4");
        for (Product p : products) {
            System.out.println(p);
        }

        for (Product p : products) {
            Gson gson = new Gson();
            String json = gson.toJson(p);
            System.out.println(json);
        }

        Gson gson = new Gson();
        String json = gson.toJson(12345);
        System.out.println(json);

//        System.out.println(productRepository.getCategories());

    }

}
