package ua.org.oa.podkopayv.zmarket4.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StorageRepositories {

    private ProductRepository productRepository;

    private StorageRepositories() {
        SessionFactory sessionFactory;

        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        this.productRepository = new ProductRepositoryImpl(sessionFactory) {
        };
    }

    public static StorageRepositories getInstance() {
        return Holder.INSTANCE;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    private static class Holder {
        private static final StorageRepositories INSTANCE = new StorageRepositories();
    }

}
