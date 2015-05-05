package com.royalplate.royalplate.adapter;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.parse.ParseObject;
import com.royalplate.royalplate.CountItems;
import com.royalplate.royalplate.R;
import com.royalplate.royalplate.data.MenuData;
import com.royalplate.royalplate.data.SubMenuData;

import android.view.ViewGroup.LayoutParams;


/**
 * Created by hetu on 4/23/15.
 */
public class SubMenuAdapter extends ArrayAdapter<ParseObject>  {

    Context context;
    List<ParseObject> menuItems;
    int pluscount =0;
    int minuscount = 0;
    Map<Integer, Integer> noOfItems = new HashMap<Integer, Integer>();

    // Context is the SubMenuActivity
    // objects is the list of items
    public SubMenuAdapter(Context context, List<ParseObject> objects) {
        super(context, R.layout.listview_item, objects);
        this.context = context;
        this.menuItems = objects;

    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        String getItemPrice;
        String getItemID;


        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.listview_item, parent, false);

        // view id
        final TextView itemIdTextView = (TextView) view.findViewById(R.id.itemId);
        getItemID = Integer.toString(((SubMenuData) (menuItems.get(position))).getID());
        itemIdTextView.setText(getItemID);

        // view ItemName
        final TextView itemTextView = (TextView) view.findViewById((R.id.itemName));

        itemTextView.setText(((SubMenuData) (menuItems.get(position))).getName());

        // view Item Price
        TextView priceTextView = (TextView) view.findViewById(R.id.itemPrice);
        getItemPrice = Double.toString(((SubMenuData) (menuItems.get(position))).getPrice());
        priceTextView.setText(getItemPrice);

        /***************************
         * get total item numbers
         ***********************/
        final TextView numberofItems = (TextView) view.findViewById(R.id.no_of_items);

        final int getNumberofItems = Integer.parseInt(numberofItems.getText().toString());

        Log.i("tag", "getNumberof Items  " + getNumberofItems);
        /******************************************************************
         * Listen to + and  - button
         ******************************************************************/

        Button plusButton = (Button) view.findViewById((R.id.plusBtn));
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String item_name = itemIdTextView.getText().toString();
                int item_id = Integer.parseInt(Integer.toString(((SubMenuData) (menuItems.get(position))).getID()));
               if(getNumberofItems == 0){ pluscount = 1;}
                else{ pluscount = pluscount + getNumberofItems;}
                Log.i("tag", "pluscount Items  " + pluscount);


                    //check if key exists
                    if(noOfItems.containsKey(item_id)){ // if item_id found then

                        noOfItems.put(item_id, pluscount);
                        numberofItems.setText(Integer.toString(pluscount));
                        Log.i("tag", "display  " +  noOfItems.get(item_id));

                    }
                    else
                    {
                        noOfItems.put(item_id,pluscount);
                    }



            }
        });
        Button minuButton = (Button) view.findViewById((R.id.minusBtn));


//
//        minuButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                minuscount = pluscount-minuscount;
//                Log.i("test", "clicked--->" + itemTextView.getText().toString() + "  " + minuscount);
//
//            }
//        });


        /*******************************
         * Dynamically view items on the order panel
         *****************************/

//        RelativeLayout rl = (RelativeLayout)findViewById(R.id.relativeLayout1);
        ScrollView sv = new ScrollView(context);
//        sv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//        LinearLayout l1 = new LinearLayout(context);
//        l1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
//        l1.setOrientation(LinearLayout.VERTICAL);
//        sv.addView(l1);
//
//        TextView tv = new TextView(context);
//        tv.setText(itemTextView.getText().toString());
//        l1.addView(tv);


        return view;


    }

}
