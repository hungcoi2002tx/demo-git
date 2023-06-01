/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.CategoryDAO;
import DAO.ColorDAO;
import java.text.DecimalFormat;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Product {


    String id,name,price,color_id,category_id,quantity,storage,ram,battery,guarantee,sim,system,image,description,discount,year,origin,see;

    public Product() {
    }

    public Product(String id, String name, String price, String color_id, String category_id, String quantity, String storage, String ram, String battery, String guarantee, String sim, String system, String image, String description, String discount, String year, String origin, String see) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color_id = color_id;
        this.category_id = category_id;
        this.quantity = quantity;
        this.storage = storage;
        this.ram = ram;
        this.battery = battery;
        this.guarantee = guarantee;
        this.sim = sim;
        this.system = system;
        this.image = image;
        this.description = description;
        this.discount = discount;
        this.year = year;
        this.origin = origin;
        this.see = see;
    }

    public String getSee() {
        return see;
    }

    public void setSee(String see) {
        this.see = see;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
           
        this.price = price;
    }

    public String getColor_id() {
        return color_id;
    }

    public void setColor_id(String color_id) {
        this.color_id = color_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPriceDouble(){
        double d = Double.parseDouble(this.price);
        return d;
    }

    public String getBrand() {
        CategoryDAO cateDAO = new CategoryDAO();
        ArrayList<Category> list = cateDAO.getAll();
        for (Category category : list) {
            if (category.getId().equals(this.getCategory_id())) {
                return category.getName();
            }
        }
        return "NOBRAND";
    }

    public String getColor() {
        ColorDAO colorDAO = new ColorDAO();
        ArrayList<Color> list = colorDAO.getAll();
        
        for (Color color : list) {
            if (color.getId().equals(this.getColor_id())) {
                return color.getName();
            }
        }
        return "NOColor";
    }

    @Override
    public String toString() {
        String s = name + getColor();
        return s;
    }

    

}
