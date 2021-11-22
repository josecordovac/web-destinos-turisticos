package pe.gob.mincetur.webdestinosturisticos.Servlets;

import pe.gob.mincetur.webdestinosturisticos.Beans.Destino;
import pe.gob.mincetur.webdestinosturisticos.Utils.ConectaDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "DestinoServlet", value = "/destino")
public class DestinoServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        try {
            PreparedStatement sta = ConectaDB.getConexion().
                    prepareStatement("select d.codDestino, de.nombre, d.nombre, df.ruta_imagen, d.descripcion " +
                            "from destino d\n" +
                            "inner join departamento de on de.codDepartamento = d.codDepartamento\n" +
                            "inner join destinofoto df on df.codDestino = d.codDestino;");
            ResultSet rs = sta.executeQuery();
            ArrayList<Destino> lista = new ArrayList<>();
            while (rs.next()) {
                Destino d = new Destino(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5).substring(0, 93));
                lista.add(d);
            }
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("vistas/destino.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
