package ua.org.oa.podkopayv.zmarket4.test;

import ua.org.oa.podkopayv.zmarket4.model.Product;
import ua.org.oa.podkopayv.zmarket4.repository.ProductRepository;
import ua.org.oa.podkopayv.zmarket4.repository.StorageRepositories;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("ZMarket4");

        ProductRepository productRepository = StorageRepositories.getInstance().getProductRepository();

        List<Product> products = productRepository.getAll();

        for (Product p : products) {
            System.out.println(p);
        }

    }

}
