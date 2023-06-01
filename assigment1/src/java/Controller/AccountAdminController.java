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
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AccountAdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        UserDAO uDAO = new UserDAO();
        if (method == null) {
            ArrayList<User> list = new ArrayList<>();
            list = uDAO.getAll();
            req.setAttribute("listUser", list);
            req.getRequestDispatcher("ListAccount.jsp").forward(req, resp);
        } else {
            String id = req.getParameter("id");
            uDAO.deleteUserById(id);
            resp.sendRedirect("list-account-admin");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
