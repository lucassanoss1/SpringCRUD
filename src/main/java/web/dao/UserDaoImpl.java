package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager en;

    @Override
    @Transactional
    public void addUser(User user) {
        en.persist(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        TypedQuery<User> query = en.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public User findUserById(long id) {
        return en.find(User.class, id);

    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        en.remove(en.find(User.class, id));
    }
}
