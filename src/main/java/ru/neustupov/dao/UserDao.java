package ru.neustupov.dao;

import ru.neustupov.model.User;

import java.util.List;

public interface UserDao {
    public void add(User user);
    public void edit(User user);
    public void delete(int id);
    public User getUser(int id);
    public List getAllUsers();
}
