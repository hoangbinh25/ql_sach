package BUS;

import DAL.ThongKeDAL;
import DTO.ThongKe;
import java.util.List;

public class ThongKeBUS {
    public static List<ThongKe> loadTK() {
        return ThongKeDAL.loadTK();
    }
}
