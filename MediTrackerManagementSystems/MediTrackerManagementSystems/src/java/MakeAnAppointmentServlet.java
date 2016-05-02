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
@WebServlet(urlPatterns = {"/MakeAnAppointmentServlet"})
public class MakeAnAppointmentServlet extends HttpServlet {

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

        
        
        //String name = request.getParameter("name");
        
        
        
//        String contactNumber = request.getParameter("number");
//        
//        String address = request.getParameter("address");
//        String docName = request.getParameter("docName");
//        String appointmentDate = request.getParameter("appDate");
//        String appointmentTime = request.getParameter("appTime");
//        String hospitalName = request.getParameter("hName");
//        response.setContentType("text/html;charset=UTF-8");

//        userAppointment userappointment = new userAppointment();
//        userappointment.setName(name);
//        userappointment.setContactNumber(contactNumber);
//        userappointment.setEmail(email);
//        userappointment.setAddress(address);
//        userappointment.setHospitalName(hospitalName);
//        userappointment.setDocName(docName);
//        userappointment.setDate(appointmentDate);
//        userappointment.setTime(appointmentTime);
        
        userAppointment userappointment = new userAppointment();
        int id = userappointment.saveAppointment();

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (id > 0) {
                out.println("An appointment request with appointment ID <b>" + id + "</b> has been registered with " + userappointment.getDocName() + ". You can check the status of your appointment in the Appointment History page.");
            } else {
                out.println("Failed to make an appointment with " + userappointment.getDocName());
            }

            //out.println(relatedConcept + shortestDistance + weightedDistance + weightedDistance1 + weightedDistance2);
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
            Logger.getLogger(MakeAnAppointmentServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MakeAnAppointmentServlet.class.getName()).log(Level.SEVERE, null, ex);
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
