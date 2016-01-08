/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.runnable;

import business.book.Book;
import business.library.Library;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Jackey
 */
public class PurchaseNewBookRunnable implements Runnable{
    
    private Library library;
    private Book book;
    
    public PurchaseNewBookRunnable(Library library, Book book){
        this.library = library;
        this.book = book;
    }

    @Override
    public void run() {
        try{
            File file = new File("data/library/" + library.getName() + "/bookList.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.newLine();
            bw.write(book.getName() + "," + book.getAuthor() + "," + book.getPress()
                    + "," + book.getDate() + "," + book.getLocation() + "," +
                    book.getInprice() + "," + book.getAmount());
            bw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}
