/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.library.Library;
import business.organization.Organization;
import business.system.LibSystem;
import business.useraccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Jackey
 */
public abstract class Role {
    
    public enum RoleType{
        SuperAdmin("SuperAdmin"),
        LibraryAdmin("LibraryAdmin"),
        BookAdmin("BookAdmin"),
        Reader("Reader");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Library library, 
            LibSystem system);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
}
