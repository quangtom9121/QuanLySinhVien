/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.*;
import javax.swing.*;
import DAL.*;

public class thongTin {
    public static Connection conn = ConnectDAL.getConnect(); // biến kết nối thông qua DAL
    public static PreparedStatement pst =null; // biến thực thi sql
    public static ResultSet rs = null; //kết quả trả về dạng 1 bảng hay 1 dòng dữ liệu
    
    // Thêm mới
    public static void themThongTinSV(String MaSV, String DiaChi, String SDT, String Email, String Facebook, String DoanVien, String SoCMND, String DanToc)
    {
        String sql ="insert into THONGTINSV values (?,?,?,?,?,?,?,?)";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.setString(1, MaSV);
            pst.setString(2, DiaChi);
            pst.setString(3, SDT);
            pst.setString(4, Email);
            pst.setString(5, Facebook);
            pst.setString(6, DoanVien);
            pst.setString(7, SoCMND);
            pst.setString(8, DanToc);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã thêm thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Mã sinh viên "+MaSV+" đã tồn tại","Thông Báo",1);
        }
    }
    // Sửa thông tin sv    
    public static void suaThongTinSV( String MaSV1,String MaSV, String DiaChi, String SDT, String Email, String Facebook, String DoanVien, String SoCMND, String DanToc)
    {
         
        String sql ="update THONGTINSV set MaSV=N'"+MaSV+"', DiaChi=N'"+DiaChi+"', SoDT=N'"+SDT+"', Email='"+Email+"', Facebook='"+Facebook+"', DoanVien='"+DoanVien+"', SoCMND='"+SoCMND+"', DanToc='"+DanToc+"' where MaSV='"+MaSV1+"'";
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
    
    // Xóa thông tin sv
    public static void xoaThongTinSV(String MaSV)
    {
        String sql="delete from THONGTINSV where MaSV='"+MaSV+"'";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã xóa thông sinh viên có mã "+MaSV+" thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"thông tin của sinh viên có mã "+MaSV+" không thể xóa","Thông Báo",1);
        }
    }
    
}
