package pe.gob.mincetur.webdestinosturisticos.Servlets;

import pe.gob.mincetur.webdestinosturisticos.Beans.Destino;
import pe.gob.mincetur.webdestinosturisticos.Utils.ConectaDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import pe.gob.mincetur.webdestinosturisticos.Utils.Datos;

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
            List<Destino> lista = Datos.getDestinos("", "");
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
