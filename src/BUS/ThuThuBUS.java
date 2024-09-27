package BUS;

import DAL.ThuThuDAL;
import DTO.ThuThu;
import java.util.List;

public class ThuThuBUS {
    public static List<ThuThu.CTThuThu> LoadTBDATA() {
        return ThuThuDAL.LoadTBDATA();
    }
    
    public static List<ThuThu.CTThuThu> LoadtTbDATA_Search(String keyword) {
        return ThuThuDAL.LoadtTbDATA_Search(keyword);
    }
    
    public static void them(ThuThu tt) {
        ThuThuDAL.them(tt);
    }
    
    public static void sua(ThuThu.CTThuThu cttt) {
        ThuThuDAL.sua(cttt);
    }
    
    public static void xoa(int ma) {
        ThuThuDAL.xoa(ma);
    }
    
     public static boolean checkEmpty(String id) {
        if (ThuThuDAL.checkEmpty(id)) {
            return false;
        }
        return true;
    }
}
