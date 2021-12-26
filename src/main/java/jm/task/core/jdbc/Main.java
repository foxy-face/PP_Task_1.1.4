package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();

        userDaoJDBC.saveUser("Kostya", "Ivanov", (byte) 23);
        System.out.println("User с именем – Kostya добавлен в базу данных");
        userDaoJDBC.saveUser("Nastya", "Kotova", (byte) 43);
        System.out.println("User с именем – Nastya добавлен в базу данных");
        userDaoJDBC.saveUser("Ruslan", "Bessonov", (byte) 31);
        System.out.println("User с именем – Ruslan добавлен в базу данных");
        userDaoJDBC.saveUser("Aleksandra", "Sheyanova", (byte) 53);
        System.out.println("User с именем – Aleksandra добавлен в базу данных");

        List<User> usersList = userDaoJDBC.getAllUsers();
        for (User element : usersList) {
            System.out.println(element);
        }
        userDaoJDBC.cleanUsersTable();

        userDaoJDBC.dropUsersTable();
    }
}
