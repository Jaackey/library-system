/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.library;

import business.account.LibraryAccount;
import business.book.BookCatalog;
import business.organization.Organization;
import business.organization.OrganizationCatalog;
import business.record.LentRecord;
import business.role.BookAdminRole;
import business.role.LibraryAdminRole;
import business.role.ReaderRole;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Jackey
 */
public class Library extends Organization{

    private String address;
    private String telNumber;
    private OrganizationCatalog organizationCatalog;
    private BookCatalog bookCatalog;
    private LibraryAccount libraryAccount;
    private LentRecord lentRecord;
    
    public Library(){
        super();
        lentRecord = new LentRecord();
        libraryAccount = new LibraryAccount();
        bookCatalog = new BookCatalog();
        organizationCatalog = new OrganizationCatalog();
        organizationCatalog.createOrganization(Type.Reader);
        organizationCatalog.createOrganization(Type.LibraryAdmin);
        organizationCatalog.createOrganization(Type.BookAdmin);
    }
    
    public Library(String name) {
        super(name);
        lentRecord = new LentRecord();
        libraryAccount = new LibraryAccount();
        bookCatalog = new BookCatalog();
        organizationCatalog = new OrganizationCatalog();
        organizationCatalog.createOrganization(Type.Reader);
        organizationCatalog.createOrganization(Type.LibraryAdmin);
        organizationCatalog.createOrganization(Type.BookAdmin);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new LibraryAdminRole());
        roleList.add(new BookAdminRole());
        roleList.add(new ReaderRole());
        return roleList;
    }

    public OrganizationCatalog getOrganizationCatalog() {
        return organizationCatalog;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public BookCatalog getBookCatalog() {
        return bookCatalog;
    }

    public LibraryAccount getLibraryAccount() {
        return libraryAccount;
    }

    public LentRecord getLentRecord() {
        return lentRecord;
    }
    
    
}
