package GUI;

import BUS.ThuThuBUS;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import DAL.ThuThuDAL;
import DTO.ThuThu;
import javax.swing.JOptionPane;

public class fThuThu extends javax.swing.JFrame {

    public fThuThu() {
        initComponents();
        load();
    }

    public void load() {
        loadTbl();
        txt_ma.setEditable(false);
        txt_ma.setEnabled(false);
    }

    public void loadTbl() {
        try {
            DefaultTableModel md = new DefaultTableModel();
            md.addColumn("Mã thủ thư ");
            md.addColumn("Tên thủ thư");
            md.addColumn("CMND");
            md.addColumn("SDT");
            md.addColumn("Email");
            md.addColumn("Password");

            List<ThuThu.CTThuThu> cttt = ThuThuBUS.LoadTBDATA();
            for (ThuThu.CTThuThu tt : cttt) {
                int ma = tt.getMa_thu_thu();
                String ten = tt.getTen_thu_thu();
                String cmnd = tt.getCmnd();
                String sdt = tt.getSdt();
                String email = tt.getEmail();
                String pass = tt.getPassword();

                md.addRow(new Object[]{ma, ten, cmnd, sdt, email, pass});
            }
            jTB_thuThu.setModel(md);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi load dữ liệu" + e.getMessage(), "lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void loadTbl_Search(String keyword) {
        try {
            DefaultTableModel md = new DefaultTableModel();
            md.addColumn("Mã thủ thư ");
            md.addColumn("Tên thủ thư");
            md.addColumn("CMND");
            md.addColumn("SDT");
            md.addColumn("Email");
            md.addColumn("Password");

            List<ThuThu.CTThuThu> cttt = ThuThuBUS.LoadtTbDATA_Search(keyword);
            for (ThuThu.CTThuThu tt : cttt) {
                int ma = tt.getMa_thu_thu();
                String ten = tt.getTen_thu_thu();
                String cmnd = tt.getCmnd();
                String sdt = tt.getSdt();
                String email = tt.getEmail();
                String pass = tt.getPassword();

                md.addRow(new Object[]{ma, ten, cmnd, sdt, email, pass});
            }
            jTB_thuThu.setModel(md);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi load dữ liệu" + e.getMessage(), "lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void clearForm() {
        txt_ma.setText("");
        txt_ten.setText("");
        txt_cmnd.setText("");
        txt_email.setText("");
        txt_sdt.setText("");
        txt_password.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_sua = new javax.swing.JButton();
        txt_sdt = new javax.swing.JTextField();
        txt_ma = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_xoa = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_timkiem = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTB_thuThu = new javax.swing.JTable();
        txt_email = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        txt_cmnd = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar_sach = new javax.swing.JMenuBar();
        menu_Sach = new javax.swing.JMenu();
        menu_thuThu = new javax.swing.JMenu();
        menu_muonTra = new javax.swing.JMenu();
        menu_qlTheLoai = new javax.swing.JMenu();
        menu_qlDocGia = new javax.swing.JMenu();
        menu_qlTacGia = new javax.swing.JMenu();
        menu_thongKe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        jLabel7.setText("SĐT:");

        jLabel6.setText("Mã Thủ Thư:");

        jLabel8.setText("Email");

        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        jLabel10.setText("PassWord: ");

        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });

        jTB_thuThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Ngôn ngữ", "Giá trị", "Số lượng", "Tác giả", "Thể loại", "Nhà xuất bản", "Năm xuất bản"
            }
        ));
        jTB_thuThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTB_thuThuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTB_thuThu);

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        jLabel1.setText("Tên Thủ Thư: ");

        txt_ten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenActionPerformed(evt);
            }
        });

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        txt_cmnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cmndActionPerformed(evt);
            }
        });

        btn_timkiem.setText("Tìm Kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        jLabel5.setText("CMND:");

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
        jMenuBar_sach.add(menu_thongKe);

        setJMenuBar(jMenuBar_sach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btn_them)
                                .addGap(84, 84, 84)
                                .addComponent(btn_sua)
                                .addGap(74, 74, 74)
                                .addComponent(btn_xoa)
                                .addGap(64, 64, 64)
                                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btn_timkiem))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_ma)
                            .addComponent(txt_ten)
                            .addComponent(txt_cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_sdt)
                            .addComponent(txt_email)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        try {
            ThuThu.CTThuThu tt = new ThuThu.CTThuThu(
                    Integer.parseInt(txt_ma.getText()),
                    txt_ten.getText(),
                    txt_cmnd.getText(),
                    txt_sdt.getText(),
                    txt_email.getText(),
                    txt_password.getText()
            );
            
            ThuThuBUS.sua(tt);
            JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            load();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sửa Không Thành Công !!!", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        int ma = Integer.parseInt(txt_ma.getText());
        try {
            ThuThuBUS.xoa(ma);
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

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void jTB_thuThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_thuThuMouseClicked
        int current = jTB_thuThu.getSelectedRow();
        
        txt_ma.setText(String.valueOf(jTB_thuThu.getValueAt(current, 0)));
        txt_ten.setText(String.valueOf(jTB_thuThu.getValueAt(current, 1)));
        txt_cmnd.setText(String.valueOf(jTB_thuThu.getValueAt(current, 2)));
        txt_sdt.setText(String.valueOf(jTB_thuThu.getValueAt(current, 3)));
        txt_email.setText(String.valueOf(jTB_thuThu.getValueAt(current, 4)));
        txt_password.setText(String.valueOf(jTB_thuThu.getValueAt(current, 5)));
    }//GEN-LAST:event_jTB_thuThuMouseClicked

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_tenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        try {
            ThuThu tt = new ThuThu(
                    txt_ten.getText(),
                    txt_cmnd.getText(),
                    txt_sdt.getText(),
                    txt_email.getText(),
                    txt_password.getText()
            );
            
            ThuThuBUS.them(tt);
            JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            load();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm Lỗi !!!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void txt_cmndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cmndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cmndActionPerformed

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        String keyword = txt_timkiem.getText();
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa có dữ liệu tìm kiếm đầu vào", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            load();
        } else {
            loadTbl_Search(keyword);
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

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

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fThuThu thuThuFrame = new fThuThu();
                thuThuFrame.setDefaultCloseOperation(fThuThu.EXIT_ON_CLOSE);
                thuThuFrame.setLocationRelativeTo(null);
                thuThuFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar_sach;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTB_thuThu;
    private javax.swing.JMenu menu_Sach;
    private javax.swing.JMenu menu_muonTra;
    private javax.swing.JMenu menu_qlDocGia;
    private javax.swing.JMenu menu_qlTacGia;
    private javax.swing.JMenu menu_qlTheLoai;
    private javax.swing.JMenu menu_thongKe;
    private javax.swing.JMenu menu_thuThu;
    private javax.swing.JTextField txt_cmnd;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_ten;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
