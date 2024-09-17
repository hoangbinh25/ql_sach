package DTO;

public class ChiTietPM {
    private int ma_chi_tiet;
    private int ma_phieu_muon;
    private int ma_sach;
    private int so_luong;
    private int trang_thai;

    public ChiTietPM() {
    }

    public int getMa_chi_tiet() {
        return ma_chi_tiet;
    }

    public void setMa_chi_tiet(int ma_chi_tiet) {
        this.ma_chi_tiet = ma_chi_tiet;
    }

    public int getMa_phieu_muon() {
        return ma_phieu_muon;
    }

    public void setMa_phieu_muon(int ma_phieu_muon) {
        this.ma_phieu_muon = ma_phieu_muon;
    }

    public int getMa_sach() {
        return ma_sach;
    }

    public void setMa_sach(int ma_sach) {
        this.ma_sach = ma_sach;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
    }

    public ChiTietPM(int ma_chi_tiet, int ma_phieu_muon, int ma_sach, int so_luong, int trang_thai) {
        this.ma_chi_tiet = ma_chi_tiet;
        this.ma_phieu_muon = ma_phieu_muon;
        this.ma_sach = ma_sach;
        this.so_luong = so_luong;
        this.trang_thai = trang_thai;
    }
    
    
}
