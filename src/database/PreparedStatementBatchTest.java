package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 预编译+批处理
 */
public class PreparedStatementBatchTest {

    public void test(Connection conn) {
        try {
            conn.setAutoCommit(false);
            Long beginTime = System.currentTimeMillis();
            PreparedStatement pst = conn.prepareStatement("insert into t_user(t_username) values (?)");
            for (int i = 1; i <= 10000; i++) {
                pst.setInt(1, 'A');
                pst.addBatch();//加入批处理，进行打包
                if (i % 5000 == 0) {//可以设置不同的大小；如50，100，500，1000等等
                    pst.executeBatch();
                    conn.commit();
                    pst.clearBatch();
                }
            }
            pst.executeBatch();
            Long endTime = System.currentTimeMillis();
            System.out.println("pst+batch用时：" + (endTime - beginTime));
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
