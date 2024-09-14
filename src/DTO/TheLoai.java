/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author admin
 */
public class TheLoai {
    private int ma_the_loai;
    private String ten_the_loai;

    public TheLoai() {
    }

    public int getMa_the_loai() {
        return ma_the_loai;
    }

    public void setMa_the_loai(int ma_the_loai) {
        this.ma_the_loai = ma_the_loai;
    }

    public String getTen_the_loai() {
        return ten_the_loai;
    }

    public void setTen_the_loai(String ten_the_loai) {
        this.ten_the_loai = ten_the_loai;
    }

    public TheLoai(int ma_the_loai, String ten_the_loai) {
        this.ma_the_loai = ma_the_loai;
        this.ten_the_loai = ten_the_loai;
    }
    
    
}
