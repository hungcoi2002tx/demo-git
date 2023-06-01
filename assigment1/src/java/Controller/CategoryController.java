/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.CategoryDAO;
import Model.Category;
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
public class CategoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDAO cateDAO = new CategoryDAO();
        if (req.getParameter("mode") == null) {
            ArrayList<Category> list = cateDAO.getAll();
            req.setAttribute("listCATE", list);
            req.getRequestDispatcher("Category.jsp").forward(req, resp);
            
        } else if(req.getParameter("mode").equals("update")) {
            String mode = req.getParameter("mode");
            String id_2 = req.getParameter("id");
            Category c = cateDAO.findCateById(id_2);
            System.out.println(c);
            req.setAttribute("Category", c);
            req.getRequestDispatcher("UpdateCategory.jsp").forward(req, resp);
        }else{
            String id = (String) req.getParameter("id");
                //delete
                cateDAO.deleteById(id);
                resp.sendRedirect("category");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDAO cateDao = new CategoryDAO();
        Category c = new Category();
        //get mode
        String mode = (String) req.getParameter("mode");
        //choose mode
        switch (mode) {
            //mode add
            case "1":
                String name_1 = (String) req.getParameter("CateName");
                String description_1 = (String) req.getParameter("CateDes");
                String error = "";
                //check empty
                if (name_1.isEmpty() || description_1.isEmpty()) {
                    error = "Some input is Empty !";
                    req.setAttribute("error", error);
                    req.getRequestDispatcher("AddCategory.jsp").forward(req, resp);
                } else if (cateDao.checkDuplicate(name_1)) {
                    error = "Category name is exist !";
                    req.setAttribute("error", error);
                    req.getRequestDispatcher("UpdateCategory.jsp").forward(req, resp);
                }
                else {
                    cateDao.addCategory(name_1, description_1);
                    resp.sendRedirect("category");
                }
                break;
            //mode delete
            case "2":
                String id = (String) req.getParameter("id");
                //check empty
                cateDao.deleteById(id);
                resp.sendRedirect("category");
                break;
            //update 2:
            case "3":
                String id_3 = (req.getParameter("id"));
                String name_3 = (String) req.getParameter("CateName");
                String description_3 = (String) req.getParameter("CateDes");
                String error_3 = "";
                //check empty
                if (name_3.isEmpty() || description_3.isEmpty()) {
                    error = "Some input is Empty !";
                    req.setAttribute("error", error);
                    req.getRequestDispatcher("UpdateCategory.jsp").forward(req, resp);
                }
                 else {
                    Category c_3 = new Category(id_3, name_3, description_3);
                    cateDao.update(c_3);
                    resp.sendRedirect("category");

                }
                break;
            default:
                throw new AssertionError();
        }
    }

}
