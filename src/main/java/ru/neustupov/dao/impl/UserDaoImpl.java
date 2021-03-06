package ru.neustupov.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.neustupov.dao.UserDao;
import ru.neustupov.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void edit(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(getUser(id));
    }

    @Override
    public User getUser(int id) {
        return (User)sessionFactory.getCurrentSession().get(User.class,id);
    }

    @Override
    public List getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("FROM User").list();
    }
}
