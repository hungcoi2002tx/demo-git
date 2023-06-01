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
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        String name = (String) req.getParameter("name");
        String email = (String) req.getParameter("email");
        String pass = (String) req.getParameter("pass");
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
                req.getRequestDispatcher("Register.jsp").forward(req, resp);
                return;
            }
            Pattern pattern = Pattern.compile("^[0]\\d{9}$");
            Matcher matcher = pattern.matcher(phone);
            if (!matcher.find() && !phone.isEmpty()) {
                error = "Phone is not validate";
                req.setAttribute("error", error);
                req.getRequestDispatcher("Register.jsp").forward(req, resp);
                return;
            }
            if (userDAO.checkDuplicateByEmail(email) && !email.isEmpty()) {
                error = "Email is exist";
                req.setAttribute("error", error);
                req.getRequestDispatcher("Register.jsp").forward(req, resp);
                return;
            }
            if (userDAO.checkDuplicateByAccount(account)) {
                error = "Account is exist";
                req.setAttribute("error", error);
                req.getRequestDispatcher("Register.jsp").forward(req, resp);
                return;
            }
            User u = new User(0, name, account, pass, address, phone, email, 0);
            userDAO.insertUser(u);
            resp.sendRedirect("login");
        }

    }

}
