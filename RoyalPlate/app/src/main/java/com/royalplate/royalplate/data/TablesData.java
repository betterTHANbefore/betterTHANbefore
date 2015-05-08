package com.royalplate.royalplate.data;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by hetu on 5/2/15.
 */
@ParseClassName("TablesParse")
public class TablesData extends ParseObject{
// public class TablesData extends HostessData{

    public TablesData(){}
    public String getTable(){
    return getString("TableNumber");
}

    public void setTable(String tablenumber) {
        put("TableNubmer", tablenumber);
    }
}
