/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author admin
 */
public class Sach {
    protected String ten_sach;
    protected int ma_tacgia;
    protected int ma_theloai;
    protected int ma_nhaXB;

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

    public Sach(String ten_sach, int ma_tacgia, int ma_theloai, int ma_nhaXB) {
        this.ten_sach = ten_sach;
        this.ma_tacgia = ma_tacgia;
        this.ma_theloai = ma_theloai;
        this.ma_nhaXB = ma_nhaXB;
    }
}

class SachChitiet extends Sach{
    private String loai_sach;

    public SachChitiet() {
        super();
    }

    public SachChitiet(String ten_sach, int ma_tacgia, int ma_theloai, int ma_nhaXB, String loai_sach) {
        super( ten_sach,  ma_tacgia,  ma_theloai,  ma_nhaXB);
        this.loai_sach = loai_sach;
    }

    public String getLoai_sach() {
        return loai_sach;
    }

    public void setLoai_sach(String loai_sach) {
        this.loai_sach = loai_sach;
    }
}