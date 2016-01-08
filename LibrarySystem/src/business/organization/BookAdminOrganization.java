/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.role.BookAdminRole;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Jackey
 */
public class BookAdminOrganization extends Organization{

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new BookAdminRole());
        return roles;
    }
    
}
