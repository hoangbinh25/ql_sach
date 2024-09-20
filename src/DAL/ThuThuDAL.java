package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import DTO.ThuThu;

public class ThuThuDAL {

    public static List<ThuThu.CTThuThu> LoadTBDATA() {
        String sqlQuery = "SELECT * FROM THU_THU";
        List<ThuThu.CTThuThu> lst_tbl = new ArrayList<>();
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                ThuThu.CTThuThu tt = new ThuThu.CTThuThu();
                tt.setMa_thu_thu(res.getInt("ma_thu_thu"));
                tt.setTen_thu_thu(res.getString("ten_thu_thu"));
                tt.setCmnd(res.getString("cmnd"));
                tt.setSdt(res.getString("sdt"));
                tt.setEmail(res.getString("email"));
                tt.setPassword(res.getString("password"));

                lst_tbl.add(tt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst_tbl;
    }

    public static List<ThuThu.CTThuThu> LoadtTbDATA_Search(String keyword) {
        String sqlQuery = "SELECT *\n"
                + "FROM THU_THU\n"
                + "WHERE ten_thu_thu LIKE @searchString\n"
                + "   OR cmnd LIKE @searchString\n"
                + "   OR sdt LIKE @searchString\n"
                + "   OR email LIKE @searchString\n"
                + "   OR password LIKE @searchString";
        List<ThuThu.CTThuThu> lst_tbl = new ArrayList<>();
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            for (int i = 1; i <= 5; i++) {
                ps.setString(i, keyword);
            }

            ResultSet res = ps.executeQuery();

            while (res.next()) {
                ThuThu.CTThuThu tt = new ThuThu.CTThuThu();
                tt.setMa_thu_thu(res.getInt("ma_thu_thu"));
                tt.setTen_thu_thu(res.getString("ten_thu_thu"));
                tt.setCmnd(res.getString("cmnd"));
                tt.setSdt(res.getString("sdt"));
                tt.setEmail(res.getString("email"));
                tt.setPassword(res.getString("password"));

                lst_tbl.add(tt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_tbl;
    }

    public static void them(ThuThu tt) {
        String sqlQuery = "INSERT INTO THU_THU (ten_thu_thu, cmnd, sdt, email, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareCall(sqlQuery);
            ps.setString(1, tt.getTen_thu_thu());
            ps.setString(2, tt.getCmnd());
            ps.setString(3, tt.getSdt());
            ps.setString(4, tt.getEmail());
            ps.setString(5, tt.getPassword());

            ps.executeUpdate();
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sua(ThuThu.CTThuThu cttt) {
        String sqlQuery = "UPDATE THU_THU\n"
                + "SET ten_thu_thu = ?,\n"
                + "    cmnd = ?,\n"
                + "    sdt = ?,\n"
                + "    email = ?,\n"
                + "    password = ?\n"
                + "WHERE ma_thu_thu = ?;";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareCall(sqlQuery);
            ps.setString(1, cttt.getTen_thu_thu());
            ps.setString(2, cttt.getCmnd());
            ps.setString(3, cttt.getSdt());
            ps.setString(4, cttt.getEmail());
            ps.setString(5, cttt.getPassword());
            ps.setInt(6, cttt.getMa_thu_thu());

            ps.executeUpdate();
            System.out.println("Sửa thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void xoa(int ma) {
        String sqlQuery = "DELETE FROM THU_THU WHERE ma_thu_thu = ?";
        
        try (Connection conn = ConnectToSQLServer.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, ma);
            ps.executeUpdate();
            
            System.out.println("Xóa thành công");
        } catch (Exception e) {
        }
    }
}
