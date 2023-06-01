/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CategoryDAO extends DBContext {

    public ArrayList<Category> getAll() {
        String sql = "SELECT *\n"
                + "  FROM Category";
        ArrayList<Category> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String description = rs.getString(3);
                Category c = new Category(id, name, description);
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println("getAll() + categoryDAO" + e.getMessage());
        }
        return list;
    }

    public boolean checkDuplicate(String name) {
        String sql = "SELECT *\n"
                + "  FROM Category";
        ArrayList<Category> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name_1 = rs.getString(2);
                if (name_1.equalsIgnoreCase(name)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("checkDuplicate + categoryDAO" + e.getMessage());
        }
        return false;
    }

    public void addCategory(String name, String description) {
        String sql = "INSERT INTO Category\n"
                + "     VALUES ( ? , ? )";
        ArrayList<Category> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("addCategory + categoryDAO" + e.getMessage());
        }

    }

    public Category findCateById(String id) {
        Category c = new Category();
        String sql = "Select * from Category where Category_ID = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                String des = rs.getString(3);
                c.setName(name);
                c.setDescription(des);
                c.setId(id);
            }
        } catch (SQLException e) {
            System.out.println("findCateByID + categoryDAO" + e.getMessage());
        }
        return c;
    }

    public void update(Category c_3) {
        String sql = "UPDATE Category\n"
                + "   SET Category_Name = ?\n"
                + "      ,Description = ?\n"
                + " WHERE Category_ID = ?";
        ArrayList<Category> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, c_3.getName());
            ps.setString(2, c_3.getDescription());
            ps.setString(3, c_3.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("update + categoryDAO" + e.getMessage());
        }

    }

    public void deleteById(String id) {
        System.out.println(id);
        String sql = "DELETE FROM Category\n"
                + "      WHERE Category_ID = ? ";
        ArrayList<Category> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("deleteById + categoryDAO" + e.getMessage());
        }
    }
}
