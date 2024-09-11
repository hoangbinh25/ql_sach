package GUI;

public class fTacGia extends javax.swing.JFrame {

    public fTacGia() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_xoa = new javax.swing.JButton();
        txt_timkiem = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_timkiem = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        txt_tenTacGia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTB_tac_gia = new javax.swing.JTable();
        jMenuBar_tacgia = new javax.swing.JMenuBar();
        menu_Sach = new javax.swing.JMenu();
        menu_theLoai = new javax.swing.JMenu();
        menu_tacGia = new javax.swing.JMenu();
        menu_nhaXB = new javax.swing.JMenu();
        menu_khoSach = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tác giả");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tên tác giả");

        btn_xoa.setText("Xóa");

        btn_them.setText("Thêm");

        btn_timkiem.setText("Tìm Kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");

        jTB_tac_gia.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTB_tac_gia);

        jMenuBar_tacgia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuBar_tacgiaMouseClicked(evt);
            }
        });

        menu_Sach.setText("Sách");
        menu_Sach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_SachMouseClicked(evt);
            }
        });
        jMenuBar_tacgia.add(menu_Sach);

        menu_theLoai.setText("Thể Loại");
        menu_theLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_theLoaiMouseClicked(evt);
            }
        });
        jMenuBar_tacgia.add(menu_theLoai);

        menu_tacGia.setText("Tác Giả");
        jMenuBar_tacgia.add(menu_tacGia);

        menu_nhaXB.setText("Nhà XB");
        menu_nhaXB.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                menu_nhaXBMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenuBar_tacgia.add(menu_nhaXB);

        menu_khoSach.setText("Kho Sách");
        menu_khoSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_khoSachMouseClicked(evt);
            }
        });
        jMenuBar_tacgia.add(menu_khoSach);

        setJMenuBar(jMenuBar_tacgia);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addGap(14, 14, 14)
                    .addComponent(txt_tenTacGia)
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addComponent(btn_them)
                    .addGap(14, 14, 14)
                    .addComponent(btn_sua)
                    .addGap(14, 14, 14)
                    .addComponent(btn_xoa)
                    .addGap(24, 24, 24)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(33, 33, 33)
                    .addComponent(btn_timkiem)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txt_tenTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here: 
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void jMenuBar_tacgiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar_tacgiaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuBar_tacgiaMouseClicked

    private void menu_SachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_SachMouseClicked
        fSach sachFrame = new fSach();
        sachFrame.setDefaultCloseOperation(fSach.EXIT_ON_CLOSE);
        sachFrame.setLocationRelativeTo(null);
        sachFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_SachMouseClicked

    private void menu_theLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_theLoaiMouseClicked
        fTheLoai theLoaiFrame = new fTheLoai();
        theLoaiFrame.setDefaultCloseOperation(fTheLoai.EXIT_ON_CLOSE);
        theLoaiFrame.setLocationRelativeTo(null);
        theLoaiFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_theLoaiMouseClicked

    private void menu_nhaXBMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_menu_nhaXBMenuKeyPressed
        fNhaXB NXBFrame = new fNhaXB();
        NXBFrame.setDefaultCloseOperation(fNhaXB.EXIT_ON_CLOSE);
        NXBFrame.setLocationRelativeTo(null);
        NXBFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_nhaXBMenuKeyPressed

    private void menu_khoSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_khoSachMouseClicked
        fKhoSach khoSachFrame = new fKhoSach();
        khoSachFrame.setDefaultCloseOperation(fKhoSach.EXIT_ON_CLOSE);
        khoSachFrame.setLocationRelativeTo(null);
        khoSachFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_khoSachMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fTacGia tacGiaFrame = new fTacGia();
                tacGiaFrame.setDefaultCloseOperation(fTacGia.EXIT_ON_CLOSE);
                tacGiaFrame.setLocationRelativeTo(null);
                tacGiaFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar_tacgia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTB_tac_gia;
    private javax.swing.JMenu menu_Sach;
    private javax.swing.JMenu menu_khoSach;
    private javax.swing.JMenu menu_nhaXB;
    private javax.swing.JMenu menu_tacGia;
    private javax.swing.JMenu menu_theLoai;
    private javax.swing.JTextField txt_tenTacGia;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
