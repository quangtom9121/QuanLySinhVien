/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.*;
import javax.swing.*;
import BLL.*;
import DAL.*;

public class jfmDiem extends javax.swing.JFrame {

    public static String sql ="Select MaSV, MaMH, DiemCC, DiemTX, DiemGK, DiemThi, ( DiemCC + DiemTX + DiemGK*3 + DiemThi*5 )/10 as DiemTongKet From DIEM";
    public static Connection conn = ConnectDAL.getConnect();
    public static String diem;
    public static String diem1;
    
    public jfmDiem() {
        initComponents();
        loadTable.loadData(sql, jtbDiem);
        loadcbMaSV();
        loadcbMaMH();
        loadDiem();
    }
    
    // hàm load lại sau khi cập nhật dữ liệu
    public void loadDiem()
    {
        loadTable.loadData(sql, jtbDiem);
        this.lblTongDiem.setText("Tổng số: "+this.jtbDiem.getRowCount());
    }
    // load mã sv từ bảng sv vào cbMaSV
    public void loadcbMaSV()
    {
        String sql="select * from SINHVIEN";
        try
        {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                this.cbMaSV.addItem(rs.getString("MaSV"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e,"Thông Báo Lỗi",1);
        }
    }
    // load mã môn học từ bảng môn học vào cbMaMH
    public void loadcbMaMH()
    {
        String sql="select * from MONHOC";
        try
        {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                this.cbMaMH.addItem(rs.getString("MaMH"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e,"Thông Báo Lỗi",1);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbMaSV = new javax.swing.JComboBox<>();
        cbMaMH = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDiemCC = new javax.swing.JTextField();
        txtDiemTX = new javax.swing.JTextField();
        txtDiemThi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDiemGK = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbDiem = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        lblTongDiem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Điểm Sinh Viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Mã Sinh viên:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Mã môn học:");

        cbMaSV.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        cbMaMH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Điểm CC:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Điểm TX:");

        txtDiemCC.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtDiemTX.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtDiemThi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Điểm GK:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Điểm Thi:");

        txtDiemGK.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jtbDiem.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jtbDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbDiemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbDiem);

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        lblTongDiem.setText("Tổng số:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTongDiem)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtDiemTX, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtDiemCC, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiemGK, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiemThi, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtDiemCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtDiemTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtDiemGK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtDiemThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnXoa)
                                .addComponent(btnThoat)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblTongDiem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbDiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbDiemMouseClicked
        try
        {
            int row = this.jtbDiem.getSelectedRow(); // lấy dòng tại con trỏ chuột
            String IDrow = (this.jtbDiem.getModel().getValueAt(row, 0)).toString(); // Lấy giá trị tại con trỏ chuột theo kiểu string
            String IDrow1 = (this.jtbDiem.getModel().getValueAt(row, 1)).toString();
            String sql1 = "select * from DIEM where MaSV='"+IDrow+"' and MaMH='"+IDrow1+"'";
            ResultSet rs = loadTable.showTextField(sql1);
            // đọc dữ liệu tại dòng "IDrow"
            if(rs.next()) // nếu có dữ liệu
            {
                diem= rs.getString("MaSV");
                diem1= rs.getString("MaMH");
                this.cbMaSV.setSelectedItem(rs.getString("MaSV"));
                this.cbMaMH.setSelectedItem(rs.getString("MaMH"));
                this.txtDiemCC.setText(rs.getString("DiemCC"));
                this.txtDiemTX.setText(rs.getString("DiemTX"));
                this.txtDiemGK.setText(rs.getString("DiemGK"));
                this.txtDiemThi.setText(rs.getString("DiemThi"));
                
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }                                       

    }//GEN-LAST:event_jtbDiemMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        
            if( this.txtDiemCC.getText().length()==0 || this.txtDiemTX.getText().length()==0 || this.txtDiemGK.getText().length()==0 || this.txtDiemThi.getText().length()==0 )
           JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin","Thông Báo",1);
        else
            Diem.themDiemSV(this.cbMaSV.getSelectedItem().toString(), this.cbMaMH.getSelectedItem().toString(),this.txtDiemCC.getText(), this.txtDiemTX.getText(), this.txtDiemGK.getText(),this.txtDiemThi.getText());
             loadDiem();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if( this.txtDiemCC.getText().length()==0 || this.txtDiemTX.getText().length()==0 || this.txtDiemGK.getText().length()==0 || this.txtDiemThi.getText().length()==0 )
           JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin","Thông Báo",1);
        else
       {
           Diem.suaDiemSV(diem,diem1,this.cbMaSV.getSelectedItem().toString(), this.cbMaMH.getSelectedItem().toString(),this.txtDiemCC.getText(), this.txtDiemTX.getText(), this.txtDiemGK.getText(),this.txtDiemThi.getText());
             loadDiem();
       }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if(JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa điểm sinh viên có mã ''"+diem+"'' không?","Thông Báo",2)==0)
            {
                Diem.xoaDiemSV(diem,diem1);
            }
            loadDiem();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        jfmMain main = new jfmMain();
        this.setVisible(false);
        main.setVisible(true);
    }//GEN-LAST:event_btnThoatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfmDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfmDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfmDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfmDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfmDiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbMaMH;
    private javax.swing.JComboBox<String> cbMaSV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbDiem;
    private javax.swing.JLabel lblTongDiem;
    private javax.swing.JTextField txtDiemCC;
    private javax.swing.JTextField txtDiemGK;
    private javax.swing.JTextField txtDiemTX;
    private javax.swing.JTextField txtDiemThi;
    // End of variables declaration//GEN-END:variables
}
