
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author s524975
 */
public class AppointmentHistory {

    public String approveAppointment() throws SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement appointmentDetails = con.prepareStatement("SELECT `doctordetails`.`firstName`,\n"
                + "    `doctordetails`.`lastName`\n"
                + "FROM `meditracker`.`doctordetails`\n"
                + "where `doctordetails`.`email` = ?");

        //appointmentDetails.setString(1, email);
        ResultSet rs = appointmentDetails.executeQuery();
        String name = "";
        int i = 0;
        while (rs.next()) {
            String docfName = rs.getString(1);
            String doclName = rs.getString(2);

            name = docfName + " " + doclName;
            i++;
        }
        con.close();
        System.out.println("Doctor name:" + name);
        return name;
    }

    public String fetchdoctorName(String email) throws SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement appointmentDetails = con.prepareStatement("SELECT `doctordetails`.`firstName`,\n"
                + "    `doctordetails`.`lastName`\n"
                + "FROM `meditracker`.`doctordetails`\n"
                + "where `doctordetails`.`email` = ?");

        appointmentDetails.setString(1, email);
        ResultSet rs = appointmentDetails.executeQuery();
        String name = "";
        int i = 0;
        while (rs.next()) {
            String docfName = rs.getString(1);
            String doclName = rs.getString(2);

            name = docfName + " " + doclName;
            i++;
        }
        con.close();
        System.out.println("Doctor name:" + name);
        return name;
    }

    public ArrayList<Appointment> fetchAppointmentRequest(String name) throws SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement appointmentDetails = con.prepareStatement("SELECT `patientName`,`appointmentdate`, `appointmenttime`, `status`,`appointmentID`\n" +
"                FROM `meditracker`.`appointmentdetails`\n" +
"                where doctorname= ?");

        appointmentDetails.setString(1, name);
        ResultSet rs = appointmentDetails.executeQuery();
        ArrayList<Appointment> history = new ArrayList<>();
        int i = 0;
        while (rs.next()) {
            String patientName = rs.getString(1);
            String appointmentDate = rs.getString(2);
            String appointmentTime = rs.getString(3);
            String status = rs.getString(4);
            if ("Waiting for approval".equals(status)) {
                status = "Approve";
            }
            int appointmentID = rs.getInt(5);
            Appointment appointment = new Appointment(appointmentID, patientName, appointmentDate, appointmentTime, status);
            history.add(appointment);
//            history.add(rs.getString(2));
//            history.add(rs.getString(3));
//            history.add(rs.getString(4));
//            history.add(rs.getString(5));
            i++;
        }
        con.close();
        System.out.println("No: of rows returned:" + i);
        return history;
    }

    public ArrayList<Appointment> fetchAppointmentHistory(String email) throws SQLException {
        Connection con = DBConnection.getConnection();

        PreparedStatement appointmentDetails = con.prepareStatement("select doctorName, hospitalName, appointmentdate, appointmenttime, status, `appointmentdetails`.`appointmentid` from `meditracker`.`appointmentdetails` where email = ? order by appointmentdate desc");

        appointmentDetails.setString(1, email);
        ResultSet rs = appointmentDetails.executeQuery();
        ArrayList<Appointment> history = new ArrayList<>();
        int i = 0;
        while (rs.next()) {
            String docName = rs.getString(1);
            String hospitalName = rs.getString(2);
            String appDate = rs.getString(3);
            String appTime = rs.getString(4);
            String status = rs.getString(5);
            int appointmentID = rs.getInt(6);
            Appointment appointment = new Appointment(appointmentID, docName, hospitalName, appDate, appTime, status);
            history.add(appointment);
//            history.add(rs.getString(2));
//            history.add(rs.getString(3));
//            history.add(rs.getString(4));
//            history.add(rs.getString(5));
            i++;
        }
        con.close();
        System.out.println("No: of rows returned:" + i);
        return history;
    }
}
