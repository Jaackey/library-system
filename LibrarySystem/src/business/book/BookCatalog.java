/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.book;

import java.util.ArrayList;

/**
 *
 * @author Jackey
 */
public class BookCatalog {
    
    private ArrayList<Book> bookList;
    
    public BookCatalog(){
        bookList = new ArrayList<>();
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }
    
}
