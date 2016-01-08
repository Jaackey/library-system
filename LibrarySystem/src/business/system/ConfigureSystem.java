/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.system;

import business.library.Library;
import business.organization.LibraryAdminOrganization;
import business.organization.Organization;
import business.person.Person;
import business.role.LibraryAdminRole;
import business.role.SuperAdminRole;
import business.runnable.LibraryReadBookRunnable;
import business.useraccount.UserAccount;

/**
 *
 * @author Jackey
 */
public class ConfigureSystem {
    
    public static LibSystem configure(String name){
        
        LibSystem system = LibSystem.getInstance(name);
        
        Person person = system.getPersonCatalog().createPerson("Yuqi");
        
        system.getUserAccountCatalog().createUserAccount("superadmin", "superadmin", person, new SuperAdminRole());
        
        Library library = new Library("libtest");
        library.setAddress("test address");
        library.setTelNumber("test number");
        
        if(library.getBookCatalog().getBookList().isEmpty()){
            LibraryReadBookRunnable lrbr = new LibraryReadBookRunnable(library);
            Thread t1 = new Thread(lrbr);
            t1.start();
            try {
                t1.join();
            } catch (InterruptedException ex) {
                System.out.println("JOIN ERROR");
            }
        }
        for(Organization org : library.getOrganizationCatalog().getOrganizationList()){
            if(org instanceof LibraryAdminOrganization){
                Person p = library.getPersonCatalog().createPerson("libAdminTest");
                org.getUserAccountCatalog().createUserAccount("libadmin", "libadmin", p, new LibraryAdminRole());
            }
        }
        system.getLibraryList().add(library);
        
        Library library2 = new Library("libtest2");
        library2.setAddress("test address2");
        library2.setTelNumber("test number2");
        if(library2.getBookCatalog().getBookList().isEmpty()){
            LibraryReadBookRunnable lrbr2 = new LibraryReadBookRunnable(library2);
            Thread t2 = new Thread(lrbr2);
            t2.start();
            try {
                t2.join();
            } catch (InterruptedException ex) {
                System.out.println("JOIN ERROR");
            }
        }
        system.getLibraryList().add(library2);
        
        return system;
        
    }
}
