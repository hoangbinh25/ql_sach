package DTO;

import java.sql.Date;

public class KhoSach {
    private int ma_kho;
    private int ma_sach;
    private String ten_sach;
    private String vi_tri;
    private int so_luong;
    private int ngay_nhap;
    private int ngay_xuat;
    
    public KhoSach() {
    }

    public int getMa_kho() {
        return ma_kho;
    }

    public void setMa_kho(int ma_kho) {
        this.ma_kho = ma_kho;
    }

    public int getMa_sach() {
        return ma_sach;
    }

    public void setMa_sach(int ma_sach) {
        this.ma_sach = ma_sach;
    }

    public String getTen_sach() {
        return ten_sach;
    }

    public void setTen_sach(String ten_sach) {
        this.ten_sach = ten_sach;
    }

    public String getVi_tri() {
        return vi_tri;
    }

    public void setVi_tri(String vi_tri) {
        this.vi_tri = vi_tri;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public int getNgay_nhap() {
        return ngay_nhap;
    }

    public void setNgay_nhap(int ngay_nhap) {
        this.ngay_nhap = ngay_nhap;
    }

    public int getNgay_xuat() {
        return ngay_xuat;
    }

    public void setNgay_xuat(int ngay_xuat) {
        this.ngay_xuat = ngay_xuat;
    }

    public KhoSach(int ma_kho, int ma_sach, String ten_sach, String vi_tri, int so_luong, int ngay_nhap, int ngay_xuat) {
        this.ma_kho = ma_kho;
        this.ma_sach = ma_sach;
        this.ten_sach = ten_sach;
        this.vi_tri = vi_tri;
        this.so_luong = so_luong;
        this.ngay_nhap = ngay_nhap;
        this.ngay_xuat = ngay_xuat;
    }
    
}
