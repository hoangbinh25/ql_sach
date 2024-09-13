package GUI;

public class fKhoSach extends javax.swing.JFrame {

    public fKhoSach() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_xoa = new javax.swing.JButton();
        txt_timkiem = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_timkiem = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_khosach = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_vitri = new javax.swing.JTextField();
        jComboBox_tenSach = new javax.swing.JComboBox<>();
        txt_soluong = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_masach = new javax.swing.JTextField();
        txt_ngayNhap = new javax.swing.JTextField();
        txt_ngayXuat = new javax.swing.JTextField();
        jMenuBar_khosach = new javax.swing.JMenuBar();
        menu_Sach = new javax.swing.JMenu();
        menu_theLoai = new javax.swing.JMenu();
        menu_tacGia = new javax.swing.JMenu();
        menu_nhaXB = new javax.swing.JMenu();
        menu_khoSach = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kho sách");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        btn_xoa.setText("Xóa");
        btn_xoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_them.setText("Thêm");
        btn_them.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_timkiem.setText("Tìm Kiếm");
        btn_timkiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTable_khosach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Vị trí", "Ngày nhập kho", "Ngày xuất kho", "Số lượng"
            }
        ));
        jScrollPane1.setViewportView(jTable_khosach);

        jLabel2.setText("Tên sách:");

        jLabel5.setText("Ngày xuất kho:");

        jLabel6.setText("Ngày nhập kho:");

        jLabel7.setText("Vị trí:");

        jComboBox_tenSach.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox_tenSach.setEditor(null);
        jComboBox_tenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_tenSachActionPerformed(evt);
            }
        });

        jLabel8.setText("Số lượng:");

        jLabel1.setText("Mã sách");

        menu_Sach.setText("Sách");
        menu_Sach.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_Sach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_SachMouseClicked(evt);
            }
        });
        jMenuBar_khosach.add(menu_Sach);

        menu_theLoai.setText("Thể Loại");
        menu_theLoai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_theLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_theLoaiMouseClicked(evt);
            }
        });
        jMenuBar_khosach.add(menu_theLoai);

        menu_tacGia.setText("Tác Giả");
        menu_tacGia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_tacGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_tacGiaMouseClicked(evt);
            }
        });
        jMenuBar_khosach.add(menu_tacGia);

        menu_nhaXB.setText("Nhà XB");
        menu_nhaXB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_nhaXB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_nhaXBMouseClicked(evt);
            }
        });
        jMenuBar_khosach.add(menu_nhaXB);

        menu_khoSach.setText("Kho Sách");
        menu_khoSach.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar_khosach.add(menu_khoSach);

        setJMenuBar(jMenuBar_khosach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7)
                        .addGap(43, 43, 43)
                        .addComponent(txt_vitri, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(58, 58, 58)
                        .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn_them)
                        .addGap(14, 14, 14)
                        .addComponent(btn_sua)
                        .addGap(14, 14, 14)
                        .addComponent(btn_xoa)
                        .addGap(24, 24, 24)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btn_timkiem))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox_tenSach, 0, 257, Short.MAX_VALUE)
                            .addComponent(txt_masach))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_ngayNhap)
                            .addComponent(txt_ngayXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txt_masach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_ngayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_tenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txt_ngayXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)))
                    .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_vitri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiem))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

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

    private void menu_tacGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_tacGiaMouseClicked
        fTacGia tacGiaFrame = new fTacGia();
        tacGiaFrame.setDefaultCloseOperation(fTacGia.EXIT_ON_CLOSE);
        tacGiaFrame.setLocationRelativeTo(null);
        tacGiaFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_tacGiaMouseClicked

    private void menu_nhaXBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_nhaXBMouseClicked
        fNhaXB NXBFrame = new fNhaXB();
        NXBFrame.setDefaultCloseOperation(fNhaXB.EXIT_ON_CLOSE);
        NXBFrame.setLocationRelativeTo(null);
        NXBFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_nhaXBMouseClicked

    private void jComboBox_tenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_tenSachActionPerformed
        
    }//GEN-LAST:event_jComboBox_tenSachActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fKhoSach khoSachFrame = new fKhoSach();
                khoSachFrame.setDefaultCloseOperation(fKhoSach.EXIT_ON_CLOSE);
                khoSachFrame.setLocationRelativeTo(null);
                khoSachFrame.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> jComboBox_tenSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar_khosach;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_khosach;
    private javax.swing.JMenu menu_Sach;
    private javax.swing.JMenu menu_khoSach;
    private javax.swing.JMenu menu_nhaXB;
    private javax.swing.JMenu menu_tacGia;
    private javax.swing.JMenu menu_theLoai;
    private javax.swing.JTextField txt_masach;
    private javax.swing.JTextField txt_ngayNhap;
    private javax.swing.JTextField txt_ngayXuat;
    private javax.swing.JTextField txt_soluong;
    private javax.swing.JTextField txt_timkiem;
    private javax.swing.JTextField txt_vitri;
    // End of variables declaration//GEN-END:variables
}
