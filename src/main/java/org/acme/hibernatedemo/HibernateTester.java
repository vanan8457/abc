package org.acme.hibernatedemo;

import hibernatedemo.pojo.Category;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class HibernateTester {
    public static void main(String[] args) {
        Session session= HibernateUtill.getFACTORY().openSession();
        Query q =session.createQuery("FROM Category WHERE id=1 ");//HQL
        List<Category> cates =q.getResultList();
        cates.forEach(c-> System.out.printf("%d - %s\n", c.getId(), c.getName()));
//        Category c=session.get(Category.class,1);//persistent
//        c.setDescription("DU LIEU CAP NHAP");
//        session.getTransaction().begin();
//        session.delete(c);
//        session.save(c);
//        session.getTransaction().commit();
        //////////////////////////////////////
//        Category c= new Category();//transient
//        c.setName("Phu kien 1");
//        c.setDescription("TEST HIBERNATE");
//        session.save(c);
//        session.close();
    }
}
