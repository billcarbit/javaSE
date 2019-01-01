package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 用硬编码
 */
public class StatementTest {

    public void test(Connection conn){
        try {
            conn.setAutoCommit(false);
            Long beginTime = System.currentTimeMillis();
            //创建一个Statement对象
            Statement stmt = conn.createStatement(); //创建Statement对象
            for (int i = 0; i < 10000; i++) {
                String sql = "insert into t_user(t_username) values ("  + "'A')";
                stmt.executeUpdate(sql);
            }
            conn.commit();
            Long endTime = System.currentTimeMillis();
            System.out.println("Statement用时：" + (endTime - beginTime));//计算时间
            stmt.close();
            conn.close();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

}
