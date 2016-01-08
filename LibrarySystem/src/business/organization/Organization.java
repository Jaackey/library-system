/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.WorkQueue.WorkQueue;
import business.person.PersonCatalog;
import business.role.Role;
import business.useraccount.UserAccountCatalog;
import java.util.ArrayList;

/**
 *
 * @author Jackey
 */
public abstract class Organization {
    
    private String name;
    private WorkQueue workQueue;
    private PersonCatalog personCatalog;
    private UserAccountCatalog userAccountCatalog;
    private int organizationID;
    private static int counter;
    
    public enum Type{
        SuperAdmin("SuperAdmin Organization"), LibraryAdmin("LibraryAdmin Organization"), 
        BookAdmin("BookAdmin Organization"), Reader("Reader Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public Organization(){
        workQueue = new WorkQueue();
        personCatalog = new PersonCatalog();
        userAccountCatalog = new UserAccountCatalog();
        organizationID = counter;
        ++counter;
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        personCatalog = new PersonCatalog();
        userAccountCatalog = new UserAccountCatalog();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    

    public int getOrganizationID() {
        return organizationID;
    }
  
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }

    public PersonCatalog getPersonCatalog() {
        return personCatalog;
    }

    public UserAccountCatalog getUserAccountCatalog() {
        return userAccountCatalog;
    }
    
    
}
