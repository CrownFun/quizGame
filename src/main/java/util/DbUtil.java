package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {

    private static Connection connection;

    public static Connection connectToDataBase() {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:quiz2.db");
            connection.setAutoCommit(false);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return connection;
    }

    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        statement.close();
        connection.close();
        resultSet.close();
    }


}
