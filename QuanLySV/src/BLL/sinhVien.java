/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.*;
import javax.swing.*;
import DAL.*;

public class sinhVien {
    
    public static Connection conn = ConnectDAL.getConnect(); // biến kết nối thông qua DAL
    public static PreparedStatement pst =null; // biến thực thi sql
    public static ResultSet rs = null; //kết quả trả về dạng 1 bảng hay 1 dòng dữ liệu
    
    // Thêm mới 1 Sinh Viên
    public static void themSV(String MaSV, String HoSV, String TenSV, String NgaySinh, String GioiTinh, String Nhom)
    {
        String sql ="insert into SINHVIEN values (?,?,?,?,?,?)";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.setString(1, MaSV);
            pst.setString(2, HoSV);
            pst.setString(3, TenSV);
            pst.setString(4, NgaySinh);
            pst.setString(5, GioiTinh);
            pst.setString(6, Nhom);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã thêm sinh viên ''"+HoSV+" "+TenSV+"'' thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Mã sinh viên "+MaSV+" đã tồn tại","Thông Báo",1);
        }
     
    }
    // sửa Sinh viên
    public static void suaSV(String MaSV1, String MaSV, String HoSV, String TenSV, String NgaySinh, String GioiTinh, String Nhom)
     {
         
        String sql ="update SINHVIEN set MaSV=N'"+MaSV+"', HoSV=N'"+HoSV+"', TenSV=N'"+TenSV+"', NgaySinh='"+NgaySinh+"', GioiTinh='"+GioiTinh+"', Nhom='"+Nhom+"' where MaSV='"+MaSV1+"'";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã sửa thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Mã sinh viên "+MaSV+" đã tồn tại","Thông Báo",1);
        }

     }
    // Xóa sinh viên
    public static void xoaSV(String MaSV)
    {
        String sql="delete from SINHVIEN where MaSV='"+MaSV+"'";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã xóa sinh viên "+MaSV+" thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Sinh viên "+MaSV+" không thể xóa","Thông Báo",1);
        }
    }
}
