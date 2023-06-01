/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Category;
import Model.Stock;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class StockDAO extends DBContext {

    public ArrayList<Stock> getAll() {
        String sql = "SELECT *\n"
                + "  FROM Stock";
        ArrayList<Stock> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String pr_id = rs.getString(2);
                String quantity = rs.getString(3);
                String price = rs.getString(4);
                String date = rs.getString(5);
                Stock c = new Stock(id, pr_id, quantity, price, date);
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println("getAll() + stockDAO" + e.getMessage());
        }
        return list;
    }

    public void addStock(Stock s) {
        String sql = "INSERT INTO [dbo].[Stock]\n"
                + "           ([product_id]\n"
                + "           ,[quantity]\n"
                + "           ,[price]\n"
                + "           ,[date])\n"
                + "     VALUES\n"
                + "           (?,?,?,CONVERT(DATE, GETDATE()))";
        ArrayList<Stock> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getProduct_id());
            ps.setString(2, s.getQuantity());
            ps.setString(3, s.getPrice());
            ps.execute();
            
        } catch (SQLException e) {
            System.out.println("addStock() + StockDAO" + e.getMessage());
        }

    }
}
