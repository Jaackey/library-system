/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.system;

import business.book.Book;
import business.library.Library;
import business.organization.Organization;
import business.organization.OrganizationCatalog;
import business.role.LibraryAdminRole;
import business.role.Role;
import business.role.SuperAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Jackey
 */
public class LibSystem extends Organization{
    
    private static LibSystem system;
    private ArrayList<Library> libraryList;
    private OrganizationCatalog organizationCatalog;
    private ArrayList<Book> popularBookList;

    public LibSystem(){
        super();
    }
    
    public LibSystem(String name) {
        super(name);
        popularBookList = new ArrayList<>();
        libraryList = new ArrayList<>();
        organizationCatalog = new OrganizationCatalog();
        organizationCatalog.createOrganization(Type.Reader);
    }

    public static LibSystem getInstance(String name) {
        if (system == null) {
            system = new LibSystem(name);
        }
        return system;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SuperAdminRole());
        roleList.add(new LibraryAdminRole());
        return roleList;
    }

    public ArrayList<Library> getLibraryList() {
        return libraryList;
    }
    
    public Library createAndAddLibrary() {
        Library library = new Library();
        libraryList.add(library);
        return library;
    }

    public ArrayList<Book> getPopularBookList() {
        return popularBookList;
    }
    
    
    
//    public boolean checkIfUsernameIsUnique(String username) {
//
//        if (!this.getUserAccountCatalog().checkIfUsernameIsUnique(username)) {
//            return false;
//        }
//
//        for (Network network : networkList) {
//        }
//
//        return true;
//    }

    public OrganizationCatalog getOrganizationCatalog() {
        return organizationCatalog;
    }
}
