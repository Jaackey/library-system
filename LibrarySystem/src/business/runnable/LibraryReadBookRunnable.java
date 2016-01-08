/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.runnable;

import business.book.Book;
import business.library.Library;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Jackey
 */
public class LibraryReadBookRunnable implements Runnable{

    private Library library;
    
    public LibraryReadBookRunnable(Library library){
        this.library = library;
    }
    
    public void readBook(){
        try{
            BufferedReader in = new BufferedReader(new FileReader("data/library/" + library.getName() + "/bookList.txt"));
            Scanner inLine = new Scanner(in);
            while(inLine.hasNextLine()){
            String inputLine = inLine.nextLine();
            Scanner sc = new Scanner(inputLine);
            sc.useDelimiter(",");
            String name = sc.next();
            String author = sc.next();
            String press = sc.next();
            String date = sc.next();
            String location = sc.next();
            double inprice = sc.nextDouble();
            int amount = sc.nextInt();
            Book book = new Book();
            book.setName(name);
            book.setAuthor(author);
            book.setPress(press);
            book.setDate(date);
            book.setLocation(location);
            book.setInprice(inprice);
            book.setAmount(amount);
            library.getBookCatalog().getBookList().add(book);
            sc.close();
            }
        } catch(FileNotFoundException ex) {
            //Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        readBook();
    }
    
}
