package com.var.agregator.dao;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ivan on 30.10.15.
 */
public class SimpleDAO {

//    @Resource(name="myDataSource")
    private static DataSource dataSource;

    static {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/agregator");
        }
        catch (Exception ex) {
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
