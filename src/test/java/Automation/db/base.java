package Automation.db;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class base {
    Connection con;
    @BeforeMethod
    public Connection setUp() throws SQLException{
        try{
            String dbUrl = "jdbc:mysql://localhost:3306/student";
            String username = "root";
            String password = "root";
            con = DriverManager.getConnection(dbUrl,username,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
    @AfterMethod
    public void tearDown() throws SQLException{
        con.close();
    }
}
