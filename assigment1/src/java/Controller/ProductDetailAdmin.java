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
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
@MultipartConfig

public class ProductDetailAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = req.getParameter("mode");
        String id = req.getParameter("id");
        ProductDAO productDAO = new ProductDAO();
        ArrayList<Category> listCate = new ArrayList<>();
        CategoryDAO cateDAO = new CategoryDAO();
        ArrayList<Color> listColor = new ArrayList<>();
        ColorDAO colorDAO = new ColorDAO();
        listColor = colorDAO.getAll();
        listCate = cateDAO.getAll();
        switch (mode) {
            case "insert":
                req.setAttribute("color", listColor);
                req.setAttribute("category", listCate);
                req.getRequestDispatcher("add-product.jsp").forward(req, resp);
                break;
            case "delete":
                productDAO.deleteById(id);
                req.getRequestDispatcher("product").forward(req, resp);
                break;
            case "update":
                Product p = new Product();
                p = productDAO.getProductById(id);
                req.setAttribute("color", listColor);
                req.setAttribute("category", listCate);
                req.setAttribute("product", p);
                req.getRequestDispatcher("update-product.jsp").forward(req, resp);
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String color = req.getParameter("color");
        String category = req.getParameter("category");
        String price = req.getParameter("price");
        String storage = req.getParameter("storage");
        String ram = req.getParameter("ram");
        String battery = req.getParameter("battery");
        String guarantee = req.getParameter("guarantee");
        String sim = req.getParameter("sim");
        String year = req.getParameter("year");
        String origin = req.getParameter("origin");
        String system = req.getParameter("system");
        String error = "";
        String fileName = ("");
        Part filePart = req.getPart("img");
        fileName = filePart.getSubmittedFileName();
        String imgOLD = req.getParameter("oldimg");
        System.out.println("[" + fileName + "]" + "  " + imgOLD);
        if (!fileName.isEmpty()) {
            String path = "E:\\PRJ301\\Project\\assigment1\\web\\assets\\img\\" + fileName;
            InputStream inputStream = filePart.getInputStream();
            Files.copy(inputStream, Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
        } else {
            fileName = imgOLD;
        }

        String desciption = req.getParameter("desciption");
        String mode = req.getParameter("mode");
        if (name.isEmpty() || price.isEmpty() || storage.isEmpty() || ram.isEmpty() || battery.isEmpty() || guarantee.isEmpty()
                || sim.isEmpty() || year.isEmpty() || origin.isEmpty() || system.isEmpty()) {
            error = "Some Thing is empty ";
            req.setAttribute("error", error);
            ProductDAO productDAO = new ProductDAO();
            ArrayList<Category> listCate = new ArrayList<>();
            CategoryDAO cateDAO = new CategoryDAO();
            ArrayList<Color> listColor = new ArrayList<>();
            ColorDAO colorDAO = new ColorDAO();
            listColor = colorDAO.getAll();
            listCate = cateDAO.getAll();
            req.setAttribute("color", listColor);
            req.setAttribute("category", listCate);
            if (mode.equals("insert")) {
                req.getRequestDispatcher("add-product.jsp").forward(req, resp);
            }
            if (mode.equals("update")) {
                Product p = new Product();
                p = productDAO.getProductById(id);
                req.setAttribute("product", p);
                req.getRequestDispatcher("update-product.jsp").forward(req, resp);
            }
            return;
        }

        ProductDAO proDAO = new ProductDAO();
        switch (mode) {
            case "insert":
                Product p = new Product("0", name, price, color, category, "0", storage, ram, battery, guarantee, sim, system, fileName, desciption, "0", year, origin,"0");
                proDAO.addProduct(p);
                req.getRequestDispatcher("product-admin").forward(req, resp);
                break;
            case "update":
                Product p1 = new Product(id, name, price, color, category, "0", storage, ram, battery, guarantee, sim, system, fileName, desciption, "0", year, origin,"0");
                proDAO.updateById(p1);
                req.getRequestDispatcher("product-admin").forward(req, resp);
                break;
        }
    }
}
