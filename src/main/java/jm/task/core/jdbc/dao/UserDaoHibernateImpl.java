package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {


    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        Session session = Util.getSessionFactory().getCurrentSession();

        String sql = "CREATE TABLE IF NOT EXISTS users" +
                " (id INT PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                " name VARCHAR(45) NOT NULL," +
                " lastName VARCHAR(45) NOT NULL," +
                " age INT NOT NULL)";
        session.beginTransaction();
        session.createSQLQuery(sql).executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void dropUsersTable() {

        Session session = Util.getSessionFactory().getCurrentSession();

        String sql = "DROP TABLE IF EXISTS users";
        session.beginTransaction();
        session.createSQLQuery(sql).executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        Session session = Util.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(new User(name, lastName, age));
        session.getTransaction().commit();
    }

    @Override
    public void removeUserById(long id) {

        Session session = Util.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.delete(session.get(User.class, id));
        session.getTransaction().commit();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users;
        Session session = Util.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        users = session.createQuery("from User").getResultList();
        session.getTransaction().commit();
        return users;
    }

    @Override
    public void cleanUsersTable() {

        Session session = Util.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.createQuery("delete from User").executeUpdate();
        session.getTransaction().commit();
    }
}
