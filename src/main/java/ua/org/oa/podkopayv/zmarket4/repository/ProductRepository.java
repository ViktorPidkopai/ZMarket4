package ua.org.oa.podkopayv.zmarket4.repository;

import ua.org.oa.podkopayv.zmarket4.model.Product;

import java.util.List;

public interface ProductRepository {

    void create(Product product);
    void update(Product product);
    void delete(Product product);
    Product getById(long id);
    List<Product> getAll();
    List<Product> getByPriceRange(int minPrice, int maxPrice);
    List<Product> getByCategory(String category);
    List<Product> getByName(String name);
    List<String> getCategories();

}
