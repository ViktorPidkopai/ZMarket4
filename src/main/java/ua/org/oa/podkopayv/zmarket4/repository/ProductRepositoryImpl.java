package ua.org.oa.podkopayv.zmarket4.repository;


import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.org.oa.podkopayv.zmarket4.model.Product;

import java.util.List;

//@Transactional
@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository {

//    @Autowired
    private final SessionFactory sessionFactory;

    public ProductRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
//    @Transactional(readOnly = true)
    public Product getById() {
        return null;
    }

    @Override
//    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return null;
    }

    @Override
//    @Transactional(readOnly = true)
    public List<Product> getByPriceRange() {
        return null;
    }

    @Override
//    @Transactional(readOnly = true)
    public List<Product> getByCategory() {
        return null;
    }

    @Override
//    @Transactional(readOnly = true)
    public List<Product> getByName() {
        return null;
    }

    @Override
//    @Transactional(readOnly = true)
    public List<String> getCategories() {
        return null;
    }
}
