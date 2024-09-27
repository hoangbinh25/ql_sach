package GUI;

import BUS.TheLoaiBUS;
import DAL.TheLoaiDAL;
import DTO.TheLoai;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fTheLoai extends javax.swing.JFrame {

    public fTheLoai() {
        initComponents();
        Load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_timkiem = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        txt_maTheLoai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_tenTheLoai = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTBtheLoai = new javax.swing.JTable();
        btn_xoa = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        txt_timkiem = new javax.swing.JTextField();
        jMenuBar_sach = new javax.swing.JMenuBar();
        menu_Sach = new javax.swing.JMenu();
        menu_thuThu = new javax.swing.JMenu();
        menu_muonTra = new javax.swing.JMenu();
        menu_qlTheLoai = new javax.swing.JMenu();
        menu_qlDocGia = new javax.swing.JMenu();
        menu_qlTacGia = new javax.swing.JMenu();
        menu_thongKe = new javax.swing.JMenu();
        menu_dxuat = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý thể loại");

        btn_timkiem.setText("Tìm Kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        jLabel6.setText("Mã thể loại:");

        jLabel1.setText("Tên thể loại: ");

        txt_tenTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenTheLoaiActionPerformed(evt);
            }
        });

        jTBtheLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã thể loại", "Tên thể loại"
            }
        ));
        jTBtheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTBtheLoaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTBtheLoai);

        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        menu_Sach.setText("Quản lý sách");
        menu_Sach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_SachMouseClicked(evt);
            }
        });
        jMenuBar_sach.add(menu_Sach);

        menu_thuThu.setText("Quản lý thủ thư");
        menu_thuThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_thuThuMouseClicked(evt);
            }
        });
        menu_thuThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_thuThuActionPerformed(evt);
            }
        });
        jMenuBar_sach.add(menu_thuThu);

        menu_muonTra.setText("Quản lý mượn trả sách");
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

        menu_qlDocGia.setText("Quản lý độc giả");
        menu_qlDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_qlDocGiaMouseClicked(evt);
            }
        });
        jMenuBar_sach.add(menu_qlDocGia);

        menu_qlTacGia.setText("Quản lý tác giả");
        menu_qlTacGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_qlTacGiaMouseClicked(evt);
            }
        });
        jMenuBar_sach.add(menu_qlTacGia);

        menu_thongKe.setText("Thống kê");
        menu_thongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_thongKeMouseClicked(evt);
            }
        });
        jMenuBar_sach.add(menu_thongKe);

        menu_dxuat.setText("Đăng xuất");
        menu_dxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_dxuatMouseClicked(evt);
            }
        });
        jMenuBar_sach.add(menu_dxuat);

        setJMenuBar(jMenuBar_sach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_them)
                                .addGap(18, 18, 18)
                                .addComponent(btn_sua)
                                .addGap(18, 18, 18)
                                .addComponent(btn_xoa)
                                .addGap(18, 18, 18)
                                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btn_timkiem))
                            .addComponent(txt_maTheLoai, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                            .addComponent(txt_tenTheLoai))))
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_maTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tenTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa)
                    .addComponent(btn_timkiem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Load() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mã thể loại");
            model.addColumn("Tên thể loại");

            List<TheLoai> TheLoaiList = TheLoaiBUS.loadTableData();
            for (TheLoai theLoai : TheLoaiList) {
                int ma_TheLoai = theLoai.getMa_the_loai();
                String ten_TheLoai = theLoai.getTen_the_loai();
                model.addRow(new Object[]{
                    ma_TheLoai,
                    ten_TheLoai
                });
            }
            jTBtheLoai.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xử lý dữ liệu: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void loadTBL_Search(String Search) {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mã thể loại");
            model.addColumn("Tên thể loại");

            List<TheLoai> TheLoaiList = TheLoaiBUS.loadTableDataSearch(Search);
            for (TheLoai theLoai : TheLoaiList) {
                int ma_TheLoai = theLoai.getMa_the_loai();
                String ten_TheLoai = theLoai.getTen_the_loai();
                model.addRow(new Object[]{
                    ma_TheLoai,
                    ten_TheLoai
                });
            }
            jTBtheLoai.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xử lý dữ liệu: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void clearForm() {
        txt_maTheLoai.setText("");
        txt_tenTheLoai.setText("");
    }

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        String search = txt_timkiem.getText().trim(); //Loại bỏ khoảng trắng đầu và cuối chuỗi mỗi khi ng dùng nhập
        if (search.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa có dữ liệu tìm kiếm đầu vào", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            Load();
        } else {
            loadTBL_Search(search);

            if (jTBtheLoai.getRowCount() == 0) { // Kiểm tra nếu bảng không có dữ liệu
                JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả nào phù hợp", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        try {
            TheLoai theloai = new TheLoai(
                    Integer.parseInt(txt_maTheLoai.getText()),
                    txt_tenTheLoai.getText()
            );

            TheLoaiBUS.suaTheLoai(theloai);

            JOptionPane.showMessageDialog(null, "Cập nhật thể loại thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Load();
            clearForm();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cập nhật thể loại thất bại! Vui lòng kiểm tra mã sách.", "Lỗi", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void txt_tenTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenTheLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenTheLoaiActionPerformed

    private void jTBtheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBtheLoaiMouseClicked
        int current = jTBtheLoai.getSelectedRow(); // Lấy hàng hiện tại

        //      Điền dữ liệu vào JTextField
        txt_maTheLoai.setText(String.valueOf(jTBtheLoai.getValueAt(current, 0)));
        txt_tenTheLoai.setText(String.valueOf(jTBtheLoai.getValueAt(current, 1)));
    }//GEN-LAST:event_jTBtheLoaiMouseClicked

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        try {
            int maTheLoai = Integer.parseInt(txt_maTheLoai.getText()); // Lấy mã thể loại

            TheLoaiBUS.xoaTheLoai(maTheLoai);
            JOptionPane.showMessageDialog(null, "Xóa thể loại thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Load();
            clearForm();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Mã thể loại không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xóa sách thất bại! Vui lòng kiểm tra mã sách.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        try {
            TheLoai theloai = new TheLoai(
                    Integer.parseInt(txt_maTheLoai.getText()),
                    txt_tenTheLoai.getText()
            );

            TheLoaiBUS.themTheLoai(theloai);

            JOptionPane.showMessageDialog(null, "Thêm thể loại thành công!", "Thông báop", JOptionPane.INFORMATION_MESSAGE);
            Load();
            clearForm();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Thêm thể loại thất bại! Vui lòng kiểm tra lại dữ liệu đầu vào", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void menu_SachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_SachMouseClicked
        fSach sachFrame = new fSach();
        sachFrame.setDefaultCloseOperation(fSach.EXIT_ON_CLOSE);
        sachFrame.setLocationRelativeTo(null);
        sachFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_SachMouseClicked

    private void menu_thuThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_thuThuMouseClicked
        fThuThu thuThuFrame = new fThuThu();
        thuThuFrame.setDefaultCloseOperation(fThuThu.EXIT_ON_CLOSE);
        thuThuFrame.setLocationRelativeTo(null);
        thuThuFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_thuThuMouseClicked

    private void menu_thuThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_thuThuActionPerformed

    }//GEN-LAST:event_menu_thuThuActionPerformed

    private void menu_muonTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_muonTraMouseClicked
        fMuonTra muonTraFrame = new fMuonTra();
        muonTraFrame.setDefaultCloseOperation(fMuonTra.EXIT_ON_CLOSE);
        muonTraFrame.setLocationRelativeTo(null);
        muonTraFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_muonTraMouseClicked

    private void menu_qlTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_qlTheLoaiMouseClicked
        fTheLoai theLoaiFrame = new fTheLoai();
        theLoaiFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        theLoaiFrame.setLocationRelativeTo(null);
        theLoaiFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_qlTheLoaiMouseClicked

    private void menu_qlDocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_qlDocGiaMouseClicked
        fDocGia docGiaFrame = new fDocGia();
        docGiaFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        docGiaFrame.setLocationRelativeTo(null);
        docGiaFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_qlDocGiaMouseClicked

    private void menu_qlTacGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_qlTacGiaMouseClicked
        fTacGia tacGiaFrame = new fTacGia();
        tacGiaFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        tacGiaFrame.setLocationRelativeTo(null);
        tacGiaFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_qlTacGiaMouseClicked

    private void menu_thongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_thongKeMouseClicked
        fThongKe thongKeFrame = new fThongKe();
        thongKeFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        thongKeFrame.setLocationRelativeTo(null);
        thongKeFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_thongKeMouseClicked

    private void menu_dxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_dxuatMouseClicked
        // Hiển thị hộp thoại
        int result = JOptionPane.showConfirmDialog(this,
            "Bạn có muốn đăng xuất không?", "Thông báo",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        // Nếu click "yes"
        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Bạn đã đăng xuất tài khoản thành công");
            this.dispose();

            fDangNhap login = new fDangNhap();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        }
    }//GEN-LAST:event_menu_dxuatMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fTheLoai theLoaiFrame = new fTheLoai();
                theLoaiFrame.setDefaultCloseOperation(fTheLoai.EXIT_ON_CLOSE);
                theLoaiFrame.setLocationRelativeTo(null);
                theLoaiFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar_sach;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTBtheLoai;
    private javax.swing.JMenu menu_Sach;
    private javax.swing.JMenu menu_dxuat;
    private javax.swing.JMenu menu_muonTra;
    private javax.swing.JMenu menu_qlDocGia;
    private javax.swing.JMenu menu_qlTacGia;
    private javax.swing.JMenu menu_qlTheLoai;
    private javax.swing.JMenu menu_thongKe;
    private javax.swing.JMenu menu_thuThu;
    private javax.swing.JTextField txt_maTheLoai;
    private javax.swing.JTextField txt_tenTheLoai;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
