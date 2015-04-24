package com.royalplate.royalplate.data;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by hetu on 4/23/15.
 */
@ParseClassName("KidsMenuParse")
public class KidsMenuParse extends ParseObject {

    public KidsMenuParse() {
    }
    public String getName() {

        return getString("ItemName");
    }

    public void setName(String itemName) {

        put("ItemName", itemName);
    }

    public double getPrice() {

        return getDouble("ItemPrice");
    }

    public void setPrice(double price) {

        put("ItemPrice", price);
    }

}
