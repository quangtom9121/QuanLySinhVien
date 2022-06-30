/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*; //thư viện rs2xml
import DAL.*;

public class loadTable {
    public static PreparedStatement pst =null; // biến thực thi sql
    public static ResultSet rs = null; //kết quả trả về dạng 1 bảng hay 1 dòng dữ liệu
    public static Connection conn = ConnectDAL.getConnect(); // Lấy từ DAL
    
    // Hàm nạp dự liệu cho bảng
    public static void loadData (String sql, JTable tb)
    {
        try
        {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tb.setModel((DbUtils.resultSetToTableModel(rs)));
            // nạp dữ liệu
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e,"Lỗi",1);
        }
    }
    // Hàm đổ dữ liệu từ Jtable lên textField
    public static ResultSet showTextField (String sql)
    {
        try
        {
            pst = conn.prepareStatement(sql);
            return pst.executeQuery();
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
