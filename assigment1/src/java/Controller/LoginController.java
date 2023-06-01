/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.UserDAO;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //kiem tra cookies
        Cookie[] cookies = req.getCookies();
        String account=null,pass=null,role=null;
        for(Cookie c : cookies){
            if(c.getName().equals("account")){
                account = c.getValue();
            }
            if(c.getName().equals("pass")){
                pass = c.getValue();
            }
            if(c.getName().equals("role")){
                role = c.getValue();
            }
        }
        if(account != null && pass != null && role != null){
            User u = new UserDAO().checkLogin(account, pass, role);
            if(u != null){
                HttpSession session = req.getSession();
                session.setAttribute("account", u);
//                req.getSession().setAttribute("account", u);
                resp.sendRedirect("home");
                return;
            }
        }
        req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }

    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = (String) req.getParameter("role");
        String account = (String) req.getParameter("account");
        String pass = (String) req.getParameter("pass");
        String remember = (String) req.getParameter("remember");
        UserDAO userDao = new UserDAO();
        String error = "";

        if (role == null || account.isEmpty() || pass.isEmpty()) {
            error = "Some input is empty";
            req.setAttribute("error", error);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        } else {
            User u = userDao.checkLogin(account, pass, role);
            if (u != null) {
                HttpSession session = req.getSession();
                session.setAttribute("account", u);
                if(remember != null){
                    Cookie accountCookie = new Cookie("account", account);
                    accountCookie.setMaxAge(60*60*24*30);
                    Cookie passCookie = new Cookie("pass", pass);
                    passCookie.setMaxAge(60*60*24*30);
                    resp.addCookie(passCookie);
                    resp.addCookie(accountCookie);
                    Cookie majorCookie = new Cookie("role", String.valueOf(role));
                    majorCookie.setMaxAge(60*60*24*30);
                    resp.addCookie(majorCookie);
                }
                resp.sendRedirect("home");
            } else {
                error = "UserName or PassWord is incorrect !";
                req.setAttribute("error", error);
                req.getRequestDispatcher("Login.jsp").forward(req, resp);
            }
        }
    }

}
