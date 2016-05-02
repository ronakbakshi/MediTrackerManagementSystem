
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
public class User {

    private String fName;
    private String lName;
    private String gender;
    private String DOB;
    private String email;
    private String password;

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

    public int saveUser() throws SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement insertUser = con.prepareStatement("INSERT INTO `meditracker`.`userdetails`\n"
                + "(`fName`,\n"
                + "`lName`,\n"
                + "`gender`,\n"
                + "`dob`,\n"
                + "`email`)\n"
                + "VALUES\n"
                + "(?,?,?,?,?)");
        insertUser.setString(1, getfName());
        insertUser.setString(2, getlName());
        insertUser.setString(3, getGender());
        insertUser.setString(4, getDOB());
        insertUser.setString(5, getEmail());
        int row = insertUser.executeUpdate();

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
        insertLoginUser.setString(3, "1");
        insertLoginUser.setString(4, "0");
        insertLoginUser.setString(5, "0");
        int rowL = insertLoginUser.executeUpdate();
        DBConnection.closeConnection(con);
        System.out.println("Inserted into LoginUser" + rowL);
        return row + rowL;
    }

    public int fetchUserDetails() throws SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement fetchUser = con.prepareStatement("SELECT fName, lName, gender, dob FROM "
                + "meditracker.userdetails\n"
                + "where email = ?");
        fetchUser.setString(1, getEmail());
        ResultSet rs = fetchUser.executeQuery();
        int count=0;
        while(rs.next()){
            String fname = rs.getString(1);
            String lname = rs.getString(2);
            String gend = rs.getString(3);
            String dob = rs.getString(4);
            this.setDOB(dob);
            this.setGender(gend);
            this.setfName(fname);
            this.setlName(lname);
        }
        con.close();
        return count;
    }

}
