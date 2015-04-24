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
import com.royalplate.royalplate.data.KidsMenuParse;

/**
 * Created by hetu on 4/23/15.
 */
public class MenuAdapter extends ArrayAdapter<ParseObject> {

    Context context;
    List<ParseObject> menuItems;

// Context is the SubMenuActivity
    // objects is the list of items
    public MenuAdapter(Context context, List<ParseObject> objects) {
        super(context, R.layout.listview_item, objects);

     //   super(context, R.layout.list_testing, objects);

        this.context = context;
        this.menuItems = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Log.i("name", "show items from the kids menu");

      //  View view = inflater.inflate(R.layout.list_testing, parent, false);
        View view = inflater.inflate(R.layout.listview_item, parent, false);


       // Log.i("name", "show items from the kids menu");

        TextView textView = (TextView) view.findViewById((R.id.itemName));
        textView.setText("HELLOOOOOO");
//        textView.setText( (KidsMenuParse) menuItems.get(position).getName());

        return view;
    }

}
