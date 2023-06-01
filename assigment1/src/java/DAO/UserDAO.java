/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Category;
import Model.User;
import com.oracle.wls.shaded.org.apache.bcel.generic.AALOAD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.tomcat.jakartaee.bcel.classfile.Code;

/**
 *
 * @author Admin
 */
public class UserDAO extends DBContext {

    public ArrayList<User> getAll() {
        String sql = "SELECT *"
                + "  FROM [User] where role = ? ";
        ArrayList<User> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "0");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String account = rs.getString(3);
                String pass = rs.getString(4);
                String Address = rs.getString(5);
                String Phone = rs.getString(6);
                String email = rs.getString(7);
                int role = Integer.parseInt(rs.getString(8));
                User u = new User(id, name, account, pass, Address, Phone, email, role);
                list.add(u);
            }
        } catch (SQLException e) {
            System.out.println("getAll() + userDAO" + e.getMessage());
        }
        return list;
    }

    public boolean checkDuplicateByAccount(String account) {
        String sql = "SELECT *"
                + "  FROM [User] where Account = ?";
        ArrayList<User> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("checkDuplicateByAccount() + userDAO" + e.getMessage());
        }
        return false;
    }

    public boolean checkDuplicateByEmail(String email) {
        String sql = "SELECT *"
                + "  FROM [User] where Email = ?";
        ArrayList<User> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("checkDuplicateByEmail() + userDAO" + e.getMessage());
        }
        return false;
    }

    public User checkLogin(String account, String pass, String role) {
        String sql = "SELECT *\n"
                + "  FROM [User] where Account = ? and Pass = ? and Role = ? ";
        ArrayList<User> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, pass);
            ps.setInt(3, Integer.parseInt(role));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String acc = rs.getString(3);
                String pas = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                User u = new User(id, name, account, pass, address, phone, email, Integer.parseInt(role));
                return u;
            }
        } catch (SQLException e) {
            System.out.println("checkLogin() + userDAO " + e.getMessage());
        }
        return null;
    }

    public void insertUser(User u) {
        String sql = "INSERT INTO [User]\n"
                + "           (UserName\n"
                + "           ,Account\n"
                + "           ,Pass\n"
                + "           ,Address\n"
                + "           ,Phone\n"
                + "           ,Email\n"
                + "           ,Role)\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getAccount());
            ps.setString(3, u.getPass());
            ps.setString(4, u.getAddress());
            ps.setString(5, u.getPhone());
            ps.setString(6, u.getEmail());
            ps.setInt(7, 0);
            ps.execute();

        } catch (SQLException e) {
            System.out.println("insertUser + userDAO " + e.getMessage());
        }

    }

    public User getUserById(String id) {
        String sql = "SELECT *"
                + "  FROM [User] where User_ID = ?";
        ArrayList<User> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                String acc = rs.getString(3);
                String pas = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                User u = new User(Integer.parseInt(id), name, acc, pas, address, phone, email, 0);
                return u;
            }
        } catch (SQLException e) {
            System.out.println("getUserById() + userDAO" + e.getMessage());
        }
        return null;
    }

    public void deleteUserById(String id) {
        String sql = "DELETE FROM [User]\n"
                + "      WHERE User_ID = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("deleteUserById() + userDAO" + e.getMessage());
        }
    }

    public void updateUser(User u) {
        String sql = "UPDATE [dbo].[User]\n"
                + "   SET [UserName] = ?\n"
                + "      ,[Account] = ?\n"
                + "      ,[Pass] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[Role] = ?\n"
                + " WHERE User_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getAccount());
            ps.setString(3, u.getPass());
            ps.setString(4, u.getAddress());
            ps.setString(5, u.getPhone());
            ps.setString(6, u.getEmail());
            ps.setInt(7, u.getRole());
            ps.setInt(8, u.getId());
            ps.execute();

        } catch (SQLException e) {
            System.out.println("updateUser + userDAO " + e.getMessage());
        }
    }

}
