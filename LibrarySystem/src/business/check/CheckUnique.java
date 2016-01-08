/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.check;

import business.library.Library;
import business.organization.Organization;
import business.system.LibSystem;
import business.useraccount.UserAccount;

/**
 *
 * @author Jackey
 */
public class CheckUnique {
    
    public static boolean checkUniaue(LibSystem system, String username){
        for(UserAccount ua : system.getUserAccountCatalog().getUserAccountList()){
            if(ua.getUsername().equals(username)){
                return false;
            }
        }
        for(Organization organization : system.getOrganizationCatalog().getOrganizationList()){
            for(UserAccount userAccount : organization.getUserAccountCatalog().getUserAccountList()){
                if(userAccount.getUsername().equals(username)){
                    return false;
                }
            }
        }
        for(Library library : system.getLibraryList()){
            for(Organization org : library.getOrganizationCatalog().getOrganizationList()){
                for(UserAccount user : org.getUserAccountCatalog().getUserAccountList()){
                    if(user.getUsername().equals(username)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
