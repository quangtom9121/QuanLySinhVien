/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.*;
import javax.swing.*;
import DAL.*;

public class monHoc {
    public static Connection conn = ConnectDAL.getConnect(); // biến kết nối thông qua DAL
    public static PreparedStatement pst =null; // biến thực thi sql
    public static ResultSet rs = null; //kết quả trả về dạng 1 bảng hay 1 dòng dữ liệu
    
    // Thêm mới 1 môn học
    public static void themMH(String MaMH, String TenMH, String SoTiet)
    {
        String sql ="insert into MONHOC values (?,?,?)";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.setString(1, MaMH);
            pst.setString(2, TenMH);
            pst.setString(3, SoTiet);
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã thêm môn học "+TenMH+" thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Mã môn học "+MaMH+" đã tồn tại","Thông Báo",1);
        }
     
    }
    public static void suaMH(String MaMH1, String MaMH, String TenMH, String SoTiet)
    {
        String sql ="update MONHOC set MaMH=N'"+MaMH+"', TenMH=N'"+TenMH+"', SoTiet='"+SoTiet+"' where MaMH='"+MaMH1+"'";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã sửa môn học thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Mã môn học "+MaMH+" đã tồn tại","Thông Báo",1);
        }
     
    }
    public static void xoaMH(String MaMH)
    {
        String sql="delete from MONHOC where MaMH='"+MaMH+"'";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã xóa môn học "+MaMH+" thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Môn học "+MaMH+" không thể xóa","Thông Báo",1);
        }
    }
}
