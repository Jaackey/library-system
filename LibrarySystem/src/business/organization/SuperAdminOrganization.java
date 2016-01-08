/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.role.Role;
import business.role.SuperAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Jackey
 */
public class SuperAdminOrganization extends Organization{

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SuperAdminRole());
        return roles;
    }
    
}
