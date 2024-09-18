package GUI;

import DAL.ConnectToSQLServer;
import javax.swing.JOptionPane;
import DTO.PhieuMuon;
import DAL.PhieuMuonDAL;
import static DAL.PhieuMuonDAL.loadTbaleData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class fMuonTra extends javax.swing.JFrame {

    public fMuonTra() {
        initComponents();
        Load();
    }

    private void Load() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mã phiếu mượn");
            model.addColumn("Mã thủ thư");
            model.addColumn("Mã độc giả");
            model.addColumn("Ngày mượn");
            model.addColumn("Ngày hẹn trả");
            model.addColumn("Ngày trả");
            model.addColumn("Trạng thái");

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

            // Xóa các mục hiện có trong ComboBox để tránh thêm trùng lặp
            cbb_trangThai.removeAllItems();

            // Thêm các trạng thái vào ComboBox
            cbb_trangThai.addItem("Đang mượn");
            cbb_trangThai.addItem("Đã trả");

            List<PhieuMuon> PhieuMuonList = PhieuMuonDAL.loadTbaleData();

            for (PhieuMuon pm : PhieuMuonList) {
                int ma_PM = pm.getMa_phieu_muon();
                int ma_thu_thu = pm.getMa_thu_thu();
                int ma_doc_gia = pm.getMa_doc_gia();
                Date ngayMuon = pm.getNgay_muon();
                String ngayMuonFormatted = dateFormatter.format(ngayMuon);
                Date ngayHenTra = pm.getNgay_hen_tra();
                String ngayHenTraFormatted = dateFormatter.format(ngayHenTra);
                Date ngayTra = pm.getNgay_tra();
                String ngayTraFormatted = dateFormatter.format(ngayTra);
                
                // Xác định trạng thái dựa trên ngày trả
                String trangThai = (ngayTra == null) ? "Đang mượn" : "Đã trả";

                model.addRow(new Object[]{
                    ma_PM,
                    ma_thu_thu,
                    ma_doc_gia,
                    ngayMuonFormatted,
                    ngayHenTraFormatted,
                    ngayTraFormatted,
                    trangThai});
            }

            jTB_phieuMuon.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xử lý dữ liệu : " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        jTB_phieuMuon.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = jTB_phieuMuon.getSelectedRow();

                if (selectedRow != -1) {
                    // Lấy dữ liệu trạng thái từ bảng
                    String trangThai = jTB_phieuMuon.getValueAt(selectedRow, 6).toString();

                    // Cập nhật ComboBox trạng thái
                    cbb_trangThai.setSelectedItem(trangThai);
                }
            }
        });
    }

    private void clearForm() {
        txt_maMuon.setText("");
        txt_maThuThu.setText("");
        txt_maDG.setText("");
        txt_ngayMuon.setText("");
        txt_ngayHen.setText("");
        txt_ngayTra.setText("");
        cbb_trangThai.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_sua = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_ngayTra = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTB_CTPM = new javax.swing.JTable();
        txt_maMuon = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_ngayMuon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_timkiem = new javax.swing.JButton();
        txt_maDG = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_xoa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_ngayHen = new javax.swing.JTextField();
        txt_maThuThu = new javax.swing.JTextField();
        txt_timkiem = new javax.swing.JTextField();
        txt_soLuong = new javax.swing.JTextField();
        txt_maPM1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_maCTPM = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTB_phieuMuon = new javax.swing.JTable();
        btn_them2 = new javax.swing.JButton();
        btn_xoa2 = new javax.swing.JButton();
        btn_sua1 = new javax.swing.JButton();
        cbb_trangThai1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbb_trangThai = new javax.swing.JComboBox<>();
        jMenuBar_sach = new javax.swing.JMenuBar();
        menu_Sach = new javax.swing.JMenu();
        menu_khoSach = new javax.swing.JMenu();
        menu_muonTra = new javax.swing.JMenu();
        menu_qlTheLoai = new javax.swing.JMenu();
        menu_qlDocGia = new javax.swing.JMenu();
        menu_qlTacGia = new javax.swing.JMenu();
        menu_thongKe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý mượn trả");

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        jLabel3.setText("Ngày trả:");

        jTB_CTPM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã CTPM", "Mã  phiếu mượn", "Số lượng", "Trạng thái"
            }
        ));
        jTB_CTPM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTB_CTPMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTB_CTPM);

        jLabel9.setText("Mã độc giả:");

        jLabel6.setText("Mã phiếu mượn:");

        btn_timkiem.setText("Tìm Kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        txt_maDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maDGActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã thủ thư:");

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        jLabel2.setText("Ngày mượn:");

        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        jLabel4.setText("Ngày hẹn trả:");

        txt_maThuThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maThuThuActionPerformed(evt);
            }
        });

        txt_maPM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maPM1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã CTPM:");

        jLabel8.setText("Trạng thái: ");

        jLabel10.setText("Mã phiếu mượn:");

        jLabel11.setText("Số lượng: ");

        jTB_phieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã mượn", "Mã sách", "Mã độc giả", "Ngày mượn", "Ngày hẹn trả", "Ngày trả", "Trạng thái"
            }
        ));
        jTB_phieuMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTB_phieuMuonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTB_phieuMuon);
        if (jTB_phieuMuon.getColumnModel().getColumnCount() > 0) {
            jTB_phieuMuon.getColumnModel().getColumn(0).setHeaderValue("Mã mượn");
            jTB_phieuMuon.getColumnModel().getColumn(1).setHeaderValue("Mã sách");
            jTB_phieuMuon.getColumnModel().getColumn(2).setHeaderValue("Mã độc giả");
            jTB_phieuMuon.getColumnModel().getColumn(3).setHeaderValue("Ngày mượn");
            jTB_phieuMuon.getColumnModel().getColumn(4).setHeaderValue("Ngày hẹn trả");
            jTB_phieuMuon.getColumnModel().getColumn(5).setHeaderValue("Ngày trả");
            jTB_phieuMuon.getColumnModel().getColumn(6).setHeaderValue("Trạng thái");
        }

        btn_them2.setText("Thêm");
        btn_them2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them2ActionPerformed(evt);
            }
        });

        btn_xoa2.setText("Xóa");
        btn_xoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoa2ActionPerformed(evt);
            }
        });

        btn_sua1.setText("Sửa");
        btn_sua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sua1ActionPerformed(evt);
            }
        });

        jLabel12.setText("Trạng thái: ");

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
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel1))
                                    .addGap(76, 76, 76)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_maDG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_maThuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(50, 50, 50)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txt_ngayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_maMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_maPM1)
                                    .addComponent(txt_maCTPM, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel12))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_ngayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_ngayHen, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(1, 1, 1))
                                    .addComponent(cbb_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel8))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_soLuong)
                                    .addComponent(cbb_trangThai1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(btn_them)
                        .addGap(84, 84, 84)
                        .addComponent(btn_sua)
                        .addGap(74, 74, 74)
                        .addComponent(btn_xoa)
                        .addGap(45, 45, 45)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btn_timkiem))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_them2)
                                .addGap(77, 77, 77)
                                .addComponent(btn_sua1)
                                .addGap(103, 103, 103)
                                .addComponent(btn_xoa2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(143, 143, 143)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(78, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ngayHen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ngayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbb_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_maMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_maThuThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_maDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ngayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_timkiem)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_them)
                            .addComponent(btn_sua)
                            .addComponent(btn_xoa))
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(225, 225, 225)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_maCTPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_maPM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_sua1)
                                .addComponent(btn_them2))
                            .addComponent(btn_xoa2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbb_trangThai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(227, 227, 227)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(367, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed

    }//GEN-LAST:event_btn_suaActionPerformed

    private void jTB_CTPMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_CTPMMouseClicked

    }//GEN-LAST:event_jTB_CTPMMouseClicked

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed

    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void txt_maDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maDGActionPerformed

    }//GEN-LAST:event_txt_maDGActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        try {
            PhieuMuon pm = new PhieuMuon(
                    Integer.parseInt(txt_maMuon.getText()),
                    Integer.parseInt(txt_maThuThu.getText()),
                    Integer.parseInt(txt_maDG.getText()),
                    java.sql.Date.valueOf(txt_ngayMuon.getText()), // Chuyển đổi sang kiểu Date
                    java.sql.Date.valueOf(txt_ngayHen.getText()),
                    java.sql.Date.valueOf(txt_ngayTra.getText()),
                    cbb_trangThai.getSelectedIndex()
            );

            PhieuMuonDAL.themPM(pm);
            
            // Thông báo thêm thành công
            JOptionPane.showMessageDialog(null, "Thêm phiếu mượn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Load();
            clearForm();
        } catch (Exception e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Thêm phiếu mượn thất bại! Vui lòng kiểm tra dữ liệu đầu vào.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed

    }//GEN-LAST:event_btn_xoaActionPerformed

    private void txt_maThuThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maThuThuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maThuThuActionPerformed

    private void txt_maPM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maPM1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maPM1ActionPerformed

    private void jTB_phieuMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_phieuMuonMouseClicked
        int current = jTB_phieuMuon.getSelectedRow();

        // Lấy hàng hiện tại
        //int curent = jTB_phieuMuon.getSelectedRow();
