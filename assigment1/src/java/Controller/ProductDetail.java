/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ProductDAO;
import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class ProductDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = (String) req.getParameter("id");
//        Cookie[] cookies = req.getCookies();
//        String cid = null;
//        for (Cookie c : cookies) {
//            if (c.getName().equals(id)) {
//                cid = c.getValue();
//            }
//        }
//        if (cid == null) {
//            Cookie cookie = new Cookie(id, "0");
//            cookie.setMaxAge(60 * 60 * 24 * 30);
//            cid = "0";
//        }
//        int tang = Integer.parseInt(cid);
//        tang++;
//        Cookie cookie = new Cookie(id, String.valueOf(tang));
//        cookie.setMaxAge(60 * 60 * 24 * 30);
//        resp.addCookie(cookie);
        
        ProductDAO dao = new ProductDAO();
        int x = dao.importSeeing(id);
        System.out.println(x);
        Product p = dao.getProductById(id);
        req.setAttribute("p", p);
        req.setAttribute("see", x);
        req.getRequestDispatcher("ProductDetail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
