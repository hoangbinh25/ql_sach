/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author admin
 */
public class MuonTra {
    private int ma_muon;
    private int ma_sach;
    private int ma_doc_gia;
    private int ngay_muon;
    private int ngay_hen_tra;
    private int ngay_tra;
    private int trang_thai;

    public MuonTra() {
    }

    public int getMa_muon() {
        return ma_muon;
    }

    public void setMa_muon(int ma_muon) {
        this.ma_muon = ma_muon;
    }

    public int getMa_sach() {
        return ma_sach;
    }

    public void setMa_sach(int ma_sach) {
        this.ma_sach = ma_sach;
    }

    public int getMa_doc_gia() {
        return ma_doc_gia;
    }

    public void setMa_doc_gia(int ma_doc_gia) {
        this.ma_doc_gia = ma_doc_gia;
    }

    public int getNgay_muon() {
        return ngay_muon;
    }

    public void setNgay_muon(int ngay_muon) {
        this.ngay_muon = ngay_muon;
    }

    public int getNgay_hen_tra() {
        return ngay_hen_tra;
    }

    public void setNgay_hen_tra(int ngay_hen_tra) {
        this.ngay_hen_tra = ngay_hen_tra;
    }

    public int getNgay_tra() {
        return ngay_tra;
    }

    public void setNgay_tra(int ngay_tra) {
        this.ngay_tra = ngay_tra;
    }

    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
    }
    

    public MuonTra(int ma_muon, int ma_sach, int ma_doc_gia, int ngay_muon, int ngay_hen_tra, int ngay_tra, int trang_thai) {
        this.ma_muon = ma_muon;
        this.ma_sach = ma_sach;
        this.ma_doc_gia = ma_doc_gia;
        this.ngay_muon = ngay_muon;
        this.ngay_hen_tra = ngay_hen_tra;
        this.ngay_tra = ngay_tra;
        this.trang_thai = trang_thai;
    }
    
    
}
