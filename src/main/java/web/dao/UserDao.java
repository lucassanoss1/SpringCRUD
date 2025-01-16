package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);
    public List<User> getAllUsers();
    public User findUserById(long id);
    public void removeUserById(long id);
}
