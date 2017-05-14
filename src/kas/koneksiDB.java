/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Naufal Farras
 */
public class koneksiDB {
    public static Connection koneksi;
    public static Connection getConnection() throws SQLException {
        if(koneksi==null){
            new Driver();
            koneksi =DriverManager.getConnection("jdbc:mysql://localhost:3306/datalogin","root","");
        }
        return koneksi;
    }
    public static void main(String[] args){
        try{
            getConnection();
 JOptionPane.showMessageDialog(null,"koneksi berhasil","report koneksi",JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException ex){
            System.err.println("Koneksi GAGAL");
        }
    }

    static Object GetConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static java.sql.Connection setKoneksi() {
String konString = "jdbc:mysql://localhost:3306/datalogin";
java.sql.Connection koneksi = null;
try {
Class.forName("com.mysql.jdbc.Driver");
koneksi = (java.sql.Connection) DriverManager.getConnection(konString,"root","");
System.out.println("Koneksi Berhasil");
} catch (ClassNotFoundException ex) {Logger.getLogger(koneksiDB.class.getName()).log(Level.SEVERE, null, ex);
System.out.println("Koneksi Gagal");
} catch (SQLException ex) { Logger.getLogger(koneksiDB.class.getName()).log(Level.SEVERE, null, ex);
System.out.println("Koneksi Gagal");
}
return koneksi;
}
    public static int execute(String SQL) {
int status = 0;
java.sql.Connection koneksi = setKoneksi();
try {
Statement st = koneksi.createStatement();
status = st.executeUpdate(SQL);
} catch (SQLException ex) {
Logger.getLogger(koneksiDB.class.getName()).log(Level.SEVERE, null, ex);
}
return status;
}

 public static ResultSet executeQuery(String SQL) {
        ResultSet rs = null;
        java.sql.Connection koneksi = setKoneksi();
    try {
        Statement st = koneksi.createStatement();
        rs = st.executeQuery(SQL);
    } catch (SQLException ex) {Logger.getLogger(koneksiDB.class.getName()).log(Level.SEVERE, null, ex);
  }
return rs;
    }
}
