
import java.io.IOException;
import java.sql.Connection;
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
@WebServlet(urlPatterns = {"/changepassword"})
public class ViewChangePass extends HttpServlet {

    Connection connection;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        connection = KetNoiCSDL.getConnection();
        HttpSession session = req.getSession();
        User user = MyUtils.getLoginedUser(session);

        if (user == null) {
            // chuyeern huowng sang trang 
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

//        try {
////            reslt = DBUtils.getUserFull(user.getUserName(),connection);
//          
//        } catch (SQLException ex) {
//            Logger.getLogger(ViewIndividual.class.getName()).log(Level.SEVERE, null, ex);
//        }
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/changPass.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = MyUtils.getLoginedUser(session);

        String oldPass = req.getParameter("oldPass");
        String newPass = req.getParameter("newPass");
        String reNewPass = req.getParameter("reNewPass");
        String errors = "";
        if (oldPass.length() == 0 || newPass.length() == 0 || reNewPass.length() == 0) {
            errors = "Nhập thiếu vui lòng nhập lại !!!!";
        } else if (DBUtils.findUser(connection, user.getUserName(), oldPass) == null) {
            errors = "Nhập sai mật khẩu cũ !!!!";
        } else if (!newPass.equals(reNewPass)) {
            errors = "Nhập Lại Mật Khẩu Sai !!!!!!!";
        } try {
            if (DBUtils.setPasswork(connection, user.getUserName(), newPass)== true) {
               
            }else
                errors =  "Đã Có Lỗi Xãy Ra !";
        } catch (SQLException ex) {
            Logger.getLogger(ViewChangePass.class.getName()).log(Level.SEVERE, null, ex);
             errors =  "Đã Có Lỗi Xãy Ra !";
        }

        if (errors.length() != 0) {
            req.setAttribute("errors", errors);
            System.out.println(newPass + reNewPass);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/changPass.jsp");
            dispatcher.forward(req, resp);
        } else {

            req.setAttribute("p", "changepassword");
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/view/ThongBaoThanhCong.jsp");

            dispatcher.forward(req, resp);

//        
        }
    }

}
