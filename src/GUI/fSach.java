/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Class.ConnectToSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory;
import Class.Sach;
import Class.TheLoai;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author admin
 */
public class fSach extends javax.swing.JFrame {

    /**
     * Creates new form fSach
     */
    public fSach() {
        initComponents();
        loadData();
    }

    private void loadData() {
        loadTacGiaData();
        loadTheLoaiData();
        loadNhaXBData();
        loadTbaleData();
    }

    private void loadTacGiaData() {
        String sqlQuery = "SELECT * FROM TacGia";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet res = ps.executeQuery();

            jComboBox_tacGia.removeAllItems();
            jComboBox_tacGia.addItem("Chon 1");
            while (res.next()) {
                String tenTacGia = res.getString("ten_tac_gia");
                jComboBox_tacGia.addItem(tenTacGia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadTheLoaiData() {
        String sqlQuery = "SELECT * FROM TheLoai";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet res = ps.executeQuery();

            jComboBox_theLoai.removeAllItems();
            jComboBox_theLoai.addItem("Chon 1");
            while (res.next()) {
                String tenTheLoai = res.getString("ten_the_loai");
                jComboBox_theLoai.addItem(tenTheLoai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadNhaXBData() {
        String sqlQuery = "SELECT * FROM NhaXuatBan";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet res = ps.executeQuery();
            jComboBox_nhaXB.removeAllItems();
            jComboBox_nhaXB.addItem("Chon 1");
            while (res.next()) {
                String tenNhaXB = res.getString("ten_nxb");
                jComboBox_nhaXB.addItem(tenNhaXB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadTbaleData() {
        String sqlQuery = "SELECT * FROM Sach";
    try (Connection conn = ConnectToSQLServer.getConnection()) {
        PreparedStatement ps = conn.prepareStatement(sqlQuery);
        ResultSet res = ps.executeQuery();

        // Khởi tạo mô hình dữ liệu cho bảng
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã Sách");
        model.addColumn("Tên Sách");
        model.addColumn("Tác Giả");
        model.addColumn("Thể Loại");
        model.addColumn("Nhà XB");
        model.addColumn("Năm Sản Xuất");

        // Định dạng ngày tháng theo kiểu yyyy-MM-dd
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

        // Đọc dữ liệu từ ResultSet và thêm vào mô hình dữ liệu
        while (res.next()) {
            int maSach = res.getInt("ma_sach");
            String tenSach = res.getString("ten_sach");
            String tacGia = getTacGiaById(res.getInt("ma_tac_gia")); // Lấy tên tác giả từ ID
            String theLoai = getTheLoaiById(res.getInt("ma_the_loai")); // Lấy tên thể loại từ ID
            String nhaXB = getNhaXBById(res.getInt("ma_nxb")); // Lấy tên nhà xuất bản từ ID
            
            // Chuyển đổi "Năm Sản Xuất" từ Date sang định dạng yyyy-MM-dd
            Date namSX = res.getDate("nam_xuat_ban");
            String namSXFormatted = dateFormatter.format(namSX); // Định dạng ngày tháng
            
            // Thêm dữ liệu vào mô hình của bảng
            model.addRow(new Object[]{maSach, tenSach, tacGia, theLoai, nhaXB, namSXFormatted});
        }

        // Cập nhật JTable với mô hình dữ liệu
        jTB_sach.setModel(model);

    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    private String getTacGiaById(int id) {
        String sqlQuery = "SELECT ten_tac_gia FROM TacGia WHERE ma_tac_gia = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                return res.getString("ten_tac_gia");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getTheLoaiById(int id) {
        String sqlQuery = "SELECT ten_the_loai FROM TheLoai WHERE ma_the_loai = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                return res.getString("ten_the_loai");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getNhaXBById(int id) {
        String sqlQuery = "SELECT ten_nxb FROM NhaXuatBan WHERE ma_nxb = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                return res.getString("ten_nxb");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_xoa = new javax.swing.JButton();
        txt_namSX = new javax.swing.JTextField();
        txt_timkiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTB_sach = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_tacGia = new javax.swing.JComboBox<>();
        txt_tensach = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_theLoai = new javax.swing.JComboBox<>();
        btn_them = new javax.swing.JButton();
        jComboBox_nhaXB = new javax.swing.JComboBox<>();
        btn_timkiem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_sua = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar_sach = new javax.swing.JMenuBar();
        menu_Sach = new javax.swing.JMenu();
        menu_theLoai = new javax.swing.JMenu();
        menu_tacGia = new javax.swing.JMenu();
        menu_nhaXB = new javax.swing.JMenu();
        menu_khoSach = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sách");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_xoa.setText("Xóa");
        getContentPane().add(btn_xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));
        getContentPane().add(txt_namSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 371, -1));
        getContentPane().add(txt_timkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 217, -1));

        jTB_sach.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTB_sach);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 816, 278));

        jLabel1.setText("Tên Sách: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 61, -1));

        jLabel2.setText("Tác Giả: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 61, -1));

        jComboBox_tacGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_tacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 210, -1));
        getContentPane().add(txt_tensach, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 371, -1));

        jLabel3.setText("Thể Loại:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 61, -1));

        jComboBox_theLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_theLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_theLoaiActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_theLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 210, -1));

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        getContentPane().add(btn_them, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jComboBox_nhaXB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_nhaXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_nhaXBActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_nhaXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 370, -1));

        btn_timkiem.setText("Tìm Kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });
        getContentPane().add(btn_timkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, -1, -1));

        jLabel4.setText("Nhà XB: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 50, -1));

        btn_sua.setText("Sửa");
        getContentPane().add(btn_sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        jLabel5.setText("Năm Sản Xuất: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 93, -1));

        menu_Sach.setText("Sách");
        jMenuBar_sach.add(menu_Sach);

        menu_theLoai.setText("Thể Loại");
        menu_theLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_theLoaiMouseClicked(evt);
            }
        });
        menu_theLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_theLoaiActionPerformed(evt);
            }
        });
        jMenuBar_sach.add(menu_theLoai);

