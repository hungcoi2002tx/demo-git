/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.UserDAO;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class InfomationCotroller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        
        req.getRequestDispatcher("information.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("account");
        int id = u.getId();
        int role = u.getRole();
        String name = (String) req.getParameter("name");
        String email = (String) req.getParameter("email");
        String pass = u.getPass();
        String phone = (String) req.getParameter("phone");
        String address = (String) req.getParameter("address");
        String account = (String) req.getParameter("account");
        String error = "";
        if (name.isEmpty() || account.isEmpty() || pass.isEmpty()) {
            error = "Some value is empty";
            req.setAttribute("error", error);
            req.getRequestDispatcher("Register.jsp").forward(req, resp);
            return;
        } else {
            Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9._-]*@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+$");
            Matcher m = p.matcher(email);
            if (!m.find() && !email.isEmpty()) {
                error = "Email is not validate";
                req.setAttribute("error", error);
                req.getRequestDispatcher("information.jsp").forward(req, resp);
                return;
            }
            Pattern pattern = Pattern.compile("^[0]\\d{9}$");
            Matcher matcher = pattern.matcher(phone);
            if (!matcher.find() && !phone.isEmpty()) {
                error = "Phone is not validate";
                req.setAttribute("error", error);
                req.getRequestDispatcher("Information.jsp").forward(req, resp);
                return;
            }
            if (userDAO.checkDuplicateByEmail(email) && !email.isEmpty() && !email.equals(u.getEmail())) {
                error = "Email is exist";
                req.setAttribute("error", error);
                req.getRequestDispatcher("information.jsp").forward(req, resp);
                return;
            }

            User u1 = new User(id, name, account, pass, address, phone, email, role);
            userDAO.updateUser(u1);
            session.setAttribute("account", u1);
            error="Update succesfully";
            req.setAttribute("error", error);
            req.getRequestDispatcher("information.jsp").forward(req, resp);
        }
    }

}
