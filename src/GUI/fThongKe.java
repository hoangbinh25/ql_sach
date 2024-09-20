package GUI;

import DAL.ThongKeDAL;
import DTO.ThongKe;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fThongKe extends javax.swing.JFrame {

    public fThongKe() {
        initComponents();
        load();
    }

    public void load() {
        try {
            DefaultTableModel md = new DefaultTableModel();
            md.addColumn("Tên Sách");
            md.addColumn("Tên Độc Giả");
            md.addColumn("Tên Thủ Thư");
            md.addColumn("Ngày Mượn");
            md.addColumn("Ngày Hẹn Trả");
            md.addColumn("Tong");
            md.addColumn("Đã Cho Mượn");
            md.addColumn("Đã Trả");
            md.addColumn("Còn Lại");
            md.addColumn("Tình Trạng");
            md.addColumn("Tiền Phạt");

            List<ThongKe> lst_tk = ThongKeDAL.loadTK();

            for (ThongKe tk : lst_tk) {
                String ten_S = tk.getTen_S();
                String ten_DG = tk.getTen_DG();
                String ten_TT = tk.getTen_TT();
                Date ngay_muon = tk.getNgay_muon();
                Date ngay_hen_tra = tk.getNgay_hen_tra();
                int sl_tong = tk.getSl_tong();
                int sl_dachomuon = tk.getSl_dachomuon();
                int sl_datra = tk.getSl_datra();
                int sl_con = tk.getSl_con();
                String tinh_trang = tk.getTinh_trang();
                double tien_phat = tk.getTien_phat();
                
                md.addRow(new Object[]{ten_S, ten_DG, ten_TT, ngay_muon, ngay_hen_tra, sl_tong, sl_dachomuon, sl_datra, sl_con, tinh_trang, tien_phat});
            }
            
            jThongKe.setModel(md);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi xử lý dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        jThongKe = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        label1.setText("Thống kê ");

        jThongKe.setModel(new javax.swing.table.DefaultTableModel(
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
        jThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jThongKeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jThongKe);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1163, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        label1.getAccessibleContext().setAccessibleName("Thống kê");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jThongKeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jThongKeMouseClicked

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
            java.util.logging.Logger.getLogger(fThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jThongKe;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
