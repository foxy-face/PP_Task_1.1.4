package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Util {
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
}
