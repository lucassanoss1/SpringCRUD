package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager en;

    @Override
    public void addUser(User user) {
        en.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = en.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public User findUserById(long id) {
        return en.find(User.class, id);

    }

    @Override
    public void removeUserById(long id) {
        en.remove(en.find(User.class, id));
    }

    @Override
    public void updateUser(User user) {
        en.merge(user);
    }
}
