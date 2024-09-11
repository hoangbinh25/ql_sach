package Class;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectToSQLServer {

    public static void main(String[] args) {
//        String connURL = "jdbc:sqlserver://localhost:1433;databaseName=QL_SACH;user=sa;password=12345;encrypt=true;trustServerCertificate=true";
//        try (Connection conn = DriverManager.getConnection(connURL)) {
//            System.out.println("Connection success!");
//            System.err.println(conn.getCatalog());
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
        checkConnect2();
    }

    private static void checkConnect2() {

        SQLServerDataSource ds = new SQLServerDataSource();

        ds.setServerName("localhost");
        ds.setUser("sa");
        ds.setPassword("12345");
        ds.setDatabaseName("QL_SACH");
        ds.setPortNumber(1433);
        ds.setEncrypt(false);
//        ds.setIntegratedSecurity(false);
//        ds.setTrustServerCertificate(false);

        try (Connection conn = ds.getConnection()) {
            System.out.println("Connection success!");
            System.out.println(conn.getCatalog());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
