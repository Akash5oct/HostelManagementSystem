/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Akki
 */
public class connect {
private static final String JDBC_DRIVER="oracle.jdbc.OracleDriver";
     private static final String DB_URL="jdbc:oracle:thin:@localhost:1521:XE";
     
     private static final String USER="system";
     private static final String PASS="123";
     
     public Connection conn=null;
     public void c_open() throws SQLException{
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to Database.....");
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Creating Table in given Database...");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     public void c_close() throws SQLException{
     conn.close();
     }

    private void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    
}

