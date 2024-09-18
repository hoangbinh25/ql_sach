package GUI;

import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import DTO.DocGia;
import DAL.DocGiaDAL;
import javax.swing.JOptionPane;

public class fDocGia extends javax.swing.JFrame {

    public fDocGia() {
        initComponents();
        load();
    }

    public void load() {
        loadTBL();
    }

    public void clearForm() {
        txt_maDG.setText("");
        txt_tenDG.setText("");
        txt_ngaySinh.setText("");
        txt_diaChi.setText("");
        txt_CCCD.setText("");
        txt_SDT.setText("");
    }

    public void loadTBL() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mã độc giả");
            model.addColumn("Tên độc giả");
            model.addColumn("Ngày sinh");
            model.addColumn("Địa Chỉ");
            model.addColumn("CMND");
            model.addColumn("SDT");

            SimpleDateFormat fmDate = new SimpleDateFormat("dd-MM-yyyy");

            List<DocGia> dg = DocGiaDAL.loadTbaleData();
            for (DocGia docGia : dg) {
                int ma = docGia.getMa_doc_gia();
                String ten = docGia.getTen_doc_gia();
                String ngaysinhfm = fmDate.format(docGia.getNgay_sinh());
                String diachi = docGia.getDia_chi();
                String cmnd = docGia.getCmnd();
                String sdt = docGia.getSdt();

                model.addRow(new Object[]{ma, ten, ngaysinhfm, diachi, cmnd, sdt});
            }
            jTB_docGia.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi xử lý dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void loadTBL_Search(String keyword) {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mã độc giả");
            model.addColumn("Tên độc giả");
            model.addColumn("Ngày sinh");
            model.addColumn("Địa Chỉ");
            model.addColumn("CMND");
            model.addColumn("SDT");

            SimpleDateFormat fmDate = new SimpleDateFormat("dd-MM-yyyy");

            List<DocGia> dg = DocGiaDAL.loadTbaleDataSearch(keyword);
            for (DocGia docGia : dg) {
                int ma = docGia.getMa_doc_gia();
                String ten = docGia.getTen_doc_gia();
                String ngaysinhfm = fmDate.format(docGia.getNgay_sinh());
                String diachi = docGia.getDia_chi();
                String cmnd = docGia.getCmnd();
                String sdt = docGia.getSdt();
                model.addRow(new Object[]{ma, ten, ngaysinhfm, diachi, cmnd, sdt});
            }
            jTB_docGia.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi xử lý dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
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
        jTB_docGia = new javax.swing.JTable();
        txt_diaChi = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_tenDG = new javax.swing.JTextField();
        btn_sua = new javax.swing.JButton();
        jMenuBar_sach = new javax.swing.JMenuBar();
        menu_Sach = new javax.swing.JMenu();
        menu_khoSach = new javax.swing.JMenu();
        menu_muonTra = new javax.swing.JMenu();
        menu_qlTheLoai = new javax.swing.JMenu();
        menu_qlDocGia = new javax.swing.JMenu();
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

        jTB_docGia.setModel(new javax.swing.table.DefaultTableModel(
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
        jTB_docGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTB_docGiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTB_docGia);

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
        jMenuBar_sach.add(menu_thongKe);

        setJMenuBar(jMenuBar_sach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_them)
                        .addGap(84, 84, 84)
                        .addComponent(btn_sua)
                        .addGap(74, 74, 74)
                        .addComponent(btn_xoa)
                        .addGap(64, 64, 64)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btn_timkiem)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addGap(34, 34, 34)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_tenDG)
                                .addComponent(txt_maDG)
                                .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addGap(30, 30, 30))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_CCCD)
                                        .addComponent(txt_SDT)))
                                .addComponent(txt_diaChi)))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_maDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tenDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        try {
            SimpleDateFormat fmDate = new SimpleDateFormat("yyyy-MM-dd");
            DocGia dg = new DocGia(
                    Integer.parseInt(txt_maDG.getText()),
                    txt_tenDG.getText(),
                    java.sql.Date.valueOf(txt_ngaySinh.getText()),
                    txt_diaChi.getText(),
                    txt_CCCD.getText(),
                    txt_SDT.getText()
            );
            DocGiaDAL.them(dg);
            JOptionPane.showMessageDialog(null, "Thêm độc giả thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            load();
            clearForm();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        try {
            int maSach = Integer.parseInt(txt_maDG.getText());
            DocGiaDAL.xoa(maSach);
            JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            load();
            clearForm();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Mã không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xóa thất bại! Vui lòng kiểm tra mã.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void jTB_docGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_docGiaMouseClicked
        int curent = jTB_docGia.getSelectedRow();
        txt_maDG.setText(String.valueOf(jTB_docGia.getValueAt(curent, 0)));
        txt_tenDG.setText(String.valueOf(jTB_docGia.getValueAt(curent, 1)));
        txt_ngaySinh.setText(String.valueOf(jTB_docGia.getValueAt(curent, 2)));
        txt_diaChi.setText(String.valueOf(jTB_docGia.getValueAt(curent, 3)));
        txt_CCCD.setText(String.valueOf(jTB_docGia.getValueAt(curent, 4)));
        txt_SDT.setText(String.valueOf(jTB_docGia.getValueAt(curent, 5)));
    }//GEN-LAST:event_jTB_docGiaMouseClicked

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        String search = txt_timkiem.getText();
        if (search.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa có dữ liệu tìm kiếm đầu vào", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            loadTBL_Search(search);
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void txt_tenDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenDGActionPerformed

    }//GEN-LAST:event_txt_tenDGActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        try {
            DocGia dg = new DocGia(
                    Integer.parseInt(txt_maDG.getText()),
                    txt_tenDG.getText(),
                    java.sql.Date.valueOf(txt_ngaySinh.getText()),
                    txt_diaChi.getText(),
                    txt_CCCD.getText(),
                    txt_SDT.getText()
            );
            DocGiaDAL.capNhat(dg);

            // Thông báo cập nhật thành công
            JOptionPane.showMessageDialog(null, "Cập nhật sách thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            load();
            clearForm();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cập nhật sách thất bại! Vui lòng kiểm tra dữ liệu đầu vào.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
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

    private void menu_qlTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_qlTheLoaiMouseClicked
        fTheLoai theLoaiFrame = new fTheLoai();
        theLoaiFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar_sach;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTB_docGia;
    private javax.swing.JMenu menu_Sach;
    private javax.swing.JMenu menu_khoSach;
    private javax.swing.JMenu menu_muonTra;
    private javax.swing.JMenu menu_qlDocGia;
    private javax.swing.JMenu menu_qlTacGia;
    private javax.swing.JMenu menu_qlTheLoai;
    private javax.swing.JMenu menu_thongKe;
    private javax.swing.JTextField txt_CCCD;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_diaChi;
    private javax.swing.JTextField txt_maDG;
    private javax.swing.JTextField txt_ngaySinh;
    private javax.swing.JTextField txt_tenDG;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
