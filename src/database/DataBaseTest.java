package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseTest {
    final static String url = "jdbc:mysql://localhost:3306/mydemo?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";    //JDBC的URL

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(url, "root", "");
            new StatementTest().test(conn);
            //new PreparedStatementTest().test(conn);
            //new PreparedStatementBatchTest().test(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
