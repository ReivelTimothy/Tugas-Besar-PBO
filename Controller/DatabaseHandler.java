package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

// import java.sql.SQLException;
// import java.util.TimeZone;
import javax.swing.JOptionPane;

public class DatabaseHandler {

    public Connection con;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/hboticket";
    // private String url = "jdbc:mysql://localhost/db_test?serverTimezone=" + TimeZone.getDefault().getID();

    private String username = "root";
    private String password = "";

    private Connection logOn() {
        try {
            // Load JDBC Driver
            Class.forName(driver).newInstance();
            // Buat Object Connection
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "Error Ocurred when login" + ex);
        }
        return con;
    }
    private void logOff() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Ocurred when login" + ex);
        }
    }

    public void connect() {
        try {
            con = logOn();
            if (con != null) {
                System.out.println("Koneksi berhasil!");
            } else {
                System.out.println("Koneksi gagal. Periksa konfigurasi database Anda.");
            }
        }
        catch (Exception ex) {
            System.out.println("Error occured when connecting to database");
        }
    }

    public void disconnect() {
        try {
            logOff();
        }
        catch (Exception ex) {
            System.out.println("Error occured when connecting to database");
        }
    }
}