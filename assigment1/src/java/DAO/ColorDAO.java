/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Category;
import Model.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ColorDAO extends DBContext {

    public ArrayList<Color> getAll() {

        String sql = "SELECT *\n"
                + "  FROM Color";
        ArrayList<Color> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);

                Color c = new Color(id, name);
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println("getAll() + ColorDAO" + e.getMessage());
        }
        return list;

    }
}
