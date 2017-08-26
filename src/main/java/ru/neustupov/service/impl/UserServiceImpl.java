package ru.neustupov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neustupov.dao.UserDao;
import ru.neustupov.model.User;
import ru.neustupov.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
    userDao.add(user);
    }

    @Transactional
    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public List getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public int getAllUserNumber() {
        return userDao.getAllUserNumber();
    }

    @Transactional
    @Override
    public List showOnePage(int page, int recordsPerPage) {
        return userDao.showOnePage(page, recordsPerPage);
    }

    @Transactional
    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }
}
