/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.record;

import java.util.ArrayList;

/**
 *
 * @author Jackey
 */
public class LentRecord {
    
    private ArrayList<RecordItem> recordList;
    
    public LentRecord(){
        recordList = new ArrayList<>();
    }

    public ArrayList<RecordItem> getRecordList() {
        return recordList;
    }
    
}
