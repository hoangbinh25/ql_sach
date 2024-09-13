package DTO;

import DAL.ConnectToSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TacGia {
    protected String ten_tacgia;

    public TacGia() {
    }

    public String getTen_tacgia() {
        return ten_tacgia;
    }

    public void setTen_tacgia(String ten_tacgia) {
        this.ten_tacgia = ten_tacgia;
    }

    public TacGia(String ten_tacgia) {
        this.ten_tacgia = ten_tacgia;
    }

    public boolean addTacGia(String tenTacGia) {
        String query = "INSERT INTO TacGia (ten_tac_gia) VALUES (?)";  
        try (Connection conn = ConnectToSQLServer.getConnection()){
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, tenTacGia);
            int rowsAffected = pst.executeUpdate();
            
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }   
    }
}
