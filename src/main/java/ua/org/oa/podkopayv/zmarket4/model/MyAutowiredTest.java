package ua.org.oa.podkopayv.zmarket4.model;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MyAutowiredTest {

    @Autowired
    private SessionFactory sessionFactory;

    private String message;

    public MyAutowiredTest() {
        System.out.println("I'm initialized!");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}