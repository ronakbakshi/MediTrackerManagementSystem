
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
public class LoginChecker {

    private String email;
    private String password;

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

    public int checkEmail() throws SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement checkUser = con.prepareStatement("select count(*) from `meditracker`.`logindetails` where emailid = ?");
        checkUser.setString(1, getEmail());
        ResultSet rs = checkUser.executeQuery();
        int count=0;
        while(rs.next()){
            count = rs.getInt(1);
        }
        con.close();
        System.out.println("Checking if email is correct?"+count);
        return count;
    }

    public int checkLogin() throws SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement checkUser = con.prepareStatement("select count(*) from `meditracker`.`logindetails` where emailid = ? and password = ?");
        checkUser.setString(1, getEmail());
        checkUser.setString(2, getPassword());
        ResultSet rs = checkUser.executeQuery();
        int count = 0;
        while(rs.next()){
            count = rs.getInt(1);
        }
        con.close();
        
        System.out.println("Checking if email and password are correct?"+count);
        return count;
    }

    public String whichUser() throws SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement checkUser = con.prepareStatement("select isUser, isAdmin, isDoctor from `meditracker`.`logindetails` where emailid = ? and password = ?");
        checkUser.setString(1, getEmail());
        checkUser.setString(2, getPassword());
        ResultSet rs = checkUser.executeQuery();
        int isUser = 0;
        int isAdmin = 0;
        int isDoctor = 0;
        while (rs.next()) {
            isUser = rs.getInt(1);
            System.out.println(isUser + "isUSer");
            isAdmin = rs.getInt(2);
            System.out.println(isAdmin + "isAdmin");
            isDoctor = rs.getInt(3);
            System.out.println(isDoctor + "isDoc");
        }
        con.close();
        if (isUser == 1) {
            return "User";
        } else if (isAdmin == 1) {
            return "Admin";
        } else {
            return "Doctor";
        }
    }
}
