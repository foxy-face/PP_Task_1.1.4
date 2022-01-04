package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static SessionFactory factory;

    public static Connection getConnect() {
        final String URL = "jdbc:mysql://localhost:3306/tableofusers";
        final String USERNAME = "root";
        final String PASSWORD = "root";

        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static SessionFactory getSessionFactory() {
        final String URL = "jdbc:mysql://localhost:3306/tableofusers";
        final String USERNAME = "root";
        final String PASSWORD = "root";

        if (factory == null) {
            try {
                Properties properties = new Properties();
                properties.setProperty("hibernate.connection.url", URL);
                properties.setProperty("hibernate.connection.username", USERNAME);
                properties.setProperty("hibernate.connection.password", PASSWORD);
                properties.setProperty("hibernate.current_session_context_class", "thread");
                properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
                properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
                properties.setProperty("show_sql", "true");
                properties.setProperty("hbm2ddl.auto", "update");

                factory = new Configuration().addProperties(properties)
                        .addAnnotatedClass(User.class).buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return factory;
    }
}
