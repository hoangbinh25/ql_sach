package GUI;

import BUS.TacGiaBUS;
import javax.swing.table.DefaultTableModel;
import DAL.TacGiaDAL;
import DTO.TacGia;
import java.util.List;
import javax.swing.JOptionPane;

public class fTacGia extends javax.swing.JFrame {

    public fTacGia() {
        initComponents();
        load();
    }

    public void load() {
        loadTBL();
    }

    public void loadTBL() {
        try {
            DefaultTableModel md = new DefaultTableModel();
            md.addColumn("Mã Tác Giả");
            md.addColumn("Tên Tác Giả");

            List<TacGia> tacGia = TacGiaBUS.loadTbaleData();

            for (TacGia tg : tacGia) {
                int ma = tg.getMa_tac_gia();
                String ten = tg.getTen_tac_gia();

                md.addRow(new Object[]{ma, ten});
            }
            jTB_tacGia.setModel(md);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi xử lý dữ liệu" + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void loadTBL_Search(String keyword) {
        try {
            DefaultTableModel md = new DefaultTableModel();
            md.addColumn("Mã Tác Giả");
            md.addColumn("Tên Tác Giả");

            List<TacGia> tacgia = TacGiaBUS.loadTbaleDataSearch(keyword);

            for (TacGia tg : tacgia) {
                int ma = tg.getMa_tac_gia();
                String ten = tg.getTen_tac_gia();

                md.addRow(new Object[]{ma, ten});
            }
            jTB_tacGia.setModel(md);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi Load dữ liệu" + e.getMessage(), "lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void clearForm() {
        txt_maTG.setText("");
        txt_tenTG.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_maTG = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_tenTG = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTB_tacGia = new javax.swing.JTable();
        btn_xoa = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        txt_timkiem = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        jMenuBar_sach = new javax.swing.JMenuBar();
        menu_Sach = new javax.swing.JMenu();
        menu_thuThu = new javax.swing.JMenu();
        menu_muonTra = new javax.swing.JMenu();
        menu_qlTheLoai = new javax.swing.JMenu();
        menu_qlDocGia = new javax.swing.JMenu();
        menu_qlTacGia = new javax.swing.JMenu();
        menu_thongKe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý tác giả");

        jLabel6.setText("Mã tác giả:");

        jLabel1.setText("Tên tác giả:  ");

        txt_tenTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenTGActionPerformed(evt);
            }
        });

        jTB_tacGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã tên giả", "Tên tác giả"
            }
        ));
        jTB_tacGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTB_tacGiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTB_tacGia);

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
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tenTG)
                            .addComponent(txt_maTG)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_them)
                        .addGap(18, 18, 18)
                        .addComponent(btn_sua)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xoa)
                        .addGap(18, 18, 18)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btn_timkiem)))
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_maTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tenTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa)
                    .addComponent(btn_timkiem))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tenTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenTGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenTGActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        try {
            int ma = Integer.parseInt(txt_maTG.getText());
            TacGiaDAL.xoa(ma);
            load();
            clearForm();
            JOptionPane.showMessageDialog(null, "Xóa Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Mã không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xóa thất bại! Vui lòng kiểm tra mã.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        try {
            TacGia tg = new TacGia(
                Integer.parseInt(txt_maTG.getText()),
                txt_tenTG.getText()
            );
            
            TacGiaBUS.them(tg);
            load();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm không thành công"+e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        try {
            String search = txt_timkiem.getText();
            if (search.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Chưa có dữ liệu đầu vào", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }else{
                TacGiaBUS.loadTbaleDataSearch(search);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        try {
            TacGia tg = new TacGia(
                Integer.parseInt(txt_maTG.getText()),
                txt_tenTG.getText()
            );
            
            TacGiaBUS.sua(tg);
            JOptionPane.showMessageDialog(null, "Sửa Thành Công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            load();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sửa không thành công", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void jTB_tacGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_tacGiaMouseClicked
        int current = jTB_tacGia.getSelectedRow();
        txt_maTG.setText(String.valueOf(jTB_tacGia.getValueAt(current, 0)));
        txt_tenTG.setText(String.valueOf(jTB_tacGia.getValueAt(current, 1)));
    }//GEN-LAST:event_jTB_tacGiaMouseClicked

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
                fTacGia tacGiaFrame = new fTacGia();
                tacGiaFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar_sach;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTB_tacGia;
    private javax.swing.JMenu menu_Sach;
    private javax.swing.JMenu menu_muonTra;
    private javax.swing.JMenu menu_qlDocGia;
    private javax.swing.JMenu menu_qlTacGia;
    private javax.swing.JMenu menu_qlTheLoai;
    private javax.swing.JMenu menu_thongKe;
    private javax.swing.JMenu menu_thuThu;
    private javax.swing.JTextField txt_maTG;
    private javax.swing.JTextField txt_tenTG;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
