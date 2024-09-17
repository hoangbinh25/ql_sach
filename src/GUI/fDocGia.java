package GUI;

public class fDocGia extends javax.swing.JFrame {

    public fDocGia() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_maDG = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_ngaySinh = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        txt_CCCD = new javax.swing.JTextField();
        txt_timkiem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTB_sach = new javax.swing.JTable();
        txt_diaChi = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_tenDG = new javax.swing.JTextField();
        btn_sua = new javax.swing.JButton();
        txt_chucVu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar_sach = new javax.swing.JMenuBar();
        menu_Sach = new javax.swing.JMenu();
        menu_khoSach = new javax.swing.JMenu();
        menu_muonTra = new javax.swing.JMenu();
        menu_qlTheLoai = new javax.swing.JMenu();
        menu_qlTacGia = new javax.swing.JMenu();
        menu_thongKe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý độc giả");

        jLabel9.setText("Ngày sinh: ");

        jLabel6.setText("Mã độc giả:");

        txt_ngaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ngaySinhActionPerformed(evt);
            }
        });

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        jLabel3.setText("Số điện thoại:");

        jTB_sach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã độc giả", "Tên độc giả", "Ngày sinh", "Địa chỉ", "CCCD", "Số điện thoại", "Chức vụ"
            }
        ));
        jTB_sach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTB_sachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTB_sach);

        btn_timkiem.setText("Tìm Kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        jLabel1.setText("Tên độc giả: ");

        jLabel2.setText("Địa chỉ: ");

        jLabel4.setText("CCCD:");

        txt_tenDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenDGActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        jLabel5.setText("Chức vụ: ");

        menu_Sach.setText("Quản lý sách");
        menu_Sach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_SachMouseClicked(evt);
            }
        });
        jMenuBar_sach.add(menu_Sach);

        menu_khoSach.setText("Quản lý kho sách");
        menu_khoSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_khoSachMouseClicked(evt);
            }
        });
        menu_khoSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_khoSachActionPerformed(evt);
            }
        });
        jMenuBar_sach.add(menu_khoSach);

        menu_muonTra.setText("Mượn trả sách");
        menu_muonTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_muonTraMouseClicked(evt);
            }
        });
        jMenuBar_sach.add(menu_muonTra);

        menu_qlTheLoai.setText("Quản lý thể loại");
        menu_qlTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_qlTheLoaiMouseClicked(evt);
            }
        });
        jMenuBar_sach.add(menu_qlTheLoai);

        menu_qlTacGia.setText("Quản lý tác giả");
        jMenuBar_sach.add(menu_qlTacGia);

        menu_thongKe.setText("Thống kê");
        jMenuBar_sach.add(menu_thongKe);

        setJMenuBar(jMenuBar_sach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(btn_them)
                        .addGap(84, 84, 84)
                        .addComponent(btn_sua)
                        .addGap(74, 74, 74)
                        .addComponent(btn_xoa)
                        .addGap(64, 64, 64)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btn_timkiem))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(50, 50, 50))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_diaChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_tenDG, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_maDG, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(189, 189, 189)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_chucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(39, 39, 39)
                                .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_maDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tenDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(txt_chucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiem))
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed

    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
       
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void jTB_sachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_sachMouseClicked
        
    }//GEN-LAST:event_jTB_sachMouseClicked

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void txt_tenDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenDGActionPerformed
        
    }//GEN-LAST:event_txt_tenDGActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        
    }//GEN-LAST:event_btn_suaActionPerformed

    private void txt_ngaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ngaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ngaySinhActionPerformed

    private void menu_SachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_SachMouseClicked
        fSach sachFrame = new fSach();
        sachFrame.setDefaultCloseOperation(fSach.EXIT_ON_CLOSE);
        sachFrame.setLocationRelativeTo(null);
        sachFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_SachMouseClicked

    private void menu_khoSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_khoSachMouseClicked
        fKhoSach khoSachFrame = new fKhoSach();
        khoSachFrame.setDefaultCloseOperation(fKhoSach.EXIT_ON_CLOSE);
        khoSachFrame.setLocationRelativeTo(null);
        khoSachFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_khoSachMouseClicked

    private void menu_khoSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_khoSachActionPerformed
        
    }//GEN-LAST:event_menu_khoSachActionPerformed

    private void menu_muonTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_muonTraMouseClicked
        fMuonTra muonTraFrame = new fMuonTra();
        muonTraFrame.setDefaultCloseOperation(fMuonTra.EXIT_ON_CLOSE);
        muonTraFrame.setLocationRelativeTo(null);
        muonTraFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_muonTraMouseClicked

    private void menu_qlTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_qlTheLoaiMouseClicked
        fTheLoai theLoaiFrame = new fTheLoai();
        theLoaiFrame.setDefaultCloseOperation(fTheLoai.EXIT_ON_CLOSE);
        theLoaiFrame.setLocationRelativeTo(null);
        theLoaiFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_qlTheLoaiMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fDocGia docGiaFrame = new fDocGia();
                docGiaFrame.setDefaultCloseOperation(fSach.EXIT_ON_CLOSE);
                docGiaFrame.setLocationRelativeTo(null);
                docGiaFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar_sach;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTB_sach;
    private javax.swing.JMenu menu_Sach;
    private javax.swing.JMenu menu_khoSach;
    private javax.swing.JMenu menu_muonTra;
    private javax.swing.JMenu menu_qlTacGia;
    private javax.swing.JMenu menu_qlTheLoai;
    private javax.swing.JMenu menu_thongKe;
    private javax.swing.JTextField txt_CCCD;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_chucVu;
    private javax.swing.JTextField txt_diaChi;
    private javax.swing.JTextField txt_maDG;
    private javax.swing.JTextField txt_ngaySinh;
    private javax.swing.JTextField txt_tenDG;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
