/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/AppointmentHistoryServlet"})
public class AppointmentHistoryServlet extends HttpServlet {

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

        //String email = request.getParameter("email");
        Cookie ck[]=request.getCookies();
        AppointmentHistory history = new AppointmentHistory();
        ArrayList<Appointment> historyList = history.fetchAppointmentHistory(ck[0].getValue());
        String json = new Gson().toJson(historyList );
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//            try (JsonGenerator gen = Json.createGenerator(out)) {
//                for (int i = 0; i < historyList.size(); i += 5) {
//                    gen.writeStartObject()
//                            .writeStartArray("Appointments")
//                            .writeStartObject()
//                            .write("name", historyList.get(i))
//                            .write("hospitalName", historyList.get(i+1))
//                            .write("date", historyList.get(i+2))
//                            .write("time", historyList.get(i+3))
//                            .write("status", historyList.get(i+4))
//                            .writeEnd()
//                            .writeEnd()
//                            .writeEnd();
//                }
//            }
            System.out.println(json);
            out.write(json);
            
            /* TODO output your page here. You may use following sample code. */
            //out.println(historyList);
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
            Logger.getLogger(AppointmentHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AppointmentHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
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
