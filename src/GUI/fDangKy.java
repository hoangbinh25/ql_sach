package GUI;

import DAL.ConnectToSQLServer;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.UUID;

public class fDangKy extends javax.swing.JFrame {

    public fDangKy() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_tendnhap = new javax.swing.JTextField();
        btn_dky = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_dNhap = new javax.swing.JButton();
        cb_checkPass = new javax.swing.JCheckBox();
        txt_mkhau = new javax.swing.JPasswordField();

        popupMenu1.setLabel("popupMenu1");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng ký");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Đăng ký");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên đăng nhập:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mật khẩu:");

        btn_dky.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_dky.setText("Đăng ký");
        btn_dky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dkyActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Đã có tài khoản?");

        btn_dNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_dNhap.setText("Đăng nhập");
        btn_dNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dNhapMouseClicked(evt);
            }
        });
        btn_dNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dNhapActionPerformed(evt);
            }
        });

        cb_checkPass.setText("Hiện mật khẩu");
        cb_checkPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_checkPassMouseClicked(evt);
            }
        });
        cb_checkPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_checkPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel3)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_checkPass)
                            .addComponent(txt_mkhau)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_tendnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(200, 200, 200))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_dNhap)
                .addGap(240, 240, 240))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btn_dky)
                .addGap(300, 300, 300))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2))
                    .addComponent(txt_tendnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_mkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(cb_checkPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_dky)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dNhap)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    private void btn_dkyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dkyActionPerformed
        String email = txt_email.getText();
        String user = txt_tendnhap.getText();
        String pass = txt_mkhau.getText();

        if (email.isEmpty() || user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sql_check = "SELECT * FROM THU_THU WHERE email = ? OR ten_thu_thu = ?";
        String sql_dky = "INSERT INTO THU_THU(email, ten_thu_thu, password, cmnd, sdt) VALUES( ?, ?, ?, NULL, NULL)";
        
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            // Kiểm tra định dạng email
            if (!isValidEmailAddress(email)) {
                JOptionPane.showMessageDialog(this, "Email không hợp lệ!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return; // Dừng lại nếu email không hợp lệ
            }

            // Kiểm tra xem tài khoản đã tồn tại chưa
            PreparedStatement psCheck = conn.prepareStatement(sql_check);
            psCheck.setString(1, email);
            psCheck.setString(2, user);

            ResultSet rs = psCheck.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Email hoặc tên tài khoản đã tồn tại", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                PreparedStatement psInsert = conn.prepareStatement(sql_dky);
                psInsert.setString(1, email);
                psInsert.setString(2, user);
                psInsert.setString(3, pass);

                int rowsInsert = psInsert.executeUpdate();
                if (rowsInsert > 0) {
                    JOptionPane.showMessageDialog(this, "Đăng ký thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    fDangNhap dNhapFrame = new fDangNhap();
                    dNhapFrame.setLocationRelativeTo(null);
                    dNhapFrame.setVisible(true);
                    this.dispose();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_dkyActionPerformed

    private void btn_dNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dNhapActionPerformed

    }//GEN-LAST:event_btn_dNhapActionPerformed

    private void btn_dNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dNhapMouseClicked
        fDangNhap dNhapFrame = new fDangNhap();
        dNhapFrame.setVisible(true);
        dNhapFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btn_dNhapMouseClicked

    private void cb_checkPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_checkPassMouseClicked

    }//GEN-LAST:event_cb_checkPassMouseClicked

    private void cb_checkPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_checkPassActionPerformed
        if (cb_checkPass.isSelected()) {
            txt_mkhau.setEchoChar((char) 0);
        } else {
            txt_mkhau.setEchoChar('*');
        }
    }//GEN-LAST:event_cb_checkPassActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fDangKy dKyFrame = new fDangKy();
                dKyFrame.setDefaultCloseOperation(fDangKy.EXIT_ON_CLOSE);
                dKyFrame.setLocationRelativeTo(null);
                dKyFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dNhap;
    private javax.swing.JButton btn_dky;
    private javax.swing.JCheckBox cb_checkPass;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JTextField txt_email;
    private javax.swing.JPasswordField txt_mkhau;
    private javax.swing.JTextField txt_tendnhap;
    // End of variables declaration//GEN-END:variables
}
