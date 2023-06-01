/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.ProductDAO;
import java.text.DecimalFormat;

/**
 *
 * @author Admin
 */
public class Stock {

    String id, product_id, quantity, price, date;

    public Stock() {
    }

    public Stock(String id, String product_id, String quantity, String price, String date) {
        this.id = id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProductName() {
        String name = "";
        ProductDAO dao = new ProductDAO();
        Product p = dao.getProductById(this.product_id);
        return p.getName();
    }

    public String getProductImage() {
        String name = "";
        ProductDAO dao = new ProductDAO();
        Product p = dao.getProductById(this.product_id);
        return p.getImage();
    }

    public String getTotal() {
        Double price1 = Double.parseDouble(this.price);
        int quantity1 = Integer.parseInt(this.quantity);
       
        DecimalFormat df = new DecimalFormat("0"); // định dạng số nguyên
        String myString = df.format(quantity1*price1); // chuyển đổi double thành chuỗi String được định dạng
        return myString;
    }
    
    public String getPriceString1(){
        String[] s = this.price.split("\\.");
        System.out.println(s[0] + "1");
        return s[0];
    }
    
}
