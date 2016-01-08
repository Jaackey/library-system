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
import userinterface.libraryadmin.LibraryAdminJPanel;

/**
 *
 * @author Jackey
 */
public class LibraryAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Library library, LibSystem system) {
        return new LibraryAdminJPanel(userProcessContainer, library, system);
    }
    
}
