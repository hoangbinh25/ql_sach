package DTO;

public class TheLoai {
    protected int ma_theloai;
    protected String ten_theloai;

    public TheLoai() {
    }

    public String getTen_theloai() {
        return ten_theloai;
    }

    public void setTen_theloai(String ten_theloai) {
        this.ten_theloai = ten_theloai;
    }

    public int getMa_theloai() {
        return ma_theloai;
    }

    public void setMa_theloai(int ma_theloai) {
        this.ma_theloai = ma_theloai;
    }

    public TheLoai(int ma_theloai, String ten_theloai) {
        this.ma_theloai = ma_theloai;
        this.ten_theloai = ten_theloai;
    }
    
}
