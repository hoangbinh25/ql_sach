package Class;

import java.util.Date;

public class Sach {
    protected int ma_sach;
    protected String ten_sach;
    protected int ma_tacgia;
    protected int ma_theloai;
    protected int ma_nhaXB;
    protected Date namXB;

    public int getMa_sach() {
        return ma_sach;
    }

    public void setMa_sach(int ma_sach) {
        this.ma_sach = ma_sach;
    }

    public Date getNamXB() {
        return namXB;
    }

    public void setNamXB(Date namXB) {
        this.namXB = namXB;
    }

    public Sach() {
    }

    public String getTen_sach() {
        return ten_sach;
    }

    public void setTen_sach(String ten_sach) {
        this.ten_sach = ten_sach;
    }

    public int getMa_tacgia() {
        return ma_tacgia;
    }

    public void setMa_tacgia(int ma_tacgia) {
        this.ma_tacgia = ma_tacgia;
    }

    public int getMa_theloai() {
        return ma_theloai;
    }

    public void setMa_theloai(int ma_theloai) {
        this.ma_theloai = ma_theloai;
    }

    public int getMa_nhaXB() {
        return ma_nhaXB;
    }

    public void setMa_nhaXB(int ma_nhaXB) {
        this.ma_nhaXB = ma_nhaXB;
    }

    public Sach(int ma_sach, String ten_sach, int ma_tacgia, int ma_theloai, int ma_nhaXB, Date namXB) {
        this.ma_sach = ma_sach;
        this.ten_sach = ten_sach;
        this.ma_tacgia = ma_tacgia;
        this.ma_theloai = ma_theloai;
        this.ma_nhaXB = ma_nhaXB;
        this.namXB = namXB;
    }

    
}

class SachChitiet extends Sach{
    private String loai_sach;

    public SachChitiet() {
        super();
    }

    public SachChitiet(int ma_sach, String ten_sach, int ma_tacgia, int ma_theloai, int ma_nhaXB, Date namXB, String loai_sach) {
        super(ma_sach, ten_sach,  ma_tacgia,  ma_theloai,  ma_nhaXB, namXB);
        this.loai_sach = loai_sach;
    }

    public String getLoai_sach() {
        return loai_sach;
    }

    public void setLoai_sach(String loai_sach) {
        this.loai_sach = loai_sach;
    }
}