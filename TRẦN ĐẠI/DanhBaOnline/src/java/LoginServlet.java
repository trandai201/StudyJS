
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dai
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/view/loginView.jsp");

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String n = req.getParameter("action");
        if (n != null) {

            String nameNewAccout = req.getParameter("nameNewAccout");
            String ngaySinh = req.getParameter("DOB");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            String email = req.getParameter("email");
            String userNameNewAccout = req.getParameter("userNameNewAccout");
            String newpass = req.getParameter("newpass");
            String reNewpass = req.getParameter("reNewpass");
            
//            System.out.println(nameNewAccout);
//            System.out.println(ngaySinh);
//            System.out.println(phone);
//            System.out.println(address);
//            System.out.println(email);
//            System.out.println(userNameNewAccout);
//            System.out.println(newpass);
//            System.out.println(reNewpass);
            
            if (nameNewAccout == null || userNameNewAccout == null || newpass == null || reNewpass == null || nameNewAccout.length() == 0 || userNameNewAccout.length() == 0  || newpass.length() == 0  || reNewpass.length() == 0  ) {
              req.setAttribute("error", "Thất bai! Nhập thiếu thông tin");
            }else{
            if(!newpass.equals(reNewpass)){
                 req.setAttribute("error", "Thất bai! 2 mật khẩu không trùng nhau");
            }else{
                Connection connection = KetNoiCSDL.getConnection();
                try {
                    DBUtils.insertAccount(connection, userNameNewAccout, newpass, new String(nameNewAccout.getBytes("iso-8859-1"),"utf-8"),ngaySinh,phone,new String(address.getBytes("iso-8859-1"),"utf-8"),email);
                              req.setAttribute("error2", "Tạo tài khoản thành công");
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
                     RequestDispatcher dispatcher
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/view/loginView.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        String error = "";
        User user = null;

        if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {

            //lưu thông ti lỗi vào requset thuộc tính
            error = "Tên đăng nhập hoặc mật khẩu đang bị bỏ trống";

        } else {
            Connection con = KetNoiCSDL.getConnection();

            user = DBUtils.findUser(con, userName, password);
            if (user != null) {

            } else {
                error = "Sai Tên ĐN hoặc Password";
            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        // Nếu có lỗi chuyển hướng đến trang
        if (!error.equals("")) {
            user = new User(userName, null, password);
            System.out.println(password);
            req.setAttribute("error", error);
            req.setAttribute("user", user);
            // lưu các dữ liệu vào rq at
            // chuuyeern hướng trở lại để thông báo l
            RequestDispatcher dispatcher
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/view/loginView.jsp");
            dispatcher.forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            // luu thong tin nguoi dung vao Session
            MyUtils.storeLoginedUser(session, user);

            resp.sendRedirect(req.getContextPath() + "/home");
        }

    }

}
