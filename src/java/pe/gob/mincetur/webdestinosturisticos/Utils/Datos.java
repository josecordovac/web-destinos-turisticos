package pe.gob.mincetur.webdestinosturisticos.Utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.gob.mincetur.webdestinosturisticos.Beans.Destino;

public class Datos {

    public static List<Destino> getDestinos(String field, String value) {
        try {
            String criterio = "";
            if (!"".equals(field)) {
                criterio = "where " + field + " = ?;";
            }
            PreparedStatement sta = ConectaDB.getConexion().
                    prepareStatement("select d.codDestino, de.nombre, d.nombre, "
                            + "(select ruta_imagen from destinofoto df where df.codDestino = d.codDestino LIMIT 1) as ruta_imagen, "
                            + "d.descripcion "
                            + "from destino d "
                            + "inner join departamento de on de.codDepartamento = d.codDepartamento "
                            + criterio);
            if (!"".equals(field)) {
                sta.setString(1, value);
            }
            ResultSet rs = sta.executeQuery();
            ArrayList<Destino> lista = new ArrayList<>();
            while (rs.next()) {
                Destino d = new Destino(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5).substring(0, 93));
                lista.add(d);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("Error: " + e);
            return null;
        }
    }

    public static void main(String[] args) {

    }

}
