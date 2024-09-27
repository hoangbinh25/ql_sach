package GUI;

import BUS.ChiTietPMBUS;
import BUS.PhieuMuonBUS;
import javax.swing.JOptionPane;
import DTO.PhieuMuon;
import DTO.CTPM.ChiTietPM;
import DTO.CTPM;
import DAL.ChiTietPMDAL;
import DAL.PhieuMuonDAL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
//import org.apache.poi.xssf.usermodel.*;
//import org.apache.poi.ss.usermodel.*;

public class fMuonTra extends javax.swing.JFrame {

    List<PhieuMuon> lst_tbl = PhieuMuonBUS.loadTableData();

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public fMuonTra() {
        initComponents();
        Load();
    }

    SimpleDateFormat fmDate = new SimpleDateFormat("dd-MM-yyyy");

    private void loadCTPM(int ma) {
        try {
            DefaultTableModel md = new DefaultTableModel();
            md.addColumn("Mã Chi Tiết PM");
            md.addColumn("Mã Sách");
            md.addColumn("Tên Sách");

            List<ChiTietPM> ctpms = ChiTietPMBUS.LoadTbl(ma);
            for (ChiTietPM ctpm : ctpms) {
                int maCTPM = ctpm.getMa_chi_tiet();
                int maSach = ctpm.getMa_sach();
                String tenSach = ChiTietPMDAL.getTenSachById(ctpm.getMa_sach());

                md.addRow(new Object[]{maCTPM, maSach, tenSach});
            }
            jTB_CTPM.setModel(md);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi xử lý dữ liệu" + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void Load() {
        // load cbb_ThuThu
        loadCbbThuThu();

        // load cbb_DocGia
        loadCbbDocGia();

        // load cbb_TenSach
        loadCbbTenSach();

        // load tbl
        loadTbl_PM();

        // xử lý comboBox trạng thái
        loadTrangThai();
    }

    public void loadTrangThai() {
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

    public void loadTbl_PM() {
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

            List<PhieuMuon> PhieuMuonList = PhieuMuonBUS.loadTableData();

            for (PhieuMuon pm : PhieuMuonList) {
                int ma_PM = pm.getMa_phieu_muon();
                String thu_thu = PhieuMuonBUS.getThuThuById(pm.getMa_thu_thu());
                String doc_gia = PhieuMuonBUS.getDocGiaById(pm.getMa_doc_gia());

                // Xử lý ngày mượn (ngayMuon) - Kiểm tra nếu khác null trước khi định dạng
                Date ngayMuon = pm.getNgay_muon();
                String ngayMuonFormatted = (ngayMuon != null) ? dateFormatter.format(ngayMuon) : "N/A";

                // Xử lý ngày hẹn trả (ngayHenTra) - Kiểm tra nếu khác null trước khi định dạng
                Date ngayHenTra = pm.getNgay_hen_tra();
                String ngayHenTraFormatted = (ngayHenTra != null) ? dateFormatter.format(ngayHenTra) : "N/A";

                // Xử lý ngày trả (ngayTra) - Định dạng nếu có, nếu không thì hiển thị "Chưa trả"
                Date ngayTra = pm.getNgay_tra();
                String ngayTraFormatted = (ngayTra != null) ? dateFormatter.format(ngayTra) : ""; // Nếu null, hiển thị ""

                // Xác định trạng thái dựa trên ngày trả
                String trangThai = (ngayTra == null) ? "Đang mượn" : "Đã trả";

                model.addRow(new Object[]{
                    ma_PM,
                    thu_thu,
                    doc_gia,
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
    }

    public void loadCbbTenSach() {
        cbb_tenSach.removeAllItems();
        try {
            List<String> sachList = PhieuMuonBUS.load_cbb_tenSachData();
            for (String s : sachList) {
                cbb_tenSach.addItem(s);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xử lý dữ liệu từ bảng Tên sách: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void loadCbbThuThu() {
        cbb_maThuThu.removeAllItems();
        try {
            List<String> thuThuList = PhieuMuonBUS.load_cbb_thuTHUData();
            for (String tenThuThu : thuThuList) {
                cbb_maThuThu.addItem(tenThuThu);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xử lý dữ liệu từ bảng Thủ thư: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }

    public void loadCbbDocGia() {
        cbb_maDocGia.removeAllItems();
        try {
            List<String> docGiaList = PhieuMuonBUS.load_cbb_docGiaData();
            for (String tenDocGia : docGiaList) {
                cbb_maDocGia.addItem(tenDocGia);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xử lý dữ liệu từ bảng Độc giả: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void loadTBL_Search(String Search) {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mã phiếu mượn");
            model.addColumn("Tên thủ thư");
            model.addColumn("Tên độc giả");
            model.addColumn("Ngày mượn");
            model.addColumn("Ngày hẹn trả");
            model.addColumn("Ngày trả");
            model.addColumn("Trạng thái");

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

            List<PhieuMuon> PhieuMuonList = PhieuMuonBUS.loadTableDataSearch(Search);

            // Kiểm tra nếu danh sách trả về rỗng
            if (PhieuMuonList == null || PhieuMuonList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            for (PhieuMuon pm : PhieuMuonList) {
                int ma_PM = pm.getMa_phieu_muon();
                String thu_thu = PhieuMuonBUS.getThuThuById(pm.getMa_thu_thu());
                String doc_gia = PhieuMuonBUS.getDocGiaById(pm.getMa_doc_gia());

                // Xử lý ngày mượn (ngayMuon) - Kiểm tra nếu khác null trước khi định dạng
                Date ngayMuon = pm.getNgay_muon();
                String ngayMuonFormatted = (ngayMuon != null) ? dateFormatter.format(ngayMuon) : "N/A";

                // Xử lý ngày hẹn trả (ngayHenTra) - Kiểm tra nếu khác null trước khi định dạng
                Date ngayHenTra = pm.getNgay_hen_tra();
                String ngayHenTraFormatted = (ngayHenTra != null) ? dateFormatter.format(ngayHenTra) : "N/A"; // N/A: Not avaialbe(Không khả dụng)

                // Xử lý ngày trả (ngayTra) - Định dạng nếu có, nếu không thì hiển thị "Chưa trả"
                Date ngayTra = pm.getNgay_tra();
                String ngayTraFormatted = (ngayTra != null) ? dateFormatter.format(ngayTra) : ""; // Nếu null, hiển thị "Chưa trả"

                // Xác định trạng thái dựa trên ngày trả
                String trangThai = (ngayTra == null) ? "Đang mượn" : "Đã trả";

                model.addRow(new Object[]{
                    ma_PM,
                    thu_thu,
                    doc_gia,
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
    }

    private void clearForm() {
        txt_maMuon.setText("");
        txt_ngayMuon.setText("");
        txt_ngayHen.setText("");
        txt_ngayTra.setText("");
        cbb_maThuThu.setSelectedIndex(0);
        cbb_maDocGia.setSelectedIndex(0);
        cbb_trangThai.setSelectedIndex(0);
    }

    private boolean validateForm() {
        String mes = "";

        // Kiểm tra mã mượn
        if (txt_maMuon.getText().trim().isEmpty()) {
            mes += " Mã mượn";
            txt_maMuon.requestFocus();
        }

        // Kiểm tra ngày mượn
        if (txt_ngayMuon.getText().trim().isEmpty()) {
            mes += " Ngày mượn";
            txt_ngayMuon.requestFocus();
        } else if (!isValidDate(txt_ngayMuon.getText())) {
            mes += " Ngày mượn không hợp lệ. Định dạng đúng là yyyy-MM-dd.\n";
            txt_ngayMuon.requestFocus();
        }

        // Kiểm tra ngày hẹn trả
        if (txt_ngayHen.getText().trim().isEmpty()) {
            mes += " Ngày hẹn";
            txt_ngayHen.requestFocus();
        } else if (!isValidDate(txt_ngayHen.getText())) {
            mes += " Ngày hẹn trả không hợp lệ. Định dạng đúng là yyyy-MM-dd.\n";
            txt_ngayHen.requestFocus();
        }

        // Nếu có lỗi, hiển thị thông báo và trả về false
        if (!mes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không để trống: " + mes, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        return true; // Form hợp lệ
    }

// Hàm kiểm tra định dạng ngày
    private boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false); // Không chấp nhận ngày không hợp lệ (ví dụ: 2022-02-30)
        try {
            sdf.parse(date); // Thử parse chuỗi ngày
            return true;
        } catch (ParseException e) {
            return false;
        }
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
        jLabel1 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_xoa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_ngayHen = new javax.swing.JTextField();
        txt_timkiem = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_maCTPM = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTB_phieuMuon = new javax.swing.JTable();
        btn_themCTPM = new javax.swing.JButton();
        btn_xoaCTPM = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cbb_trangThai = new javax.swing.JComboBox<>();
        cbb_tenSach = new javax.swing.JComboBox<>();
        cbb_maThuThu = new javax.swing.JComboBox<>();
        cbb_maDocGia = new javax.swing.JComboBox<>();
        txt_maSach = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_inExcel = new javax.swing.JButton();
        jMenuBar_sach = new javax.swing.JMenuBar();
        menu_Sach = new javax.swing.JMenu();
        menu_thuThu = new javax.swing.JMenu();
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
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã CTPM", "Mã sách", "Tên sách"
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

        jLabel7.setText("Mã CTPM:");

        jLabel11.setText("Tên sách:");

        jTB_phieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã mượn", "Tên thủ thư", "Tên độc giả", "Ngày mượn", "Ngày hẹn trả", "Ngày trả", "Trạng thái"
            }
        ));
        jTB_phieuMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTB_phieuMuonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTB_phieuMuon);

        btn_themCTPM.setText("Thêm");
        btn_themCTPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themCTPMActionPerformed(evt);
            }
        });

        btn_xoaCTPM.setText("Xóa");
        btn_xoaCTPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaCTPMActionPerformed(evt);
            }
        });

        jLabel12.setText("Trạng thái: ");

        cbb_tenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_tenSachActionPerformed(evt);
            }
        });

        jLabel8.setText("Mã sách:");

        btn_inExcel.setText("In");
        btn_inExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inExcelActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(78, 78, 78)
                                    .addComponent(btn_them)
                                    .addGap(47, 47, 47)
                                    .addComponent(btn_sua)
                                    .addGap(33, 33, 33)
                                    .addComponent(btn_xoa)
                                    .addGap(36, 36, 36)
                                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(btn_timkiem)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_inExcel))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(76, 76, 76)
                                                .addComponent(cbb_maThuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(50, 50, 50)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txt_ngayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_maMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(76, 76, 76)
                                                .addComponent(cbb_maDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel7)
                                                    .addGap(83, 83, 83))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel11)
                                                    .addGap(85, 85, 85)))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cbb_tenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_maCTPM, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(167, 167, 167)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel12))
                                            .addGap(50, 50, 50)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txt_ngayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_ngayHen, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbb_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btn_xoaCTPM)
                                                .addComponent(btn_themCTPM))
                                            .addGap(26, 26, 26)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(485, 485, 485)
                        .addComponent(jLabel8)
                        .addGap(36, 36, 36)
                        .addComponent(txt_maSach, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbb_maThuThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbb_maDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ngayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_them)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_xoa)
                            .addComponent(btn_sua)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_timkiem)
                        .addComponent(btn_inExcel)))
                .addGap(222, 222, 222)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_maCTPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btn_themCTPM)
                    .addComponent(txt_maSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(btn_xoaCTPM)
                    .addComponent(cbb_tenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(227, 227, 227)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(367, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        try {
            if (validateForm()) {
                String ngayMuonStr = txt_ngayMuon.getText().trim();
                String ngayTraStr = txt_ngayTra.getText().trim();

                // Gọi phương thức validateDates để kiểm tra ngày mượn và ngày trả
                if (!validateDates(ngayMuonStr, ngayTraStr)) {
                    return; // Nếu kiểm tra không thành công, dừng thực hiện
                }

                PhieuMuon pm = new PhieuMuon(
                        Integer.parseInt(txt_maMuon.getText()), // Cập nhật dựa trên mã phiếu mượn
                        cbb_maThuThu.getSelectedIndex() + 1,
                        cbb_maDocGia.getSelectedIndex() + 1,
                        java.sql.Date.valueOf(txt_ngayMuon.getText()), // Chuyển đổi sang kiểu Date
                        java.sql.Date.valueOf(txt_ngayHen.getText()),
                        !ngayTraStr.isEmpty() ? java.sql.Date.valueOf(ngayTraStr) : null,
                        cbb_trangThai.getSelectedIndex()
                );

                PhieuMuonBUS.capNhatPM(pm);

                // Thông báo thêm thành công
                JOptionPane.showMessageDialog(null, "Cập nhật phiếu mượn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                Load();
                clearForm();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cập nhật phiếu mượn thất bại! Vui lòng kiểm tra dữ liệu đầu vào.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void jTB_CTPMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_CTPMMouseClicked
        int currentCTPM = jTB_CTPM.getSelectedRow();
        txt_maCTPM.setText(String.valueOf(jTB_CTPM.getValueAt(currentCTPM, 0)));
        txt_maSach.setText(String.valueOf((int) jTB_CTPM.getValueAt(currentCTPM, 1)));

        // xử lý comboBox tên sách
        jTB_CTPM.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = jTB_CTPM.getSelectedRow();

                if (selectedRow != -1) {
                    // Lấy dữ liệu trạng thái từ bảng
                    String tenSach = jTB_CTPM.getValueAt(selectedRow, 2).toString();

                    // Cập nhật ComboBox tenSach
                    cbb_tenSach.setSelectedItem(tenSach);
                }
            }
        });

    }//GEN-LAST:event_jTB_CTPMMouseClicked

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        String search = txt_timkiem.getText().trim(); //  Loại bỏ khoảng trắng đầu và cuối chuỗi
        if (search.isEmpty()) {
            Load();
            JOptionPane.showMessageDialog(null, "Chưa có dữ liệu tìm kiếm đầu vào", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            loadTBL_Search(search);

            if (jTB_phieuMuon.getRowCount() == 0) { // Kiểm tra nếu bảng không có dữ liệu
                JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả nào phù hợp", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

    public boolean validateDates(String ngayMuonStr, String ngayTraStr) {
        // Định dạng ngày
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            // Chuyển chuỗi ngày mượn thành LocalDate
            LocalDate ngayMuon = LocalDate.parse(ngayMuonStr, formatter);

            // Nếu ngày trả không rỗng, thực hiện kiểm tra
            if (!ngayTraStr.trim().isEmpty()) {
                LocalDate ngayTra = LocalDate.parse(ngayTraStr, formatter);

                // Kiểm tra nếu ngày mượn > ngày trả
                if (ngayMuon.isAfter(ngayTra)) {
                    JOptionPane.showMessageDialog(null, "Ngày mượn không thể lớn hơn ngày trả!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Định dạng ngày không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true; // Kiểm tra thành công
    }


    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed

        try {
            if (validateForm()) {
                String ngayMuonStr = txt_ngayMuon.getText().trim();
                String ngayTraStr = txt_ngayTra.getText().trim();

                // Gọi phương thức validateDates để kiểm tra ngày mượn và ngày trả
                if (!validateDates(ngayMuonStr, ngayTraStr)) {
                    return; // Nếu kiểm tra không thành công, dừng thực hiện
                }
                // Tạo đối tượng PhieuMuon
                PhieuMuon pm = new PhieuMuon(
                        Integer.parseInt(txt_maMuon.getText()),
                        cbb_maThuThu.getSelectedIndex() + 1,
                        cbb_tenSach.getSelectedIndex() + 1,
                        java.sql.Date.valueOf(ngayMuonStr), // Chuyển đổi sang kiểu Date
                        java.sql.Date.valueOf(txt_ngayHen.getText()),
                        !ngayTraStr.isEmpty() ? java.sql.Date.valueOf(ngayTraStr) : null,
                        cbb_trangThai.getSelectedIndex()
                );

                PhieuMuonBUS.themPM(pm);

                // Thông báo thêm thành công
                JOptionPane.showMessageDialog(null, "Thêm phiếu mượn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                Load();
                clearForm();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Thêm phiếu mượn thất bại! Vui lòng kiểm tra dữ liệu đầu vào.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        try {
            if (PhieuMuonDAL.checkEmpty(txt_maMuon.getText())) {
                int maPhieuMuon = Integer.parseInt(txt_maMuon.getText());

                PhieuMuonBUS.xoaPM(maPhieuMuon);
                JOptionPane.showMessageDialog(null, "Xóa phiếu mượn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                Load();
                clearForm();
            }else{
                JOptionPane.showMessageDialog(null, "Không thể xóa! Phiếu mượn còn tồn tại chi tiết phiếu mượn", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Mã phiếu mượn không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xóa phiếu mượn thất bại! Vui lòng kiểm tra lại mã phiếu mươn", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void jTB_phieuMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTB_phieuMuonMouseClicked

        // Lấy hàng hiện tại
        int current = jTB_phieuMuon.getSelectedRow();

// Điền dữ liệu vào các JTextField
        txt_maMuon.setText(String.valueOf(jTB_phieuMuon.getValueAt(current, 0)));

// Lấy mã thủ thư từ bảng (cột 1)
        String maThuThu = (String.valueOf(jTB_phieuMuon.getValueAt(current, 1)));

// Duyệt qua các mục trong cbb_maThuThu để tìm item khớp với mã thủ thư
        for (int i = 0; i < cbb_maThuThu.getItemCount(); i++) {
            if (cbb_maThuThu.getItemAt(i).toString().equals(maThuThu)) {
                cbb_maThuThu.setSelectedIndex(i);
                break;
            }
        }

// Lấy mã độc giả từ bảng (cột 2)
        String maDocGia = (String.valueOf(jTB_phieuMuon.getValueAt(current, 2)));

        // Duyệt qua các mục trong cbb_maDocGia1 để tìm item khớp với mã độc giả
        for (int i = 0; i < cbb_maDocGia.getItemCount(); i++) {
            if (cbb_maDocGia.getItemAt(i).toString().equals(maDocGia)) {
                cbb_maDocGia.setSelectedIndex(i);
                break;
            }
        }

        txt_ngayMuon.setText(String.valueOf(jTB_phieuMuon.getValueAt(current, 3)));
        txt_ngayHen.setText(String.valueOf(jTB_phieuMuon.getValueAt(current, 4)));
        txt_ngayTra.setText(String.valueOf(jTB_phieuMuon.getValueAt(current, 5)));

        //load data table CTPM
        loadCTPM(Integer.parseInt(txt_maMuon.getText()));
        txt_maCTPM.setEditable(false);
        txt_maCTPM.setEnabled(false);

    }//GEN-LAST:event_jTB_phieuMuonMouseClicked

    public boolean valiDateFormCTPM(){
        String mes = "";
        // Kiểm tra mã ctpm 
        if (txt_maMuon.getText().trim().isEmpty()) {
            mes += " Mã mượn";
            txt_maMuon.requestFocus();
        }
        if (!mes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không để trống: " + mes, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        return true; // Form hợp lệ
    }
    
    private void btn_themCTPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themCTPMActionPerformed
        try {
            if (valiDateFormCTPM()) {
                // Lấy mã phiếu mượn từ form
            int maPM = Integer.parseInt(txt_maMuon.getText());
            CTPM ctpm = new CTPM(
                    Integer.parseInt(txt_maMuon.getText()),
                    Integer.parseInt(txt_maSach.getText())
            );
            ChiTietPMBUS.themCTPM(ctpm);

            JOptionPane.showMessageDialog(null, "Thêm chi tiết phiếu mượn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            loadCTPM(maPM);
            clearForm();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Thêm chi tiết phiếu mượn thất bại! Vui lòng kiểm tra dữ liệu đầu vào.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_themCTPMActionPerformed

    private void btn_xoaCTPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaCTPMActionPerformed
        try {
            int maCTPM = Integer.parseInt(txt_maCTPM.getText());

            ChiTietPMBUS.xoaCTPM(maCTPM);

            JOptionPane.showMessageDialog(null, "Xóa chi tiết phiếu mượn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            loadCTPM(maCTPM);
            clearForm();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xóa chi tiết phiếu mượn thất bại! Vui lòng kiểm tra dữ liệu đầu vào.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_xoaCTPMActionPerformed

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

    private void cbb_tenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_tenSachActionPerformed

    }//GEN-LAST:event_cbb_tenSachActionPerformed

    private void btn_inExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inExcelActionPerformed
//        try {
//            XSSFWorkbook wordkbook = new XSSFWorkbook();
//            XSSFSheet sheet = wordkbook.createSheet("danhsach");
//            XSSFRow row = null;
//            Cell cell = null;
//
//            // Dòng tiêu đề
//            row = sheet.createRow(2);
//            cell = row.createCell(0, CellType.STRING);
//            cell.setCellValue("Danh sách phiếu mượn");
//
//            // Dòng tiêu đề các cột
//            row = sheet.createRow(3);
//            cell = row.createCell(0, CellType.STRING);
//            cell.setCellValue("STT");
//
//            cell = row.createCell(1, CellType.STRING);
//            cell.setCellValue("Mã phiếu mượn");
//
//            cell = row.createCell(2, CellType.STRING);
//            cell.setCellValue("Mã thủ thư");
//
//            cell = row.createCell(3, CellType.STRING);
//            cell.setCellValue("Mã độc giả");
//
//            cell = row.createCell(4, CellType.STRING);
//            cell.setCellValue("Ngày mượn");
//
//            cell = row.createCell(5, CellType.STRING);
//            cell.setCellValue("Ngày hẹn trả");
//
//            cell = row.createCell(6, CellType.STRING);
//            cell.setCellValue("Ngày trả");
//
//            cell = row.createCell(7, CellType.STRING);
//            cell.setCellValue("Trạng thái");
//
//            // Điền dữ liệu vào các hàng
//            for (int i = 0; i < lst_tbl.size(); i++) {
//                PhieuMuon pm = lst_tbl.get(i);
//                row = sheet.createRow(4 + i);
//
//                cell = row.createCell(0, CellType.NUMERIC);
//                cell.setCellValue(i + 1);
//
//                cell = row.createCell(1, CellType.STRING);
//                cell.setCellValue(pm.getMa_phieu_muon());
//
//                String tenThuThu = PhieuMuonDAL.getThuThuById(pm.getMa_thu_thu());
//                cell = row.createCell(2, CellType.STRING);
//                cell.setCellValue(tenThuThu);
//
//                String tenDocGia = PhieuMuonDAL.getDocGiaById(pm.getMa_doc_gia());
//                cell = row.createCell(3, CellType.STRING);
//                cell.setCellValue(tenDocGia);
//
//                cell = row.createCell(4, CellType.STRING);
//                cell.setCellValue(dateFormat.format(pm.getNgay_muon()));
//
//                cell = row.createCell(5, CellType.STRING);
//                cell.setCellValue(dateFormat.format(pm.getNgay_hen_tra()));
//
//                // Kiểm tra null cho ngày trả (ngay_tra)
//                if (pm.getNgay_tra() != null) {
//                    cell = row.createCell(6, CellType.STRING);
//                    cell.setCellValue(dateFormat.format(pm.getNgay_tra()));
//                } else {
//                    cell = row.createCell(6, CellType.STRING);
//                    cell.setCellValue("");  // Đặt giá trị rỗng nếu ngay_tra là null
//                }
//
//                cell = row.createCell(7, CellType.STRING);
//                cell.setCellValue(pm.getTrang_thai() == 1 ? "Đã trả" : "Chưa trả");
//
//            }
//            // Sử dụng JFileChooser để chọn vị trí lưu file
//            JFileChooser fileChooser = new JFileChooser();
//            fileChooser.setDialogTitle("Chọn vị trí lưu file");
//            fileChooser.setSelectedFile(new File("danhsach.xlsx")); // Đặt tên file mặc định
//
//            int userSelection = fileChooser.showSaveDialog(this); // Hiển thị hộp thoại lưu file
//
//            if (userSelection == JFileChooser.APPROVE_OPTION) {
//                File fileToSave = fileChooser.getSelectedFile();
//
//                // Ghi dữ liệu vào file
//                try (FileOutputStream fis = new FileOutputStream(fileToSave)) {
//                    wordkbook.write(fis);
//                    fis.close();
//                    JOptionPane.showMessageDialog(this, "In ra file Excel thành công tại: " + fileToSave.getAbsolutePath());
//                } catch (FileNotFoundException ex) {
//                    ex.printStackTrace();
//                    JOptionPane.showMessageDialog(this, "File không thể mở hoặc ghi.");
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                    JOptionPane.showMessageDialog(this, "Lỗi khi ghi file.");
//                }
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Lỗi mở file");
//        }
    }//GEN-LAST:event_btn_inExcelActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fMuonTra muonTraFrame = new fMuonTra();
                muonTraFrame.setDefaultCloseOperation(fMuonTra.EXIT_ON_CLOSE);
                muonTraFrame.setLocationRelativeTo(null);
                muonTraFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_inExcel;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_themCTPM;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton btn_xoaCTPM;
    private javax.swing.JComboBox<String> cbb_maDocGia;
    private javax.swing.JComboBox<String> cbb_maThuThu;
    private javax.swing.JComboBox<String> cbb_tenSach;
    private javax.swing.JComboBox<String> cbb_trangThai;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JMenu menu_muonTra;
    private javax.swing.JMenu menu_qlDocGia;
    private javax.swing.JMenu menu_qlTacGia;
    private javax.swing.JMenu menu_qlTheLoai;
    private javax.swing.JMenu menu_thongKe;
    private javax.swing.JMenu menu_thuThu;
    private javax.swing.JTextField txt_maCTPM;
    private javax.swing.JTextField txt_maMuon;
    private javax.swing.JTextField txt_maSach;
    private javax.swing.JTextField txt_ngayHen;
    private javax.swing.JTextField txt_ngayMuon;
    private javax.swing.JTextField txt_ngayTra;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
