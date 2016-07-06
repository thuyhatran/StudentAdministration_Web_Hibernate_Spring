/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class JDBC_StudentConnect {
    
    private static Connection connection = null;
   
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String user = "student";
            String pass = "student";
            connection = DriverManager.getConnection(url, user, pass);
            return connection;
    }
    
    public static void closeConnection() throws SQLException{
        if (connection !=null)
            connection.close();
    }
  
}

