package com.royalplate.royalplate;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.royalplate.royalplate.adapter.MenuAdapter;

import java.util.List;

/**
 * Created by operamac on 4/29/15.
 */

// This class belongs to SubMenuActivity
public class OrderListFragment extends Fragment {

    View v;

    String tableNumStr;
//    String itemName;
//    String noOfItems;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_orderlist, container, false);

        ParseObject poTest = new ParseObject("Table1");
        poTest.put("Test", "Mange Juice");
        poTest.put("Test", "Mil Juice");
        poTest.put("Test", "other Juice");
        poTest.put("Test", "barley Juice");

        poTest.saveInBackground();

        tableNumStr = getActivity().getIntent().getExtras().getString("tableNo");


        TextView tv = (TextView) v.findViewById(R.id.tableNo_textview);
        tv.setText(tableNumStr);

//        TextView listOfitems = (TextView) v.findViewById(R.id.orderedlist);
//
//        Log.i("OF", itemName + "   "+ noOfItems);
//        listOfitems.setText(itemName + " " + noOfItems);




        /**************************************************************************
         * getting itemName and noOfItems from Submenu Activity
         *
         * Go to SubMenuAdapter where actual data values are passed thru INTENT
         **************************************************************************/

        TextView noOfitemsTextview = (TextView) v.findViewById(R.id.orderednoOfItems);
        TextView listOfitemsTextview = (TextView) v.findViewById(R.id.orderedItemName);

      String  itemName = getActivity().getIntent().getExtras().getString("Item Name");
     String   noOfItems = getActivity().getIntent().getExtras().getString("No of Items");

        Log.i("OF", itemName + "   "+ noOfItems);

        noOfitemsTextview.setText(noOfItems);
        listOfitemsTextview.setText(itemName);









        final Button orderBtn = (Button) v.findViewById(R.id.orderbutton);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // temporaly going back to MenuActivity
                Intent orderBtnIntent = new Intent(v.getContext(), OrderSucceedActivity.class);

                orderBtnIntent.putExtra("tableNo", tableNumStr);

//                orderBtnIntent.putExtra("table no", 1);
                String tableNum = getActivity().getIntent().getExtras().getString("tableNo");
                orderBtnIntent.putExtra("table no", tableNum);

                startActivity(orderBtnIntent);
            }
        });

        return v;
    }

//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        TextView noOfitemsTextview = (TextView) v.findViewById(R.id.orderednoOfItems);
//        TextView listOfitemsTextview = (TextView) v.findViewById(R.id.orderedItemName);
//
//        /**************************************************************************
//         * getting itemName and noOfItems from Submenu Activity
//         **************************************************************************/
//        itemName = getActivity().getIntent().getExtras().getString("Item Name");
//        noOfItems = getActivity().getIntent().getExtras().getString("No of Items");
//
//        Log.i("OF", itemName + "   "+ noOfItems);
//
//        noOfitemsTextview.setText(noOfItems);
//        listOfitemsTextview.setText(itemName);
//    }
//
//    public void setText(){
//        TextView tv = (TextView) getActivity().findViewById(R.id.ordertitle);
//        tv.setText(tableNumStr);
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    public void setItemName(String itemName) {
//        this.itemName = itemName;
//    }
//
//    public String getItemName() {
//        return itemName;
//    }
//
//    public void setNoOfItems(String noOfItems) {
//        this.noOfItems = noOfItems;
//    }

}
