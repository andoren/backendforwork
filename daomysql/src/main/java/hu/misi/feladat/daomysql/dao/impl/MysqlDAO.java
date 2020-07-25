package hu.misi.feladat.daomysql.dao.impl;

import hu.misi.feladat.core.model.Product;
import hu.misi.feladat.core.model.Role;
import hu.misi.feladat.core.model.User;
import hu.misi.feladat.service.dao.IUserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

public class MysqlDAO implements IUserDao {
    public MysqlDAO(){
        Configuration configuration = new Configuration().configure();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Product.class);
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(ssrb.build());
    }
    protected SessionFactory sessionFactory;

    public Collection<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User");

        return (ArrayList<User>)query.getResultList();
    }

    public Collection<User> getUsersByRole(Role role) {
        return null;
    }

    public boolean modifyUser(User user) {
        return false;
    }

    public User getUserById(int id) {
        return null;
    }

    public User addUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public boolean deleteUserById(int id) {
        return false;
    }
}
