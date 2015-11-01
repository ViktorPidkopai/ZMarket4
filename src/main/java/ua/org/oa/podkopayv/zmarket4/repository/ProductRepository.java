package ua.org.oa.podkopayv.zmarket4.repository;

import ua.org.oa.podkopayv.zmarket4.model.Product;

import java.util.List;

public interface ProductRepository {

    void create();
    void update();
    void delete();
    Product getById();
    List<Product> getAll();
    List<Product> getByPriceRange();
    List<Product> getByCategory();
    List<Product> getByName();
    List<String> getCategories();

}
