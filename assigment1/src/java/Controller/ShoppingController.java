/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.CategoryDAO;
import DAO.ColorDAO;
import DAO.ProductDAO;
import Model.Category;
import Model.Color;
import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ShoppingController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Product> listProduct = new ArrayList<>();
        ProductDAO productDAO = new ProductDAO();
        ArrayList<Category> listCate = new ArrayList<>();
        CategoryDAO cateDAO = new CategoryDAO();
        ArrayList<Color> listColor = new ArrayList<>();
        ColorDAO colorDAO = new ColorDAO();
        listColor = colorDAO.getAll();
        listCate = cateDAO.getAll();
        listProduct = productDAO.getAll();
        HttpSession session = req.getSession();
        //
        String findCate = "";
        if (req.getParameter("cateSelected") != null) {
            String s = req.getParameter("cateSelected");
            if (s.equals("empty")) {
                session.setAttribute("cateSelected", s);
                findCate = (String) session.getAttribute("cateSelected");
            } else {
                session.setAttribute("cateSelected", s);
                findCate = (String) session.getAttribute("cateSelected");
            }
        } else {
            if (session.getAttribute("cateSelected") != null) {
                findCate = (String) session.getAttribute("cateSelected");
            }
        }
        if (!findCate.equals("empty")) {
            listProduct = productDAO.findByCate(findCate);
        } else {
            listProduct = productDAO.getAll();
        }

        //color
        String findColor = "";
        System.out.println(req.getParameter("colorSelected"));
        if (req.getParameter("colorSelected") != null) {
            String s = req.getParameter("colorSelected");
            if (s.equals("empty")) {
                session.removeAttribute("colorSelected");
            } else {
                session.setAttribute("colorSelected", s);
                findColor = (String) session.getAttribute("colorSelected");
            }
        } else {
            if (session.getAttribute("colorSelected") != null) {
                findColor = (String) session.getAttribute("colorSelected");
            }
        }
        if (!findColor.isEmpty()) {
            listProduct = productDAO.findByColor(findColor);
        }
        if (req.getParameter("sort") != null) {
            String a = req.getParameter("sort");
            if (a.equals("tang")) {
                for (int i = 0; i < listProduct.size(); i++) {
                    for (int j = i + 1; j < listProduct.size(); j++) {
                        if (listProduct.get(i).getPriceDouble() > listProduct.get(j).getPriceDouble()) {
                            double d = listProduct.get(i).getPriceDouble();
                            double e = listProduct.get(j).getPriceDouble();
                            DecimalFormat df = new DecimalFormat("0"); // định dạng số nguyên
                            String myString = df.format(d); // chuyển đổi double thành chuỗi String được định dạng  
                            DecimalFormat dfa = new DecimalFormat("0"); // định dạng số nguyên
                            String myString1 = dfa.format(e); // chuyển đổi double thành chuỗi String được định dạng  
                            listProduct.get(i).setPrice(String.valueOf(myString1));
                            listProduct.get(j).setPrice(String.valueOf(myString));
                        }
                    }
                }
            } else {
                for (int i = 0; i < listProduct.size(); i++) {
                    for (int j = i + 1; j < listProduct.size(); j++) {
                        if (listProduct.get(i).getPriceDouble() < listProduct.get(j).getPriceDouble()) {
                            double d = listProduct.get(i).getPriceDouble();
                            double e = listProduct.get(j).getPriceDouble();
                            DecimalFormat df = new DecimalFormat("0"); // định dạng số nguyên
                            String myString = df.format(d); // chuyển đổi double thành chuỗi String được định dạng  
                            DecimalFormat dfa = new DecimalFormat("0"); // định dạng số nguyên
                            String myString1 = dfa.format(e); // chuyển đổi double thành chuỗi String được định dạng  
                            listProduct.get(i).setPrice(String.valueOf(e));
                            listProduct.get(j).setPrice(String.valueOf(d));
                        }
                    }
                }
            }

        }
        //phan trang
        int size = listProduct.size();

        int numberPerPage = 9;
        int sizePage = 0;
        if (size % numberPerPage == 0) {
            sizePage = size / numberPerPage;
        } else {
            sizePage = size / numberPerPage + 1;
        }
        int page = 0;
        if (req.getParameter("page") == null) {
            page = 1;
        } else {
            page = Integer.parseInt(req.getParameter("page"));
        }
        int begin = numberPerPage * (page - 1);
        int end = Math.min(((numberPerPage * page) - 1), size - 1);

        listProduct = productDAO.paging(listProduct, begin, end);

        req.setAttribute("cateSelected", findCate);
        req.setAttribute("colorSelected", findColor);
        req.setAttribute("page", page);
        req.setAttribute("sizePage", sizePage);
        req.setAttribute("color", listColor);
        req.setAttribute("category", listCate);
        req.setAttribute("product", listProduct);
        req.getRequestDispatcher("Shopping.jsp").forward(req, resp);
    }

}
