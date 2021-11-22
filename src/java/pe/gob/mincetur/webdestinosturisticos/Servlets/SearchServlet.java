/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mincetur.webdestinosturisticos.Servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.gob.mincetur.webdestinosturisticos.Beans.Destino;
import pe.gob.mincetur.webdestinosturisticos.Utils.ConectaDB;

/**
 *
 * @author User
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.getRequestDispatcher("vistas/search.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String name = request.getParameter("name");
        String tipoBusqueda = request.getParameter("selectTipo");

        String criterio = "d.nombre";
        if (tipoBusqueda.equals("departamento")) {
            criterio = "de.nombre";
        }
        try {
            PreparedStatement sta = ConectaDB.getConexion().
                    prepareStatement("select d.codDestino, de.nombre, d.nombre, df.ruta_imagen, d.descripcion "
                            + "from destino d\n"
                            + "inner join departamento de on de.codDepartamento = d.codDepartamento\n"
                            + "inner join destinofoto df on df.codDestino = d.codDestino "
                            + "where " + criterio + " = ?;");
            sta.setString(1, name);
            ResultSet rs = sta.executeQuery();
            ArrayList<Destino> lista = new ArrayList<>();
            while (rs.next()) {
                Destino d = new Destino(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5).substring(0, 93));
                lista.add(d);
            }
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("vistas/search.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
