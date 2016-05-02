

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() throws SQLException {
        Connection con = null;

        try {
            // load the JDBC-ODBC Bridge driver
            System.out.println("in try");
//            Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("before ping");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/meditracker?"
                    + "user=root&password=admin");
//            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Mysql","root","admin");
//            con = DriverManager.getConnection(
//                    "jdbc:oracle:thin:@localhost:1521:ORCL",
//                    "sys as sysdba", "admin");
            System.out.println("Connection successful");
            System.out.println("after ping");
        } catch (ClassNotFoundException e) {
            System.out.println("In catch");
            e.printStackTrace();
            System.out.println("Connection exception");
        }
        System.out.println("before con");
        return con;
    }

    public static void closeResultSet(ResultSet rs) {
        // TODO Auto-generated method
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}