/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.account;

import business.account.AccountItem.Type;
import java.util.ArrayList;

/**
 *
 * @author Jackey
 */
public class LibraryAccount {
    
    private ArrayList<AccountItem> accountList;
    
    public LibraryAccount(){
        accountList = new ArrayList<>();
    }

    public ArrayList<AccountItem> getAccountList() {
        return accountList;
    }

    public AccountItem createAccountItem(Type type){
        AccountItem accountItem = null;
        if(type.getValue().equals(Type.Income.getValue())){
            accountItem = new IncomeAccountItem();
            accountList.add(accountItem);
        }
        if(type.getValue().equals(Type.Spent.getValue())){
            accountItem = new SpentAccountItem();
            accountList.add(accountItem);
        }
        return accountItem;
    }
}
