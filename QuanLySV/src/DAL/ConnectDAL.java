/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import java.sql.*;
import javax.swing.*;

public class ConnectDAL {
    // kết nối với CSDL
    public static Connection getConnect()
    {
        try
        {
            String hostName = "localhost";
            String sqlInstanceName = "SQLEXPRESS";
            String database = "QLSV1C";
            String userName = "sa";
            String password = "123456";
            String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/"+ database + ";instance=" + sqlInstanceName;
            Connection conn = DriverManager.getConnection(connectionURL,userName,password);
            return conn;
           
        }
        catch (Exception e)
        {
           // JOptionPane.showMessageDialog(null, "kết nối thất bại", "Thông Báo", 1);
            
            return null;
        }
    }
    
}
