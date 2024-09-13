package GUI;

import javax.swing.JOptionPane;

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
        btn_dnhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dnhapMouseClicked(evt);
            }
        });
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
                        .addComponent(btn_dnhap)))
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
                .addGap(59, 59, 59))
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

    }//GEN-LAST:event_btn_dnhapActionPerformed

    private void btn_dnhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dnhapMouseClicked
        // Lấy giá trị từ các trường nhập liệu
        String tenDangNhap = txt_tendnhap.getText();
        String matKhau = new String(txt_mkhau.getPassword());

        // Kiểm tra điều kiện đăng nhập
        if (tenDangNhap.equals("admin") && matKhau.equals("12345")) {
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            fSach sachFrame = new fSach();
            sachFrame.setDefaultCloseOperation(fSach.EXIT_ON_CLOSE);
            sachFrame.setLocationRelativeTo(null);
            sachFrame.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Sai tên tài khoản hoặc mật khẩu", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_dnhapMouseClicked

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
    private javax.swing.JButton btn_dnhap;
    private javax.swing.JCheckBox cb_showPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txt_mkhau;
    private javax.swing.JTextField txt_tendnhap;
    // End of variables declaration//GEN-END:variables

}
