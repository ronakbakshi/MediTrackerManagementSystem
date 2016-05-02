
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
public class Hospitals {

    private String name;
    private String hours;
    private String contact;
    private String address;
    private String city;
    private String state;

    public Hospitals(String name, String hours, String contact, String address, String city, String state) {
        this.name = name;
        this.hours = hours;
        this.contact = contact;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int addHospital() throws SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement insertHospital = con.prepareStatement("INSERT INTO `meditracker`.`hospitaldetails`\n"
                + "(`hospitalName`,\n"
                + "`city`,\n"
                + "`state`,\n"
                + "`contactinformation`,\n"
                + "`address`,\n"
                + "`hoursOfOperation`)\n"
                + "VALUES\n"
                + "(?,?,?,?,?,?)");
        insertHospital.setString(1, getName());
        insertHospital.setString(2, getCity());
        insertHospital.setString(3, getState());
        insertHospital.setString(4, getContact());
        insertHospital.setString(5, getAddress());
        insertHospital.setString(6, getHours());
        int rowL = insertHospital.executeUpdate();
        DBConnection.closeConnection(con);
        System.out.println("Inserted into Hospitals" + rowL);
        return rowL;
    }

}
