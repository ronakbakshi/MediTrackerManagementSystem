/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ronak Bakshi
 */
@WebServlet(urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String isUser = request.getParameter("isUser");
        if ("1".equals(isUser)) {
            String fname = request.getParameter("firstName");
            String lname = request.getParameter("lastName");
            String gender = request.getParameter("gender");
            String DOB = request.getParameter("DOB");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            response.setContentType("text/html;charset=UTF-8");

            User user = new User();
            user.setfName(fname);
            user.setlName(lname);
            user.setGender(gender);
            user.setDOB(DOB);
            user.setEmail(email);
            user.setPassword(password);

            int rows = user.saveUser();

            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                if (rows > 0) {
                    out.println(user.getfName() + " " + user.getlName() + ", signed up sucessfully as a user!");
                } else {
                    out.println(user.getfName() + " " + user.getlName() + ", sign up failed!");
                }

                //out.println(relatedConcept + shortestDistance + weightedDistance + weightedDistance1 + weightedDistance2);
            }
        } else {
            String fname = request.getParameter("firstName");
            String lname = request.getParameter("lastName");
            String gender = request.getParameter("gender");
            String DOB = request.getParameter("DOB");
            String specialization = request.getParameter("specialization");
            String location = request.getParameter("location");
            String timingShift = request.getParameter("timingShifts");
            String hospitalName = request.getParameter("hospitalName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            response.setContentType("text/html;charset=UTF-8");

            Doctor doctor = new Doctor();
            doctor.setfName(fname);
            doctor.setlName(lname);
            doctor.setGender(gender);
            doctor.setDOB(DOB);
            doctor.setSpecialization(specialization);
            doctor.setLocation(location);
            doctor.setTimingShift(timingShift);
            doctor.setHospitalName(hospitalName);
            doctor.setEmail(email);
            doctor.setPassword(password);

            int rows = doctor.saveDoctor();

            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                if (rows > 0) {
                    out.println(doctor.getfName() + " " + doctor.getlName() + ", signed up sucessfully as a doctor!");
                } else {
                    out.println(doctor.getfName() + " " + doctor.getlName() + ", sign up failed!");
                }

            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
