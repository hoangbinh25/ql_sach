package DTO;

import java.sql.Date;

public class KhoSach {
    protected int ma_sach;
    protected String ten_sach;
    protected String vi_tri;
    protected int so_luong;
    protected java.sql.Date ngay_nhap;
    protected java.sql.Date ngay_xuat;
    
    public KhoSach() {
    }
    
    public KhoSach(int ma_sach, String ten_sach, String vi_tri, int so_luong, java.sql.Date ngay_nhap, java.sql.Date ngay_xuat) {
        this.ma_sach = ma_sach;
        this.vi_tri = vi_tri;
        this.so_luong = so_luong;
        this.ngay_nhap = ngay_nhap;
        this.ngay_xuat = ngay_xuat;
    }

    public KhoSach(int maSach, String tenSach, String viTri, int soLuong, java.util.Date ngayNhap, java.util.Date ngayXuat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void KhoSach() {
    // Logic xử lý cho phương thức này
    System.out.println("This method is now supported!");
    }

    
    public String getTen_sach() {
        return ten_sach;
    }

    public void setTen_sach(String ten_sach) {
        this.ten_sach = ten_sach;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public Date getNgay_nhap() {
        return ngay_nhap;
    }

    public void setNgay_nhap(Date ngay_nhap) {
        this.ngay_nhap = ngay_nhap;
    }

    public Date getNgay_xuat() {
        return ngay_xuat;
    }

    public void setNgay_xuat(Date ngay_xuat) {
        this.ngay_xuat = ngay_xuat;
    }

    public int getMa_sach() {
        return ma_sach;
    }

    public void setMa_sach(int ma_sach) {
        this.ma_sach = ma_sach;
    }

    public String getVi_tri() {
        return vi_tri;
    }

    public void setVi_tri(String vi_tri) {
        this.vi_tri = vi_tri;
    }

    public KhoSach(int ma_sach, String vi_tri) {
        this.ma_sach = ma_sach;
        this.vi_tri = vi_tri;
    }
}
