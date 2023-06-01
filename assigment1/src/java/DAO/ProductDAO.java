/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ProductDAO extends DBContext {

    public ArrayList<Product> getAll() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select * from product";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String Product_ID = rs.getString("Product_ID");
                String Product_Name = rs.getString("Product_Name");
                String Price = rs.getString("Price");
                String Color_ID = rs.getString("Color_ID");
                String Category_ID = rs.getString("Category_ID");
                String Quantity = rs.getString("Quantity");
                String Storage = rs.getString("Storage");
                String Ram = rs.getString("Ram");
                String Battery = rs.getString("Battery");
                String Guarantee = rs.getString("Guarantee");
                String Number_Sim = rs.getString("Number_Sim");
                String System = rs.getString("System");
                String Image = rs.getString("Image");
                String Description = rs.getString("Description");
                String Discount = rs.getString("Discount");
                String Year = rs.getString("Year");
                String Origin = rs.getString("Origin");
                String see = rs.getString("See");
               
                Product p = new Product(Product_ID, Product_Name, Price, Color_ID, Category_ID, Quantity, Storage, Ram, Battery, Guarantee, Number_Sim, System, Image, Description, Discount, Year, Origin,see);
                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println("getALL + productDAO" + e.getMessage());
        }
        return list;
    }

    public void deleteById(String id) {
        String sql = "DELETE FROM Product\n"
                + "      WHERE Product_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();

        } catch (SQLException e) {
            System.out.println("deleteById + productDAO" + e.getMessage());
        }
    }

    public void updateById(Product p) {
        String sql = "UPDATE Product\n"
                + "   SET Product_Name = ?\n"
                + "      ,Price = ?\n"
                + "      ,Color_ID = ?\n"
                + "      ,Category_ID = ?\n"
                + "      ,Quantity = ?\n"
                + "      ,Storage = ?\n"
                + "      ,Ram = ?\n"
                + "      ,Battery = ?\n"
                + "      ,Guarantee = ?\n"
                + "      ,Number_Sim = ?\n"
                + "      ,System = ?\n"
                + "      ,Image = ?\n"
                + "      ,Description = ?\n"
                + "      ,Discount = ?\n"
                + "      ,Year = ?\n"
                + "      ,Origin = ?\n"
                + " WHERE Product_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getPrice());
            ps.setString(3, p.getColor_id());
            ps.setString(4, p.getCategory_id());
            ps.setString(5, p.getQuantity());
            ps.setString(6, p.getStorage());
            ps.setString(7, p.getRam());
            ps.setString(8, p.getBattery());
            ps.setString(9, p.getGuarantee());
            ps.setString(10, p.getSim());
            ps.setString(11, p.getSystem());
            ps.setString(12, p.getImage());
            ps.setString(13, p.getDescription());
            ps.setString(14, p.getDiscount());
            ps.setString(15, p.getYear());
            ps.setString(16, p.getOrigin());
            ps.setString(17, p.getId());
            ps.execute();

        } catch (SQLException e) {
            System.out.println("updateById " + e.getMessage());
        }
    }

    public void addProduct(Product p) {
        String sql = "INSERT INTO Product\n"
                + "           (Product_Name\n"
                + "           ,Price\n"
                + "           ,Color_ID\n"
                + "           ,Category_ID\n"
                + "           ,Quantity\n"
                + "           ,Storage\n"
                + "           ,Ram\n"
                + "           ,Battery\n"
                + "           ,Guarantee\n"
                + "           ,Number_Sim\n"
                + "           ,System\n"
                + "           ,Image\n"
                + "           ,Description\n"
                + "           ,Discount\n"
                + "           ,Year\n"
                + "           ,Origin"
                + "            ,see)\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getPrice());
            ps.setString(3, p.getColor_id());
            ps.setString(4, p.getCategory_id());
            ps.setString(5, p.getQuantity());
            ps.setString(6, p.getStorage());
            ps.setString(7, p.getRam());
            ps.setString(8, p.getBattery());
            ps.setString(9, p.getGuarantee());
            ps.setString(10, p.getSim());
            ps.setString(11, p.getSystem());
            ps.setString(12, p.getImage());
            ps.setString(13, p.getDescription());
            ps.setString(14, p.getDiscount());
            ps.setString(15, p.getYear());
            ps.setString(16, p.getOrigin());
            ps.setString(17, "0");
            ps.execute();

        } catch (SQLException e) {
            System.out.println("addProduct " + e.getMessage());
        }
    }

    public Product getProductById(String id) {
        String sql = "Select * FROM Product\n"
                + "      WHERE Product_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String Product_ID = rs.getString("Product_ID");
                String Product_Name = rs.getString("Product_Name");
                String Price = rs.getString("Price");
                String Color_ID = rs.getString("Color_ID");
                String Category_ID = rs.getString("Category_ID");
                String Quantity = rs.getString("Quantity");
                String Storage = rs.getString("Storage");
                String Ram = rs.getString("Ram");
                String Battery = rs.getString("Battery");
                String Guarantee = rs.getString("Guarantee");
                String Number_Sim = rs.getString("Number_Sim");
                String System = rs.getString("System");
                String Image = rs.getString("Image");
                String Description = rs.getString("Description");
                String Discount = rs.getString("Discount");
                String Year = rs.getString("Year");
                String Origin = rs.getString("Origin");
                String see = rs.getString("see");
                Product p = new Product(Product_ID, Product_Name, Price, Color_ID, Category_ID, Quantity, Storage, Ram, Battery, Guarantee, Number_Sim, System, Image, Description, Discount, Year, Origin,see);
                return p;
            }

        } catch (SQLException e) {
            System.out.println("getProductById + productDAO" + e.getMessage());
        }
        return null;
    }

    public ArrayList<Product> paging(ArrayList<Product> a, int begin, int end) {
        ArrayList<Product> listResult = new ArrayList<>();
        for (int i = begin; i <= end; i++) {
            listResult.add(a.get(i));
        }
        return listResult;
    }

    public ArrayList<Product> findByCate(String s) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select * from product where Category_ID = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String Product_ID = rs.getString("Product_ID");
                String Product_Name = rs.getString("Product_Name");
                String Price = rs.getString("Price");
                String Color_ID = rs.getString("Color_ID");
                String Category_ID = rs.getString("Category_ID");
                String Quantity = rs.getString("Quantity");
                String Storage = rs.getString("Storage");
                String Ram = rs.getString("Ram");
                String Battery = rs.getString("Battery");
                String Guarantee = rs.getString("Guarantee");
                String Number_Sim = rs.getString("Number_Sim");
                String System = rs.getString("System");
                String Image = rs.getString("Image");
                String Description = rs.getString("Description");
                String Discount = rs.getString("Discount");
                String Year = rs.getString("Year");
                String Origin = rs.getString("Origin");
                String see = rs.getString("see");
                Product p = new Product(Product_ID, Product_Name, Price, Color_ID, Category_ID, Quantity, Storage, Ram, Battery, Guarantee, Number_Sim, System, Image, Description, Discount, Year, Origin,see);
                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println("find + productDAO" + e.getMessage());
        }
        return list;
    }

    public ArrayList<Product> findByColor(String findColor) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select * from product where Color_ID = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, findColor);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String Product_ID = rs.getString("Product_ID");
                String Product_Name = rs.getString("Product_Name");
                String Price = rs.getString("Price");
                String Color_ID = rs.getString("Color_ID");
                String Category_ID = rs.getString("Category_ID");
                String Quantity = rs.getString("Quantity");
                String Storage = rs.getString("Storage");
                String Ram = rs.getString("Ram");
                String Battery = rs.getString("Battery");
                String Guarantee = rs.getString("Guarantee");
                String Number_Sim = rs.getString("Number_Sim");
                String System = rs.getString("System");
                String Image = rs.getString("Image");
                String Description = rs.getString("Description");
                String Discount = rs.getString("Discount");
                String Year = rs.getString("Year");
                String Origin = rs.getString("Origin");
                String see = rs.getString("see");
                Product p = new Product(Product_ID, Product_Name, Price, Color_ID, Category_ID, Quantity, Storage, Ram, Battery, Guarantee, Number_Sim, System, Image, Description, Discount, Year, Origin,see);
                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println("find + productDAO" + e.getMessage());
        }
        return list;
    }

    public void importQuantity(int quantity, String id) {
        String sql = "UPDATE Product set Quantity = ? where product_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setString(2, id);
            ps.execute();

        } catch (SQLException e) {
            System.out.println("importQuantity + productDAO" + e.getMessage());
        }
    }

    public int getSeeing(String id) {
        String sql = "Select see from Product where product_id = ?";
        String see = "";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                see = rs.getString(1);
            }
        }catch (SQLException e) {
            System.out.println("getSeeing + productDAO" + e.getMessage());
        }
        return Integer.parseInt(see);
    }

    public int importSeeing(String id) {
        String sql = "UPDATE Product set see = ? where product_id = ?";
        int x = getSeeing(id);
        try {
            PreparedStatement ps = connection.prepareStatement(sql);                      
            x=x+1;
            ps.setInt(1, x);  
            ps.setString(2, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("importQuantity + productDAO" + e.getMessage());
        }
        return x;
    }
}
