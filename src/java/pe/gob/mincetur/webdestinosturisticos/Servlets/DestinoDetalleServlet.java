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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.gob.mincetur.webdestinosturisticos.Beans.Destino;
import pe.gob.mincetur.webdestinosturisticos.Beans.DestinoFoto;
import pe.gob.mincetur.webdestinosturisticos.Beans.Detalle;
import pe.gob.mincetur.webdestinosturisticos.Utils.ConectaDB;

/**
 *
 * @author User
 */
@WebServlet(name = "DestinoDetalleServlet", urlPatterns = {"/destinodetalle"})
public class DestinoDetalleServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        //processRequest(request, response);
        int codDestino = Integer.parseInt(request.getParameter("id"));
        try {
            PreparedStatement sta = ConectaDB.getConexion().
                    prepareStatement("SELECT d.codDestino, de.nombre, d.nombre, d.descripcion "
                            + "FROM destino d "
                            + "inner join departamento de on de.codDepartamento = d.codDepartamento "
                            + "where d.codDestino = ?;");
            sta.setInt(1, codDestino);
            ResultSet rs = sta.executeQuery();
            Detalle d = null;
            while (rs.next()) {
                d = new Detalle(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
            }
            
            sta = ConectaDB.getConexion().
                    prepareStatement("SELECT df.codDestinoFoto, df.ruta_imagen "
                            + "FROM destino d inner join destinofoto df on df.codDestino = d.codDestino "
                            + "where d.codDestino = ?;");
            sta.setInt(1, codDestino);
            rs = sta.executeQuery();
            List<DestinoFoto> imagenes = new ArrayList<>();
            while (rs.next()) {
                DestinoFoto df = new DestinoFoto(rs.getInt(1), rs.getString(2));
                imagenes.add(df);
            }
            d.setImagenes(imagenes);
            
            request.setAttribute("detalle", d);
            System.out.println(d.getNombre());
            request.getRequestDispatcher("vistas/detalle.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
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
