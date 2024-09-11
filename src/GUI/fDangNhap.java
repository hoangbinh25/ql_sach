package GUI;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.*;

import Class.ConnectToSQLServer;

public class fDangNhap extends javax.swing.JFrame {

    public fDangNhap() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_tendnhap = new javax.swing.JTextField();
        btn_dnhap = new javax.swing.JButton();
        btn_quenmkhau1 = new javax.swing.JButton();
        cb_showPass = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        btn_dki = new javax.swing.JButton();
        txt_mkhau = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusTraversalPolicyProvider(true);
        setMinimumSize(new java.awt.Dimension(687, 434));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Đăng nhập");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 35, 267, -1));

        jLabel2.setText("Tên đăng nhập:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 137, -1, -1));

        jLabel3.setText("Mật khẩu:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 186, -1, -1));
        getContentPane().add(txt_tendnhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 132, 170, -1));

        btn_dnhap.setText("Đăng nhập");
        btn_dnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dnhapActionPerformed(evt);
            }
        });
        getContentPane().add(btn_dnhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, -1));

        btn_quenmkhau1.setText("Quên mật khẩu");
        getContentPane().add(btn_quenmkhau1, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 305, 164, -1));

        cb_showPass.setText("Hiện mật khẩu");
        cb_showPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_showPassActionPerformed(evt);
            }
        });
        getContentPane().add(cb_showPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Bạn chưa có tài khoản");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 354, -1, -1));

        btn_dki.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_dki.setText("Đăng ký");
        btn_dki.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dkiMouseClicked(evt);
            }
        });
        btn_dki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dkiActionPerformed(evt);
            }
        });
        getContentPane().add(btn_dki, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 350, -1, 30));
        getContentPane().add(txt_mkhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 181, 170, -1));

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_showPassActionPerformed
        if (cb_showPass.isSelected()) {
            txt_mkhau.setEchoChar((char) 0);
        } else {
            txt_mkhau.setEchoChar('*');
        }
    }//GEN-LAST:event_cb_showPassActionPerformed

    private void btn_dnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dnhapActionPerformed
       
        String user = txt_tendnhap.getText();
        String pass = txt_mkhau.getText();
        
        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        return;
    }
        String sql_login = "Select * from TaiKhoan where ten_tai_khoan = ? and mat_khau = ?";

        try(Connection conn = ConnectToSQLServer.getConnection()) {
            
            PreparedStatement ps = conn.prepareStatement(sql_login);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
                fSach sachFrame = new fSach();
                sachFrame.setLocationRelativeTo(null);
                sachFrame.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_dnhapActionPerformed

    private void btn_dkiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dkiActionPerformed

    }//GEN-LAST:event_btn_dkiActionPerformed

    private void btn_dkiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dkiMouseClicked
        fDangKy DkyFrame = new fDangKy();
        DkyFrame.setVisible(true);
        DkyFrame.pack();
        DkyFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btn_dkiMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fDangNhap dNhapFrame = new fDangNhap();
                dNhapFrame.setDefaultCloseOperation(fDangNhap.EXIT_ON_CLOSE);
                dNhapFrame.setLocationRelativeTo(null);
                dNhapFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dki;
    private javax.swing.JButton btn_dnhap;
    private javax.swing.JButton btn_quenmkhau1;
    private javax.swing.JCheckBox cb_showPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txt_mkhau;
    private javax.swing.JTextField txt_tendnhap;
    // End of variables declaration//GEN-END:variables

}
