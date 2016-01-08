/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.book;

import business.library.Library;

/**
 *
 * @author Jackey
 */
public class Book {
    
    private String name;
    private String author;
    private String press;
    private String date;
    private String type;
    private Library library;
    private double inprice;
    private double price;
    private String location;
    private int amount;
    private int pledge; //TODO CALCULATE
    private int popularity;
    private String qrCodePath;

    public Book(){
        this.popularity = 0;
    }
    
    public int getPledge() {
        return pledge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getInprice() {
        return inprice;
    }

    public void setInprice(double inprice) {
        this.inprice = inprice;
        this.pledge = (int)inprice / 2;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public String getQrCodePath() {
        return qrCodePath;
    }

    public void setQrCodePath(String qrCodePath) {
        this.qrCodePath = qrCodePath;
    }
  
    
    @Override
    public String toString() {
        return name;
    }
    
    
    
}
