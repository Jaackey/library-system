/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.record;

import business.book.Book;
import business.library.Library;
import business.useraccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Jackey
 */
public class RecordItem {
    
    private Book book;
    private Date lentDate;
    private Date expDate;
    private UserAccount userAccount;
    private String status;
    private Library library;
    
    public RecordItem(){
        lentDate = new Date();
        expDate = new Date(lentDate.getTime() + 90L * 24L * 60L * 60L * 1000L);
    }

    public Book getBook() {
        return book;
    }

    public Date getLentDate() {
        return lentDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public String getStatus() {
        return status;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    
    @Override
    public String toString() {
        return status;
    }
    
    
}
