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
        cb_showPass = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        btn_dki = new javax.swing.JButton();
        txt_mkhau = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusTraversalPolicyProvider(true);
        setMinimumSize(new java.awt.Dimension(687, 434));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Đăng nhập");

        jLabel2.setText("Tên đăng nhập:");

        jLabel3.setText("Mật khẩu:");

        btn_dnhap.setText("Đăng nhập");
        btn_dnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dnhapActionPerformed(evt);
            }
        });

        cb_showPass.setText("Hiện mật khẩu");
        cb_showPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_showPassActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Bạn chưa có tài khoản");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(txt_tendnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35)
                        .addComponent(txt_mkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(cb_showPass))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(btn_dnhap))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_dki)))
                .addGap(189, 189, 189))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2))
                    .addComponent(txt_tendnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3))
                    .addComponent(txt_mkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(cb_showPass)
                .addGap(30, 30, 30)
                .addComponent(btn_dnhap)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btn_dki, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

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
    private javax.swing.JCheckBox cb_showPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txt_mkhau;
    private javax.swing.JTextField txt_tendnhap;
    // End of variables declaration//GEN-END:variables

}
