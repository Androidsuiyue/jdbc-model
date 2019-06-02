package cn.test;


import cn.dao.UserDAO;
import cn.dao.impl.UserDAOImpl;
import cn.db.JDBCUtils;
import cn.model.User;
import cn.util.ConnectionContext;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author suiyue
 * @description TODO
 * @date 2019/6/2 12:00
 */
public class UserDaoTest {


    @Test
    public void testGet() {
        Connection connection = JDBCUtils.getConnection();
        ConnectionContext.getInstance().bind(connection);
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUser(1);

        System.out.println(user.toString());
    }
}
