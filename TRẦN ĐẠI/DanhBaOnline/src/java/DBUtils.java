
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dai
 */
public class DBUtils {

    static PreparedStatement ps;

    static public String getAllPhoneString(Connection con, String userName) {
        String query = "select * from Table_Phone where userName = ? ";
        String result = "";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result += "  <div id=\"person--1\" class=\"row\">\n"
                        + "                    <div class=\"col-lg-7 row\">\n"
                        + "                        <div class=\" col-lg-8\">" + rs.getString(2) + "</div>\n"
                        + "                        <div class=\" col-lg-4\">" + rs.getString(3) + "</div>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"col-lg-5\">\n"
                        + "                        <div class=\"col-auto\">\n"
                        + "                            <button type=\"button\" onclick =\"myFunction(\'" + rs.getString(3) + "\',\'"+rs.getString(1)+"\')\" class=\"btn btn-primary mb-2\">Chi Tiết</button>\n"
                        + "                            <button type=\"button\" name=\"action\" value= \"" + rs.getString(1) + " " + rs.getString(3) + "\" class=\"btn btn-primary mb-2\">Nhắn Tin</button>\n"
                        + "                        </div>      \n"
                        + "                    </div>                    \n"
                        + "                </div> ";

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    static public User findUser(Connection connection, String userNameString, String password) {
        User user = null;
        String query = "select * from table_user where username = ? and password = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userNameString);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getString(1), rs.getString(3), null);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    static public boolean insertPhone(Connection connection, String userName, String naneString, String phone) throws SQLException {
        String check = "use DanhBa \n select * from table_user where phone = ?";
        ps = connection.prepareStatement(check);
        ps.setString(1, phone);
        ResultSet rs = ps.executeQuery();
        if (!rs.next()){
             return false;
        }
        
        String query = "use DanhBa \n insert into Table_Phone values(?, ?, ?)";

        ps = connection.prepareStatement(query);
        ps.setString(1, userName);
        ps.setString(2, naneString);
        ps.setString(3, phone);
//        System.out.println(userName+" "+naneString+" "+phone);
        ps.execute();
        return true;
    }

    static public void deletePhone(Connection connection, String userName, String phone) throws SQLException {
        System.out.println(userName + "|" + phone);
        String query = "use DanhBa \n delete from Table_Phone where userName = ? and phone = ?";
        ps = connection.prepareStatement(query);
        ps.setString(1, userName);
        ps.setString(2, phone);
        ps.execute();
    }

    static public void insertAccount(Connection connection, String userName, String passString, String name, String DOB, String phone, String address, String email) throws SQLException {

        String query = "use DanhBa \n insert into table_user values(?,?,?,?,?,?,?)";
        ps = connection.prepareStatement(query);
        ps.setString(1, userName);
        ps.setString(2, passString);
        ps.setString(3, name);
        ps.setString(4, DOB);
        ps.setString(5, phone);
        ps.setString(6, address);
        ps.setString(7, email);
        ps.execute();
    }
    
    static public UserFull getUserFull(Connection connection,String phone) throws SQLException{
        String query = "use DanhBa \n select * from table_user where phone = ?";
        ps = connection.prepareStatement(query);
        ps.setString(1, phone);
        ResultSet rs = ps.executeQuery();
        rs.next();
        UserFull temp = new UserFull(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        System.out.println(rs.getString(1));
        return new UserFull(rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
    }
      static public UserFull getUserFull(String userName,Connection connection) throws SQLException{
        String query = "use DanhBa \n select * from table_user where userName = ?";
        ps = connection.prepareStatement(query);
        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();
        rs.next();
        UserFull temp = new UserFull(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        System.out.println(rs.getString(1));
        return new UserFull(rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
    }
      static public void setInfoUser(Connection con,String userName,String name, String DOB,String address, String email) throws SQLException{
          String query = "use DanhBa \n UPDATE table_user \n" +
"SET name = ?, DOB = ?, address= ?, email = ?    \n" +
"WHERE userName= ? ";
          ps = con.prepareStatement(query);
          ps.setString(1, name);
          ps.setString(2, DOB);
          ps.setString(3, address);
          ps.setString(4, email);
          ps.setString(5, userName);
          ps.execute();
          
      }
      static public boolean setPasswork(Connection con , String userNameString, String newPass) throws SQLException{
          try {
              String query = "use DanhBa \n update  table_user \n set password = ? \n"
                  + "where userName = ?";
            ps = con.prepareStatement(query);
          ps.setString(1,newPass);
          ps.setString(2, userNameString);
          ps.execute();
          return true;
          } catch (Exception e) {
             
          }
          
          
          return false;
      
      }
      
}
