/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author s524975
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println("Password is:" + password);
        LoginChecker lc = new LoginChecker();
        lc.setEmail(email);
        lc.setPassword(password);
        int emailExists = lc.checkEmail();
        String message = "";
        if (emailExists == 1) {
            System.out.println("going to match password");
            int combinationExists = lc.checkLogin();
            if (combinationExists == 1) {
                Cookie ck = new Cookie("email", email);//creating cookie object  
                response.addCookie(ck);//adding cookie in the response 
                String userType = lc.whichUser();
                if ("Admin".equals(userType)) {
                    /* TODO output your page here. You may use following sample code. */
                    message = "Admin";
                }
                if ("User".equals(userType)) {
                    /* TODO output your page here. You may use following sample code. */
                    message = "User";
                }
                if ("Doctor".equals(userType)) {
                    /* TODO output your page here. You may use following sample code. */
                    message = "Doctor";
                }
            } else {
                /* TODO output your page here. You may use following sample code. */
                message = "Incorrect Password";
            }
        } else {
            /* TODO output your page here. You may use following sample code. */
            message = "Username does not exists";
        }
//        response.setContentType("text/plain");
//        response.setCharacterEncoding("UTF-8");
          response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(message);
        }
        //System.out.println(message);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
