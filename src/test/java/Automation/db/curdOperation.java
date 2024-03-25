package Automation.db;

import org.testng.annotations.Test;

import java.sql.*;

public class curdOperation extends base{
    Connection con;
    @Test
    public void select() throws SQLException{
        con = this.setUp();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from Users");
        while(rs.next()){
            int userId = rs.getInt(1);
            String username = rs.getString(2);
            System.out.println("User id : "+userId+",\t Username : "+username);
        }
    }
    @Test
    public void insertData() throws SQLException{
        con = this.setUp();
        PreparedStatement ps = con.prepareStatement("insert into User values(?,?)");
        ps.setString(1,"103");
        ps.setString(2,"Himanshu");
        ps.executeUpdate();
        select();
    }
    @Test
    public void updateData() throws SQLException{
        con = this.setUp();
        PreparedStatement ps = con.prepareStatement("update User set username='Ashutosh' where userid=102");
        ps.executeUpdate();
        select();
    }
    @Test
    public void deleteData() throws SQLException{
        con = this.setUp();
        try{
            PreparedStatement ps = con.prepareStatement("delete from Users where userid=102");
            ps.executeUpdate();
            select();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
