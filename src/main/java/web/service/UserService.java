package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public List<User> getAllUsers();
    public User findUserById(long id);
    public void removeUserById(long id);
    public void updateUser(User user);
}
