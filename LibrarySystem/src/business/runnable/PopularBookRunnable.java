/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.runnable;

import business.book.Book;
import business.library.Library;
import business.system.LibSystem;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Jackey
 */
public class PopularBookRunnable implements Runnable{

    private LibSystem system;
    
    public PopularBookRunnable(LibSystem system){
        this.system = system;
    }
    
    public void calculatePopularBook(){
        system.getPopularBookList().clear();
        for(Library library : system.getLibraryList()){
            for(Book book : library.getBookCatalog().getBookList()){
                book.setLibrary(library);
                system.getPopularBookList().add(book);
            }
        }
        
        Collections.sort(system.getPopularBookList(), new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2){
                Integer p1 = b1.getPopularity();
                Integer p2 = b2.getPopularity();
                return p2.compareTo(p1);
            }
        });
    }
    
    @Override
    public void run() {
        calculatePopularBook();
    }
    
    
}
