
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class Doctor {

    private String fName;
    private String lName;
    private String gender;
    private String DOB;
    private String specialization;
    private String location;
    private String timingShift;
    private String hospitalName;
    private String email;
    private String password;

//    public Doctor(String fName, String lName, String gender, String DOB, String specialization, String location, String timingShift, String hospitalName, String email, String password) {
//        this.fName = fName;
//        this.lName = lName;
//        this.gender = gender;
//        this.DOB = DOB;
//        this.specialization = specialization;
//        this.location = location;
//        this.timingShift = timingShift;
//        this.hospitalName = hospitalName;
//        this.email = email;
//        this.password = password;
//    }
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTimingShift() {
        return timingShift;
    }

    public void setTimingShift(String timingShift) {
        this.timingShift = timingShift;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int saveDoctor() throws SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement insertDoctor = con.prepareStatement("INSERT INTO `meditracker`.`doctordetails`\n"
                + "(`firstName`,\n"
                + "`lastName`,\n"
                + "`gender`,\n"
                + "`dob`,\n"
                + "`specialization`,\n"
                + "`location`,\n"
                + "`timings`,\n"
                + "`hospitalName`,\n"
                + "`email`)\n"
                + "VALUES\n"
                + "(?,?,?,?,?,?,?,?,?)");
        insertDoctor.setString(1, getfName());
        insertDoctor.setString(2, getlName());
        insertDoctor.setString(3, getGender());
        insertDoctor.setString(4, getDOB());
        insertDoctor.setString(5, getSpecialization());
        insertDoctor.setString(6, getLocation());
        insertDoctor.setString(7, getTimingShift());
        insertDoctor.setString(8, getHospitalName());       
        insertDoctor.setString(9, getEmail());
        int row = insertDoctor.executeUpdate();

        System.out.println("INSERTED into UserDetails:" + row);
        PreparedStatement insertLoginUser = con.prepareStatement("INSERT INTO `meditracker`.`logindetails`\n"
                + "(`emailid`,\n"
                + "`password`,\n"
                + "`isUser`,\n"
                + "`isDoctor`,\n"
                + "`isAdmin`)\n"
                + "VALUES\n"
                + "(?,?,?,?,?)");

        insertLoginUser.setString(1, getEmail());
        insertLoginUser.setString(2, getPassword());
        insertLoginUser.setString(3, "0");
        insertLoginUser.setString(4, "1");
        insertLoginUser.setString(5, "0");
        int rowL = insertLoginUser.executeUpdate();
        DBConnection.closeConnection(con);
        System.out.println("Inserted into LoginDoctor" + rowL);

        return row + rowL;
    }
}
