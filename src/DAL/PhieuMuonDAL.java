package DAL;

import DTO.PhieuMuon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import GUI.fMuonTra; 

public class PhieuMuonDAL {
    public static List<PhieuMuon> loadTbaleData() {

        List<PhieuMuon> lst_tbl = new ArrayList<>();
        String sqlQuery = "SELECT * FROM PHIEU_MUON";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                PhieuMuon pm = new PhieuMuon();
                pm.setMa_phieu_muon(res.getInt("ma_phieu_muon"));
                pm.setMa_thu_thu(res.getInt("ma_thu_thu"));
                pm.setMa_doc_gia(res.getInt("ma_doc_gia"));
                pm.setNgay_muon(res.getDate("ngay_muon"));
                pm.setNgay_hen_tra(res.getDate("ngay_hen_tra"));
                pm.setNgay_tra(res.getDate("ngay_tra"));
                pm.setTrang_thai(res.getInt("trang_thai"));
                lst_tbl.add(pm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_tbl;
    }
    
    public static void themPM(PhieuMuon pm) {
        String query = "INSERT INTO PHIEU_MUON (ma_phieu_muon, ma_thu_thu, ma_doc_gia, ngay_muon, ngay_hen_tra, ngay_tra, trang_thai) "
               + "VALUES(?, ?, ?, ?, ?, ?, ?)";
       
        try (Connection conn = ConnectToSQLServer.getConnection()){
            PreparedStatement ps = conn.prepareStatement(query);
            
        // Thiết lập tham số từ đối tượng "PHIEU_MUON"
        ps.setInt(1, pm.getMa_phieu_muon());
        ps.setInt(2, pm.getMa_thu_thu());
        ps.setInt(3, pm.getMa_doc_gia());
        ps.setDate(4, java.sql.Date.valueOf(pm.getNgay_muon().toString())); // Chuyển `Date` sang `java.sql.Date`
        ps.setDate(5, java.sql.Date.valueOf(pm.getNgay_hen_tra().toString()));
        ps.setDate(6, java.sql.Date.valueOf(pm.getNgay_tra().toString()));
        ps.setInt(7, pm.getTrang_thai());
        
        // Truy vấn
        ps.executeUpdate();
            System.out.println("Thêm phiếu mượn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
