package BUS;

import DAL.DocGiaDAL;
import DTO.DocGia;
import java.util.List;

public class DocGiaBUS {
    public static List<DocGia> loadTableData() {
        return DocGiaDAL.loadTableData();
    }
    
    public static List<DocGia> loadTableDataSearch(String keyword) {
        return DocGiaDAL.loadTableDataSearch(keyword);
    }
    
    public static void them(DocGia dg) {
        DocGiaDAL.them(dg);
    }
    
    public static void capNhat(DocGia dg) {
        DocGiaDAL.capNhat(dg);
    }
    
    public static void xoa(int maDG) {
        DocGiaDAL.xoa(maDG);
    }
    
    public static boolean checkEmpty(String id) {
        if (DocGiaDAL.checkEmpty(id)) {
            return true;
        }
        return false;
    }
}
