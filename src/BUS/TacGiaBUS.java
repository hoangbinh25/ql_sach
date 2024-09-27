package BUS;

import DAL.TacGiaDAL;
import DTO.TacGia;
import java.util.List;

public class TacGiaBUS {
    public static List<TacGia> loadTbaleData() {
        return TacGiaDAL.loadTbaleData();
    }
    
    public static List<TacGia> loadTbaleDataSearch(String keyword) {
        return TacGiaDAL.loadTbaleDataSearch(keyword);
    }
    
    public static void them(TacGia tg){
        TacGiaDAL.them(tg);
    }
    
    public static void sua(TacGia tg){
        TacGiaDAL.sua(tg);
    }
    
    public static void xoa(int ma){
        TacGiaDAL.xoa(ma);
    }
    
    public static boolean checkEmpty(String id) {
        if (TacGiaDAL.checkEmpty(id)) {
            return false;
        }
        return true;
    }
}
