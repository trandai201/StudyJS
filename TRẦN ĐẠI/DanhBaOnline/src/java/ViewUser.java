
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
@WebServlet(urlPatterns = {"/view"})
public class ViewUser extends HttpServlet {
        Connection con = KetNoiCSDL.getConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        
    
        UserFull user;
           HttpSession session = req.getSession();
        User users = MyUtils.getLoginedUser(session);
        
        if (users == null) {
            // chuyeern huowng sang trang 
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        try {
            user = DBUtils.getUserFull(con, phone);
            req.setAttribute("user", user);
        } catch (SQLException ex) {
            Logger.getLogger(ViewUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/viewuser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
        String action = req.getParameter("action");
        if (action.equals("delete")) {
            String phone = req.getParameter("phone");
            String userID = req.getParameter("userID");
           try {
               DBUtils.deletePhone(con, userID, phone);
           } catch (SQLException ex) {
               Logger.getLogger(ViewUser.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
         resp.sendRedirect(req.getContextPath() + "/home");
    }
    

}
