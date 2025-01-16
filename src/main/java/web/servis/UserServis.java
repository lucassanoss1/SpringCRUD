package web.servis;

import web.model.User;

import java.util.List;

public interface UserServis {
    public void addUser(User user);
    public List<User> getAllUsers();
    public User findUserById(long id);
    public void removeUserById(long id);
}