// Điền dữ liệu vào các JTextField
        txt_maMuon.setText(String.valueOf(jTB_phieuMuon.getValueAt(current, 0)));
        txt_maThuThu.setText(String.valueOf(jTB_phieuMuon.getValueAt(current, 1)));
        txt_maDG.setText(String.valueOf(jTB_phieuMuon.getValueAt(current, 2)));
        txt_ngayMuon.setText(String.valueOf(jTB_phieuMuon.getValueAt(current, 3)));
        txt_ngayHen.setText(String.valueOf(jTB_phieuMuon.getValueAt(current, 4)));
        txt_ngayTra.setText(String.valueOf(jTB_phieuMuon.getValueAt(current, 5)));

    }//GEN-LAST:event_jTB_phieuMuonMouseClicked

    private void btn_them2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_them2ActionPerformed

    private void btn_xoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoa2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xoa2ActionPerformed

    private void btn_sua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sua1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_sua1ActionPerformed

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
        fTacGia tacGiaFrame = new fTacGia();
        tacGiaFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        tacGiaFrame.setLocationRelativeTo(null);
        tacGiaFrame.setVisible(true);
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
                fMuonTra muonTraFrame = new fMuonTra();
                muonTraFrame.setDefaultCloseOperation(fSach.EXIT_ON_CLOSE);
                muonTraFrame.setLocationRelativeTo(null);
                muonTraFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_sua1;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_them2;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton btn_xoa2;
    private javax.swing.JComboBox<String> cbb_trangThai;
    private javax.swing.JComboBox<String> cbb_trangThai1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar_sach;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTB_CTPM;
    private javax.swing.JTable jTB_phieuMuon;
    private javax.swing.JMenu menu_Sach;
    private javax.swing.JMenu menu_khoSach;
    private javax.swing.JMenu menu_muonTra;
    private javax.swing.JMenu menu_qlDocGia;
    private javax.swing.JMenu menu_qlTacGia;
    private javax.swing.JMenu menu_qlTheLoai;
    private javax.swing.JMenu menu_thongKe;
    private javax.swing.JTextField txt_maCTPM;
    private javax.swing.JTextField txt_maDG;
    private javax.swing.JTextField txt_maMuon;
    private javax.swing.JTextField txt_maPM1;
    private javax.swing.JTextField txt_maThuThu;
    private javax.swing.JTextField txt_ngayHen;
    private javax.swing.JTextField txt_ngayMuon;
    private javax.swing.JTextField txt_ngayTra;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
