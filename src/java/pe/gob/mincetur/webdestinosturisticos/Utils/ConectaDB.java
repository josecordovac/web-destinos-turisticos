package pe.gob.mincetur.webdestinosturisticos.Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaDB {

    public static Connection getConexion() {
        Connection con = null;
        String cadena = "jdbc:mysql://localhost/portal?user=demo&password=demo";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(cadena);
        } catch (Exception e) {
            System.out.println("Error de conexion: " + e);
        }
        return con;
    }

    public static void main(String[] args) {
        getConexion();
    }
}
