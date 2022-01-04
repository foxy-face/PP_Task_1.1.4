package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Kostya", "Ivanov", (byte) 23);
        System.out.println("User с именем – Kostya добавлен в базу данных");
        userService.saveUser("Nastya", "Kotova", (byte) 43);
        System.out.println("User с именем – Nastya добавлен в базу данных");
        userService.saveUser("Ruslan", "Bessonov", (byte) 31);
        System.out.println("User с именем – Ruslan добавлен в базу данных");
        userService.saveUser("Aleksandra", "Sheyanova", (byte) 53);
        System.out.println("User с именем – Aleksandra добавлен в базу данных");

        List<User> usersList = userService.getAllUsers();
        for (User element : usersList) {
            System.out.println(element);
        }

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
