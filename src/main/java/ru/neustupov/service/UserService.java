package ru.neustupov.service;

import ru.neustupov.model.User;

import java.util.List;

public interface UserService {
    public void add(User user);
    public void edit(User user);
    public void delete(int id);
    public User getUser(int id);
    public List getAllUsers();
    public int getAllUserNumber();
    public List showOnePage(int page,int recordsPerPage);
    public User getUserByName(String name);
}
