
import java.io.IOException;
import java.net.URLDecoder;
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
@WebServlet(urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    Connection connection;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        connection = KetNoiCSDL.getConnection();
        HttpSession session = req.getSession();
        User user = MyUtils.getLoginedUser(session);
        
        if (user == null) {
            // chuyeern huowng sang trang 
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        String reslt = DBUtils.getAllPhoneString(connection, user.getUserName());
        req.setAttribute("user", user);
        req.setAttribute("result", reslt);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/homeView.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // nếu nhấn đăng xuất thì xóa user trong sesion và chuyển hướng về trang đăng nhập
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");

        String ac = req.getParameter("action");
        HttpSession session = req.getSession();
        User user = MyUtils.getLoginedUser(session);

        String lo = req.getParameter("logout");
        if (lo != null) {
//            
            MyUtils.storeLoginedUser(session, null);
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // nếu không nhấn vô nút xóa thì kiểm tra 2 giá trị mới nhập
        if (ac == null) {
            // nếu như chauw nhập haowjc nhập thiếu 1 ô
            if (name.length() == 0 || phone.length() == 0 || name == null || phone == null) {
                req.setAttribute("error", "Chưa nhập đủ thông tin");

            } else {// nếu như nhập đầy đủ thì thêm vào csdl 
              
                resp.setContentType("text/html;charset=UTF-8");
                System.out.println(new String(name.getBytes("iso-8859-1"), "utf-8"));
                try {
                    if(!DBUtils.insertPhone(connection, user.getUserName(), new String(name.getBytes("iso-8859-1"), "utf-8"), new String(phone.getBytes("iso-8859-1"), "utf-8"))){
                         req.setAttribute("error", "Bạn đã nhập sai số điện thoại");
                    
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            try {
                DBUtils.deletePhone(connection, ac.substring(0, ac.indexOf(' ')), ac.substring(ac.indexOf(' ') + 1, ac.length()));
            } catch (SQLException ex) {
                Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        String reslt = DBUtils.getAllPhoneString(connection, user.getUserName());
        req.setAttribute("result", reslt);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/view/homeView.jsp");
        dispatcher.forward(req, resp);

    }

}
