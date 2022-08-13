/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202.config;

import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;

/**
 * datasource connection mysql xchen202 1:07 AM 2/5/2022
 */
@ApplicationScoped
@DataSourceDefinition(
        name = "java:app/jdbc/itmd4515DS",
        //Works for mysql-connector-java8.0.27
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        //Works for mysql-connector-java5.1.49
        //        className = "com.mysql.jdbc.jdbc2.optional.MysqlDataSource",
        //Works for mysql-connector-java6.0.6 -- bad
        //        className = "com.mysql.cj.jdbc.MysqlDataSource",     
        serverName = "localhost",
        portNumber = 3306,
        databaseName = "itmd4515",
        user = "itmd4515",
        password = "itmd4515",
        properties = {
            "useSSL=false",
            //Works for mysql-connector-java6.0.6 -- bad
            "serverTimezone=UTC",}
)
public class DbConfig {

}
