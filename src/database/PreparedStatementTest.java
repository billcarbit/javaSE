package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 预编译
 */
public class PreparedStatementTest {

    public void test(Connection conn) {
        try {
            conn.setAutoCommit(false);//手动提交
            Long beginTime = System.currentTimeMillis();
            PreparedStatement pst = conn.prepareStatement("insert into t_user(t_username) values (?)");
            for (int i = 0; i < 10000; i++) {
                pst.setInt(1, 'A');
                pst.execute();
            }
            conn.commit();
            Long endTime = System.currentTimeMillis();
            System.out.println("Pst用时:" + (endTime - beginTime) );//计算时间
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
