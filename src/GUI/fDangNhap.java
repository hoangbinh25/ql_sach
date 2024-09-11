/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class fDangNhap extends javax.swing.JFrame {

    /**
     * Creates new form trangChu
     */
    public fDangNhap() {
        initComponents();
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
        if(cb_showPass.isSelected()) {
            txt_mkhau.setEchoChar((char)0);
        } else {
            txt_mkhau.setEchoChar('*');
        }
    }//GEN-LAST:event_cb_showPassActionPerformed

    private void btn_dnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dnhapActionPerformed
        if (txt_tendnhap.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Bạn chưa điền tên đăng nhập");
        } else if (txt_mkhau.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập mật khẩu");
        } else if (txt_tendnhap.getText().equals("admin") && txt_mkhau.getText().equals("12345")) {
            JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
            fSach sachFrame = new fSach();
            sachFrame.setVisible(true);
            sachFrame.pack();
            sachFrame.setLocationRelativeTo(null);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_dnhapActionPerformed

    private void btn_dkiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dkiActionPerformed
        fDangKy DkyFrame = new fDangKy();
        DkyFrame.setVisible(true);
        DkyFrame.pack();
        DkyFrame.setLocationRelativeTo(null);
        this.dispose();
        
    }//GEN-LAST:event_btn_dkiActionPerformed

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
            java.util.logging.Logger.getLogger(fDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fDangNhap dNhapFrame = new fDangNhap();
                dNhapFrame.setDefaultCloseOperation(fDangNhap.EXIT_ON_CLOSE);
                dNhapFrame.setLocationRelativeTo(null);
                dNhapFrame.setVisible(true);
//                new fDangNhap().setVisible(true);
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
