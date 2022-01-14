package org.acme.hibernatedemo;

import hibernatedemo.pojo.Category;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class HibernateUtill {
    private final static SessionFactory FACTORY;
    static {
        Configuration conf = new Configuration();
        Properties pros = new Properties();
        pros.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
        pros.put(Environment.DRIVER,"org.postgresql.Driver");
        pros.put(Environment.URL,"jdbc:postgresql://localhost:5432/Saledb");
        pros.put(Environment.USER,"postgres");
        pros.put(Environment.PASS,"12345678");
        pros.put(Environment.SHOW_SQL, "true");

        conf.setProperties(pros);
        conf.addAnnotatedClass(Category.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY(){
        return FACTORY;
    }
}
