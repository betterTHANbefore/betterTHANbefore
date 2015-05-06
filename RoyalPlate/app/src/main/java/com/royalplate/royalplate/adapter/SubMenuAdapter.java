package com.royalplate.royalplate.adapter;


import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.List;

import com.parse.ParseObject;
import com.royalplate.royalplate.OrderedItem;
import com.royalplate.royalplate.R;
import com.royalplate.royalplate.data.SubMenuData;


/**
 * Created by hetu on 4/23/15.
 */
public class SubMenuAdapter extends ArrayAdapter<ParseObject>  {

    Context context;
    List<ParseObject> menuItems;
    double itemcost;
    String tableNo;
    int pluscount = 0;
    int minuscount = 0;

  //  TextView noOfItemsTextview;
   EditText noOfItemsTextview;
   List<OrderedItem> orderedList;
//    TextView itemTextView;



    //Map<String, Ordered> noOfItems = new HashMap<String, Ordered>();

    // Context is the SubMenuActivity
    // objects is the list of items
    public SubMenuAdapter(Context context, List<ParseObject> objects, double itemcost, String tableNo) {
        super(context, R.layout.listview_item, objects);
        this.context = context;
        this.menuItems = objects;
        this.itemcost = itemcost;
        this.tableNo = tableNo;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final String getItemPrice;
        String getItemID;
       final TextView itemTextView;


        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.listview_item, parent, false);

        // view id
        final TextView itemIdTextView = (TextView) view.findViewById(R.id.itemId);
        getItemID = Integer.toString(((SubMenuData) (menuItems.get(position))).getID());
        itemIdTextView.setText(getItemID);

        // view ItemName

        itemTextView = (TextView) view.findViewById((R.id.itemName));

        itemTextView.setText(((SubMenuData) (menuItems.get(position))).getName());

        final TextView priceTextView = (TextView) view.findViewById(R.id.itemPrice);
        getItemPrice = Double.toString(((SubMenuData) (menuItems.get(position))).getPrice());
        priceTextView.setText(getItemPrice);

        /******
         * select no of items from the number picker
         */
        NumberPicker np = (NumberPicker) view.findViewById(R.id.numberPicker);

        np.setMinValue(0);
        np.setMaxValue(10);
        np.setWrapSelectorWheel(false);

        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
             noOfItemsTextview = (EditText) view.findViewById(R.id.no_of_items);
                noOfItemsTextview.setText(String.valueOf(newVal));


                int noofitems = Integer.parseInt(noOfItemsTextview.getText().toString());
                double price = Double.parseDouble(getItemPrice); // give 2 decimal places

                //set the item price = (price * no of items)

                final TextView itempriceTextview = (TextView) view.findViewById(R.id.cost);
                double eachItemcost = price * noofitems;

                itempriceTextview.setText(String.format("%.2f", eachItemcost));

                // store Table 1, item name, price and no of items

                // into HashMap
                // display the list here


                // creates dynamic scrollView in SubmenuActivity to display

             //   ScrollView scrl  = (ScrollView) view.findViewById(R.id.scrollview);

//               // TextView display = (TextView) view.findViewById(R.id.orderedlist);
////                final LinearLayout ll = new LinearLayout(context);
////                ll.setOrientation(LinearLayout.VERTICAL);
//                    display.setText("fasdfa" + "  " +  "rere");
               // display.setMovementMethod(new ScrollingMovementMethod());
             noOfItemsTextview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
//
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {

          //  SubMenuAdapter.this.getFilter().filter(s);



                String outputedText = s.toString();
                int no = Integer.parseInt(s.toString());
                if(no != 0) {
                    // Log.i("NO", "Item   " + outputedText);
//                        LinearLayout displayLinearLayout = (LinearLayout) view.findViewById(R.id.orderedLayout);
//
//                        TextView display = new TextView(context);
//                        display.setText(itemIdTextView.getText());
//                        displayLinearLayout.addView(display);
                    Log.i("Test", "Item Name  " + itemTextView.getText() + " no of items" + outputedText);
                }
            }
        });


            }
        });
//        TextWatcher watcher = new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                String outputedText = s.toString();
////                int no = Integer.parseInt(s.toString());
////                if(no != 0) {
////                    // Log.i("NO", "Item   " + outputedText);
//////                        LinearLayout displayLinearLayout = (LinearLayout) view.findViewById(R.id.orderedLayout);
//////
//////                        TextView display = new TextView(context);
//////                        display.setText(itemIdTextView.getText());
//////                        displayLinearLayout.addView(display);
////                    Log.i("Test", "Item Name  " + itemTextView.getText() + " no of items" + outputedText);
////                }
//
//            }
//        };

//
        /***************************
         * get total item numbers from the noOfItems_editText
         ***********************/
//        final EditText noOfItems = (EditText) view.findViewById(R.id.noOfItems_editText);
//        noOfItems.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
////                int numberofItems = Integer.parseInt(noOfItems.getText().toString()); // convert String to int
////                Log.i("no", "no of items  " +  numberofItems);
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//               int numberofItems = Integer.parseInt(noOfItems.getText().toString()); // convert String to int
//                Log.i("no", "no of items  " +  numberofItems);
//
//
//            }
//        });


        //priceTextview = (TextView) findViewById(R.id.cost);
        //noOfItems = (TextView) findViewById(R.id.no_of_items);


//        try {
//            int iniItemCost = getIntentOld("iniPrice").getExtras().getInt("iniPrice");
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

//        final TextView numberofItems = (TextView) view.findViewById(R.id.no_of_items);
//
//        final int getNumberofItems = Integer.parseInt(numberofItems.getText().toString());
//
//       // Log.i("tag", "getNumberof Items  " + getNumberofItems);
//        /******************************************************************
//         * Listen to + and  - button
//         ******************************************************************/
//
//        Button plusButton = (Button) view.findViewById((R.id.plusBtn));
//        plusButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String item_name = itemIdTextView.getText().toString();
//                int item_id = Integer.parseInt(Integer.toString(((SubMenuData) (menuItems.get(position))).getID()));
//               if(getNumberofItems == 0){ pluscount = 1;}
//                else{ pluscount = pluscount + getNumberofItems;}
//                Log.i("tag", "pluscount Items  " + pluscount);
//
//
//                    //check if key exists
//                    if(noOfItems.containsKey(item_id)){ // if item_id found then
//
//                        noOfItems.put(item_id, pluscount);
//                        numberofItems.setText(Integer.toString(pluscount));
//                        Log.i("tag", "display  " +  noOfItems.get(item_id));
//
//                    }
//                    else
//                    {
//                        noOfItems.put(item_id,pluscount);
//                    }
//
//
//
//            }
//        });
//        Button minuButton = (Button) view.findViewById((R.id.minusBtn));
//

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