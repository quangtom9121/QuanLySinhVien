/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.*;
import javax.swing.*;
import DAL.*;

public class Diem {
    public static Connection conn = ConnectDAL.getConnect(); // biến kết nối thông qua DAL
    public static PreparedStatement pst =null; // biến thực thi sql
    public static ResultSet rs = null; //kết quả trả về dạng 1 bảng hay 1 dòng dữ liệu
    
    // Thêm mới
    public static void themDiemSV(String MaSV, String MaMH, String DiemCC, String DiemTX, String DiemGK, String DiemThi)
    {
        String sql ="insert into DIEM values (?,?,?,?,?,?)";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.setString(1, MaSV);
            pst.setString(2, MaMH);
            pst.setString(3, DiemCC);
            pst.setString(4, DiemTX);
            pst.setString(5, DiemGK);
            pst.setString(6, DiemThi);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã thêm thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Mã sinh viên ''"+MaSV+"'' hoặc mã môn học ''"+MaMH+"'' đã tồn tại","Thông Báo",1);
        }
    }
    // Sửa điểm sv    
    public static void suaDiemSV( String MaSV1,String MaMH1, String MaSV, String MaMH, String DiemCC, String DiemTX, String DiemGK, String DiemThi)
    {
         
        String sql ="update DIEM set MaSV=N'"+MaSV+"', MaMH=N'"+MaMH+"', DiemCC=N'"+DiemCC+"', DiemTX='"+DiemTX+"', DiemGK='"+DiemGK+"', DiemThi='"+DiemThi+"' where MaSV='"+MaSV1+"' and MaMH='"+MaMH1+"'";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã sửa thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Mã sinh viên ''"+MaSV+"'' hoặc mã môn học ''"+MaMH+"'' đã tồn tại","Thông Báo",1);
        }

    }
    
    // Xóa điểm sv
    public static void xoaDiemSV(String MaSV, String MaMH)
    {
        String sql="delete from DIEM where MaSV='"+MaSV+"' and MaMH='"+MaMH+"'";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Đã xóa thành công","Thông Báo",1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null," không thể xóa","Thông Báo",1);
        }
    }
    
}
