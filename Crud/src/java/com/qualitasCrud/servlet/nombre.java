package com.qualitasCrud.servlet;

import com.qualitasCrud.bean.Usuario;
import com.qualitasCrud.dao.PersonaDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author epliego
 */
@WebServlet(name = "nombre", urlPatterns = {"/nombre"})

public class nombre extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //       String nombre1 = request.getParameter("nombre");     
        //       String email1 = request.getParameter("email"); 
        //       request.setAttribute("nombre" , nombre1);
        //       request.setAttribute("email" , email1);
        //  RequestDispatcher dispatcher = request.getRequestDispatcher("/response.jsp");
        // dispatcher.forward(request, response); 
        HttpSession session = request.getSession();
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        
        Usuario u = new Usuario();
        u.setNombre(nombre);
        u.setEmail(email);
        try {
            PersonaDao.save(u);
        } catch (SQLException ex) {
            System.err.println("Error " + ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("Error " + ex.getMessage());
            ex.printStackTrace();
        }

        session.setAttribute("nombre", nombre);
        session.setAttribute("email", email);
        response.sendRedirect("response.jsp");

    }
}
