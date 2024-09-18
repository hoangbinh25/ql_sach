package DAL;

import java.util.*;
import DTO.ChiTietPM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChiTietPMDAL {
    
    public static String getTenSachById(int id) {
        String sqlQuery = "SELECT ten_sach FROM SACH WHERE ma_sach = ?";
        try (Connection conn = ConnectToSQLServer.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                return res.getString("ten_sach");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public static List<ChiTietPM> LoadTbl(int ma){
        String sqlQuery = "SELECT * FROM CHI_TIET_PHIEU_MUON WHERE ma_phieu_muon = ?";
        List<ChiTietPM> lst_tbl = new ArrayList<>();
        try (Connection conn = ConnectToSQLServer.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setInt(1, ma);
            ResultSet res = ps.executeQuery();
            while (res.next()) {                
                ChiTietPM ctpm = new ChiTietPM();
                ctpm.setMa_chi_tiet(res.getInt("ma_chi_tiet"));
                ctpm.setMa_phieu_muon(res.getInt("ma_phieu_muon"));
                ctpm.setMa_sach(res.getInt("ma_sach"));
                lst_tbl.add(ctpm);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_tbl;
    }
}
