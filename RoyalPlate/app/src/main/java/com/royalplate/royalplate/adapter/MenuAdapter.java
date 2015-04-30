package com.royalplate.royalplate.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import com.parse.ParseObject;
import com.royalplate.royalplate.R;
import com.royalplate.royalplate.data.MenuData;

/**
 * Created by hetu on 4/23/15.
 */

public class MenuAdapter extends ArrayAdapter<ParseObject> {

    Context context;
    List<ParseObject> menuItems;

    //Context is the SubMenuActivity
    //objects is the list of items
    public MenuAdapter(Context context, List<ParseObject> objects) {
        super(context, R.layout.listview_item, objects);
        this.context = context;
        this.menuItems = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){

        String itemPriceStr;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.listview_item, parent, false);

        TextView itemTextView = (TextView) view.findViewById((R.id.itemName));

        itemTextView.setText(((MenuData) (menuItems.get(position))).getName());

        TextView priceTextView = (TextView) view.findViewById(R.id.itemPrice);
        itemPriceStr = Double.toString(((MenuData) (menuItems.get(position))).getPrice());
        priceTextView.setText(itemPriceStr);
        return view;
    }
}
