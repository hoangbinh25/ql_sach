package Class;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectToSQLServer {
      private static SQLServerDataSource ds = null;

    // Phương thức khởi tạo DataSource và trả về đối tượng kết nối
    public static Connection getConnection() throws SQLException {
        if (ds == null) {
            // Khởi tạo chỉ một lần
            ds = new SQLServerDataSource();
            ds.setServerName("localhost");
            ds.setUser("sa");
            ds.setPassword("12345");
            ds.setDatabaseName("QL_SACH");
            ds.setPortNumber(1433);
            ds.setEncrypt(false);
//          ds.setIntegratedSecurity(false);
//          ds.setTrustServerCertificate(false);
        }
        // Trả về kết nối
        return ds.getConnection();
    }

    public static void main(String[] args) {

        try (Connection conn = getConnection()) {
            System.out.println("Connection success!");
            System.out.println(conn.getCatalog());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
