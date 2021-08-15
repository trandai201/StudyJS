
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
@WebServlet(urlPatterns = {"/user"})
public class ViewIndividual extends HttpServlet  {
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
      
        
        UserFull reslt = null;
        try {
            reslt = DBUtils.getUserFull(user.getUserName(),connection);
          
        } catch (SQLException ex) {
            Logger.getLogger(ViewIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("user", user);
        req.setAttribute("result", reslt);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/individual.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         HttpSession session = req.getSession();
        User user = MyUtils.getLoginedUser(session); 
        String name = req.getParameter("name");
         String DOB = req.getParameter("DOB");
         String address = req.getParameter("address");
         String email = req.getParameter("email");
        try {
            DBUtils.setInfoUser(connection, user.getUserName(), new String(name.getBytes("iso-8859-1"),"utf-8"), DOB, new String(address.getBytes("iso-8859-1"),"utf-8"), email);
        } catch (SQLException ex) {
            Logger.getLogger(ViewIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("p","user");
             RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/view/ThongBaoThanhCong.jsp");

        dispatcher.forward(req, resp);
    
    }
}
