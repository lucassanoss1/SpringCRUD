package web.servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServisImpl implements UserServis {
    private UserDao dao;

    @Autowired
    public UserServisImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    @Transactional
    public User findUserById(long id) {
        return dao.findUserById(id);
    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        dao.removeUserById(id);
    }
}
