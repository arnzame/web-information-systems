/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DBAccess;
import model.User;

/**
 *
 * @author aaron
 */
@WebServlet(name = "login", urlPatterns = {"/controller/user/login"})
public class login extends HttpServlet {

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
        DBAccess db = new DBAccess();
        HttpSession session = request.getSession();
        if (!db.validate(request.getParameter("userName")) || !db.validate(request.getParameter("password"))){
            session.setAttribute("loggedIn", false);
        }
        
        try {
            
            Connection conn = db.getConnection();
            Statement statement = conn.createStatement();
            ResultSet s = statement.executeQuery("SELECT * FROM Users WHERE userName = '" + request.getParameter("userName") + "' AND password = '" 
                    + db.encrypt(request.getParameter("password")) + "';");
            if (s.next()){
                User u = new User(s.getString("userName"), s.getString("password"), s.getString("firstName"), s.getString("lastName"));
                u.setLoggedIn(true);
                session.setAttribute("loggedIn", true);
                if (s.getInt("isAdmin") ==  1){
                    u.setAdmin(true);
                }
                if (s.getInt("isSuperAdmin") ==  1){
                    u.setSuperAdmin(true);
                }
                session.setAttribute("user", u);
                
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
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