        menu_tacGia.setText("Tác Giả");
        menu_tacGia.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                menu_tacGiaMenuSelected(evt);
            }
        });
        menu_tacGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_tacGiaMouseClicked(evt);
            }
        });
        menu_tacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_tacGiaActionPerformed(evt);
            }
        });
        jMenuBar_sach.add(menu_tacGia);

        menu_nhaXB.setText("Nhà XB");
        menu_nhaXB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_nhaXBMouseClicked(evt);
            }
        });
        menu_nhaXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_nhaXBActionPerformed(evt);
            }
        });
        jMenuBar_sach.add(menu_nhaXB);

        menu_khoSach.setText("Kho Sách");
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

        setJMenuBar(jMenuBar_sach);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void menu_theLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_theLoaiActionPerformed

    }//GEN-LAST:event_menu_theLoaiActionPerformed

    private void menu_tacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_tacGiaActionPerformed

    }//GEN-LAST:event_menu_tacGiaActionPerformed

    private void menu_nhaXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_nhaXBActionPerformed

    }//GEN-LAST:event_menu_nhaXBActionPerformed

    private void menu_khoSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_khoSachActionPerformed

    }//GEN-LAST:event_menu_khoSachActionPerformed

    private void menu_tacGiaMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_menu_tacGiaMenuSelected

    }//GEN-LAST:event_menu_tacGiaMenuSelected

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

    private void menu_khoSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_khoSachMouseClicked
        fKhoSach khoSachFrame = new fKhoSach();
        khoSachFrame.setDefaultCloseOperation(fKhoSach.EXIT_ON_CLOSE);
        khoSachFrame.setLocationRelativeTo(null);
        khoSachFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_khoSachMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        Sach sach = new Sach();
        sach.setTen_sach(txt_tensach.getText());
        sach.setMa_tacgia(jComboBox_tacGia.getSelectedIndex());
        sach.setMa_theloai(jComboBox_theLoai.getSelectedIndex());
        sach.setMa_nhaXB(jComboBox_nhaXB.getSelectedIndex());

        // Chuyển đổi chuỗi sang kiểu ngày tháng cho năm xuất bản
        try {
            String dateString = txt_namSX.getText(); // Lấy chuỗi ngày tháng từ TextField
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng chuỗi ngày tháng
            Date namXB = formatter.parse(dateString); // Chuyển đổi chuỗi thành đối tượng Date
            sach.setNamXB(namXB); // Thiết lập năm xuất bản cho đối tượng Sach
        } catch (Exception e) {
            System.out.println("Lỗi: Định dạng ngày tháng không hợp lệ. Vui lòng nhập đúng định dạng yyyy-MM-dd.");
            return; // Kết thúc phương thức nếu có lỗi
        }

        // Chuẩn bị câu truy vấn SQL
        String sqlQuery = "INSERT INTO Sach (ten_sach, ma_tac_gia, ma_the_loai, ma_nxb, nam_xuat_ban) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectToSQLServer.getConnection()) {
            // Tạo PreparedStatement để thực thi câu truy vấn
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

            // Thiết lập giá trị cho các tham số
            ps.setString(1, sach.getTen_sach());
            ps.setInt(2, sach.getMa_tacgia());
            ps.setInt(3, sach.getMa_theloai());
            ps.setInt(4, sach.getMa_nhaXB());
            ps.setDate(5, new java.sql.Date(sach.getNamXB().getTime())); // Chuyển đổi Date sang java.sql.Date

            // Thực thi câu truy vấn
            int rowsAffected = ps.executeUpdate();

            // Kiểm tra xem việc thêm dữ liệu có thành công hay không
            if (rowsAffected > 0) {
                System.out.println("Thêm sách thành công!");
                loadData();
            } else {
                System.out.println("Thêm sách thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void jComboBox_nhaXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_nhaXBActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jComboBox_nhaXBActionPerformed

    private void jComboBox_theLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_theLoaiActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox_theLoaiActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fSach sachFrame = new fSach();
                sachFrame.setDefaultCloseOperation(fSach.EXIT_ON_CLOSE);
                sachFrame.setLocationRelativeTo(null);
                sachFrame.setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> jComboBox_nhaXB;
    private javax.swing.JComboBox<String> jComboBox_tacGia;
    private javax.swing.JComboBox<String> jComboBox_theLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar_sach;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTB_sach;
    private javax.swing.JMenu menu_Sach;
    private javax.swing.JMenu menu_khoSach;
    private javax.swing.JMenu menu_nhaXB;
    private javax.swing.JMenu menu_tacGia;
    private javax.swing.JMenu menu_theLoai;
    private javax.swing.JTextField txt_namSX;
    private javax.swing.JTextField txt_tensach;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
