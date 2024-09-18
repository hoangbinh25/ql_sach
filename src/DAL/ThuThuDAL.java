package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import DTO.ThuThu;
        


public class ThuThuDAL {
    public static List<ThuThu> LoadTBDATA(){
        String sqlQuery = "SELECT * FORM THU_THU";
        List<ThuThu> lst_tbl = new ArrayList<>();
        try (Connection conn = ConnectToSQLServer.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ResultSet res = ps.executeQuery();
            
            while (res.next()) {                
                ThuThu tt = new ThuThu();
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
}
