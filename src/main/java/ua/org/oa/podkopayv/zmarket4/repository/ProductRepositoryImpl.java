package ua.org.oa.podkopayv.zmarket4.repository;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.org.oa.podkopayv.zmarket4.model.Product;

import java.util.List;

//@Transactional
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public ProductRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ProductRepositoryImpl() {
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
    }

    @Override
    public void update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
    }

    @Override
//    @Transactional(readOnly = true)
    public Product getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "FROM Product P WHERE P.id = :productId";
        Query query = session.createQuery(hql);
        query.setParameter("productId", id);
        Product product = (Product) query.list().get(0);
        session.getTransaction().commit();
        return product;
    }

    @Override
//    @Transactional(readOnly = true)
    public List<Product> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        final String hql = "FROM Product";
        Query query = session.createQuery(hql);
        List<Product> result = query.list();
        session.getTransaction().commit();
        return result;
    }

    @Override
//    @Transactional(readOnly = true)
    public List<Product> getByPriceRange(int minPrice, int maxPrice) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        final String hql = "FROM Product P WHERE P.price >= :minPrice AND P.price <= :maxPrice";
        Query query = session.createQuery(hql).setInteger("minPrice", minPrice).setInteger("maxPrice", maxPrice);
        List<Product> result = query.list();
        System.out.println("Product with price from " + minPrice + " to " + maxPrice);
        for (Product p : result) {
            System.out.println(p);
        }
        session.getTransaction().commit();
        return result;
    }

    @Override
//    @Transactional(readOnly = true)
    public List<Product> getByCategory(String category) {
        return null;
    }

    @Override
//    @Transactional(readOnly = true)
    public List<Product> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        final String hql = "FROM Product P WHERE P.name LIKE :name";
        Query query = session.createQuery(hql).setString("name", name);
        List<Product> result = query.list();
        session.getTransaction().commit();
        return result;
    }

    @Override
//    @Transactional(readOnly = true)
    public List<String> getCategories() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        final String hql = "FROM Category.name ";
        Query query = session.createQuery(hql);
        List<String> result = query.list();
        return result;
    }
}
