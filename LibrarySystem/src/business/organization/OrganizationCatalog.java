/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author Jackey
 */
public class OrganizationCatalog {
    
    private ArrayList<Organization> organizationList;
    
    public OrganizationCatalog(){
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if(type.getValue().equals(Type.SuperAdmin.getValue())){
            organization = new SuperAdminOrganization();
            organizationList.add(organization);
        }
        if(type.getValue().equals(Type.LibraryAdmin.getValue())){
            organization = new LibraryAdminOrganization();
            organizationList.add(organization);
        }
        if(type.getValue().equals(Type.BookAdmin.getValue())){
            organization = new BookAdminOrganization();
            organizationList.add(organization);
        }
        if(type.getValue().equals(Type.Reader.getValue())){
            organization = new ReaderOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
}
