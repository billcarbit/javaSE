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


            for (int i = 1; i <= 5; i++) {

                pst.setInt(1, i);

                pst.addBatch();//加入批处理，进行打包

                if (i % 5 == 0) {//可以设置不同的大小；如50，100，500，1000等等

                    pst.executeBatch();

                    conn.commit();

                    pst.clearBatch();

                }//end of if

            }//end of for

            pst.executeBatch();

            Long endTime = System.currentTimeMillis();

            System.out.println("pst+batch用时：" + (endTime - beginTime) + "毫秒");

            pst.close();

            conn.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
}
