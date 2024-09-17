package DAL;

<<<<<<< HEAD
=======
import DTO.DocGia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
>>>>>>> 2a97e38fdb1adf9c827f454c43c45c7fdd638a78
public class DocGiaDAL {

    public static List<DocGia> loadTbaleData() {
        List<DocGia> lst_tbl = new ArrayList<>();
        String sqlQuery = "SELECT * FROM DOC_GIA";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                DocGia dg = new DocGia();
                dg.setMa_doc_gia(res.getInt("ma_doc_gia"));
                dg.setTen_doc_gia(res.getString("ten_doc_gia"));
                dg.setNgay_sinh(res.getDate("ngay_sinh"));
                dg.setDia_chi(res.getString("dia_chi"));
                dg.setCmnd(res.getString("cmnd"));
                dg.setSdt(res.getString("sdt"));

                lst_tbl.add(dg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_tbl;
    }

    public static List<DocGia> loadTbaleDataSearch(String keyword) {
        List<DocGia> lst_tbl = new ArrayList<>();

        String sqlQuery = "SELECT * \n"
                + "FROM DOC_GIA \n"
                + "WHERE CAST(ma_doc_gia AS NVARCHAR) LIKE ? \n"
                + "  OR ten_doc_gia LIKE ? \n"
                + "  OR CAST(ngay_sinh AS NVARCHAR) LIKE ? \n"
                + "  OR dia_chi LIKE ? \n"
                + "  OR cmnd LIKE ? \n"
                + "  OR sdt LIKE ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            for (int i = 1; i <= 6; i++) {
                ps.setString(i, "%" + keyword + "%");
            }
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                DocGia dg = new DocGia();
                dg.setMa_doc_gia(res.getInt("ma_doc_gia"));
                dg.setTen_doc_gia(res.getString("ten_doc_gia"));
                dg.setNgay_sinh(res.getDate("ngay_sinh"));
                dg.setDia_chi(res.getString("dia_chi"));
                dg.setCmnd(res.getString("cmnd"));
                dg.setSdt(res.getString("sdt"));

                lst_tbl.add(dg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_tbl;
    }

    public static void them(DocGia dg) {
        String sqlQuery = "INSERT INTO DOC_GIA (ma_doc_gia, ten_doc_gia, ngay_sinh, dia_chi, cmnd, sdt) VALUES\n"
                + "(?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

            // Thiết lập các tham số từ đối tượng `Sach`
            ps.setInt(1, dg.getMa_doc_gia());
            ps.setString(2, dg.getTen_doc_gia());
            ps.setDate(3, java.sql.Date.valueOf(dg.getNgay_sinh().toString()));
            ps.setString(4, dg.getDia_chi());
            ps.setString(5, dg.getCmnd());
            ps.setString(6, dg.getSdt());
            ps.executeUpdate();
            System.out.println("Thêm sách thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void capNhat(DocGia dg) {
        String sqlQuery = "UPDATE DOC_GIA SET ten_doc_gia = ?, ngay_sinh = ? , dia_chi = ?,  cmnd = ?, sdt = ? WHERE ma_doc_gia = ?";
        

        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

            // Thiết lập các tham số từ đối tượng `Sach`
            ps.setInt(6, dg.getMa_doc_gia());
            ps.setString(1, dg.getTen_doc_gia());
            ps.setDate(2, java.sql.Date.valueOf(dg.getNgay_sinh().toString()));
            ps.setString(3, dg.getDia_chi());
            ps.setString(4, dg.getCmnd());
            ps.setString(5, dg.getSdt());

            // Thực thi truy vấn
            ps.executeUpdate();
            System.out.println("Cập nhật sách thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void xoa(int maDG) {
        String sqlQuery = "DELETE FROM DOC_GIA WHERE ma_doc_gia = ?";

        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, maDG); // Thiết lập tham số là mã sách muốn xóa

            // Thực thi câu lệnh xóa
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Xóa sách thành công!");
            } else {
                System.out.println("Không tìm thấy sách với mã: " + maDG);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
