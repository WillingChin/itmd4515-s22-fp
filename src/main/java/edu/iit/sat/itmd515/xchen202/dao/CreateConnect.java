/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * ClassName: DBConnect Description: mysql database connect util author:
 * XINN_CHEN since: Dec 5, 2021 1:58:01 PM
 */
public final class CreateConnect {

    /**
     * Try use another way to get DataSource.
     *
     * @return
     */
    public static Connection getConnection() {
        Connection con = null;
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:app/jdbc/itmd4515DS");
            con = ds.getConnection();
            return con;
        } catch (NamingException | SQLException e) {
            System.out.println("Error creating connection to database: " + e);
        }
        return con;
    }//end getConnection

    /**
     * close by Statement
     *
     * @param st
     */
    public static void close(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
//            if(connection != null) {
//                    connection.close();
//            }
        } catch (SQLException e) {
            System.out.println("Error close to database: " + e);
        }
    }//end close

}
