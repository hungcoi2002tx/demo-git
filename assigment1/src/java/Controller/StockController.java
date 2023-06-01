/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ProductDAO;
import DAO.StockDAO;
import Model.Product;
import Model.Stock;
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
public class StockController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("id") == null) {
            ProductDAO productDAO = new ProductDAO();
            ArrayList<Product> list = productDAO.getAll();
            req.setAttribute("list_Product", list);
            req.getRequestDispatcher("Stock_Product.jsp").forward(req, resp);
        } else {
            String id = req.getParameter("id");
            ProductDAO dao = new ProductDAO();
            Product p = dao.getProductById(id);
            req.setAttribute("product", p);
            req.getRequestDispatcher("Stock-Import.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = req.getParameter("mode");
        switch (mode) {
            case "import":
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                int price = Integer.parseInt(req.getParameter("price"));
                ProductDAO dao = new ProductDAO();
                String id = req.getParameter("id");
                Product p = dao.getProductById(id);
                StockDAO stockDAO = new StockDAO();
                Stock s = new Stock("0", id, String.valueOf(quantity), String.valueOf(price), "0");
                stockDAO.addStock(s);
                quantity = Integer.parseInt(p.getQuantity()) + quantity;
                dao.importQuantity(quantity,id);
                resp.sendRedirect("stock-display-admin");
                break;
            default:
                throw new AssertionError();
        }
    }

}
