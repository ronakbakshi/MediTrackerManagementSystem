
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author s524975
 */
public class userAppointment {

    private int appid;
    private String Name;
    private String contactNumber;
    private String email;
    private String address;
    private String docName;
    private String date;
    private String time;
    private String hospitalName;

    public String getHospitalName() {
        return hospitalName;
    }

    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int saveAppointment() throws SQLException {
        Connection con = DBConnection.getConnection();

        PreparedStatement insertappointmentDetails = con.prepareStatement("INSERT INTO `meditracker`.`appointmentdetails`\n"
                + "(`patientName`,\n"
                + "`contactnumber`,\n"
                + "`email`,\n"
                + "`address`,\n"
                + "`doctorname`,\n"
                + "`appointmentdate`,\n"
                + "`appointmenttime`,\n"
                + "`hospitalname`,`status`)\n"
                + "VALUES\n"
                + "(?,?,?,?,?,?,?,?,?);");
        insertappointmentDetails.setString(1, getName());
        insertappointmentDetails.setString(2, getContactNumber());
        insertappointmentDetails.setString(3, getEmail());
        insertappointmentDetails.setString(4, getAddress());
        insertappointmentDetails.setString(5, getDocName());
        insertappointmentDetails.setString(6, getDate());
        insertappointmentDetails.setString(7, getTime());
        insertappointmentDetails.setString(8, getHospitalName());
        insertappointmentDetails.setString(9, "Waiting for approval");

        int row = insertappointmentDetails.executeUpdate();

        PreparedStatement viewAppointmentID = con.prepareStatement("SELECT `appointmentID` FROM `meditracker`.`appointmentdetails` where appointmentdate= ? and appointmenttime = ? and email = ?");
        viewAppointmentID.setString(1, getDate());
        viewAppointmentID.setString(2, getTime());
        viewAppointmentID.setString(3, getEmail());

        ResultSet rs = viewAppointmentID.executeQuery();
        int id = 0;
        //int i = 0;
        while (rs.next()) {
            id = rs.getInt(1);
        }
        con.close();
        System.out.println("INSERTED into AppointmentDetails with appointment ID:" + id);
        setAppid(id);
        return id;
    }
    
    
}
