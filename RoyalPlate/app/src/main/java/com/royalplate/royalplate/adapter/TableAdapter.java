package com.royalplate.royalplate.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.royalplate.royalplate.HostessActivity;
import com.royalplate.royalplate.R;
import com.royalplate.royalplate.data.TablesData;
import com.royalplate.royalplate.data.WaiterData;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by hetu on 5/2/15.
 */
public class TableAdapter extends ArrayAdapter<TablesData>{

    List<TablesData> tableslist;
    Context context;
    HostessActivity hostessActivity;



//    public TableAdapter(Context context, List<TablesData> objects) {
//        super(context, R.layout.listview_tables, objects);
//        this.context = context;
//        this.tableslist = objects;
//    }

    public TableAdapter(Context context, List<TablesData> objects, HostessActivity hostessActivity) {
        super(context, R.layout.listview_tables, objects);
        this.context = context;
        this.tableslist = objects;
        this.hostessActivity = hostessActivity;
    }



    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent){


       final ArrayList<String> tablenolist = new ArrayList<String>();



        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.listview_tables, parent, false);

        Log.i("size" ,  "" + "passed");

        final CheckBox tableButton = (CheckBox) view.findViewById((R.id.tableBtn));
        tableButton.setText(tableslist.get(position).getTable().toString());

        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.i("Tag", "clicked");


                final boolean isChecked = tableButton.isChecked();
                // do somthing here
                if(isChecked){
                     String tableno = tableButton.getText().toString();
                    tablenolist.add(tableno);

                    hostessActivity.saveTableNumber(tablenolist);


                 //   Intent tablebtnIntent = new Intent(context,HostessActivity.class);
                  //  tablebtnIntent.putStringArrayListExtra("TableNo", tablenolist);
//
//                      ParseObject parseObject = new ParseObject("WaiterTable");
//
//                    String tableno = tableButton.getText().toString();
//                    parseObject.put("Table No", tableno);
//
//
//                    parseObject.saveInBackground();
//





                }




            }
        });



//            tableButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                  final ParseQuery<WaiterData> waiters = new ParseQuery<WaiterData>( "WaiterParse");
//                     waiters.addAscendingOrder("WaiterName");
//
//
//                    waiters.findInBackground(new FindCallback<WaiterData>() {
//
//                    @Override
//                    public void done(List<WaiterData> waiterdata, com.parse.ParseException ee) {
//                        try {
//
//                                LayoutInflater inflater = (LayoutInflater) context
//                                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                //                View dialogview = inflater.inflate(R.layout.listview_waiter, parent, false);
//
//                            View dialogview = inflater.inflate(R.layout.testing_waiter, parent, false);
//
//
//                            waiterListview = (ListView) dialogview.findViewById(R.id.waiterslist);
////                            waiterAdapter = new WaiterAdapter(context, (List<WaiterData>) waiters);
////                            waiterListview.setAdapter(waiterAdapter);
//
//                                CheckBox waitercheckbox = (CheckBox) dialogview.findViewById((R.id.waiterchkbox));
//                                    waitercheckbox.setText(waiterdata.get(position).getWaiter());

//
//                            dialogbuilder = new AlertDialog.Builder(context);
//                            dialogbuilder.setTitle("Select Waiter");
//                            dialogbuilder.setView(dialogview)
//                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                                        @Override
//                                        public void onClick(DialogInterface dialog, int which) {
//
//                                        }
//                                    })
//                                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                                        public void onClick(DialogInterface dialog, int id){
//
//                                        }
//
//                                    });
//                            dialogbuilder.create();
//                            dialogbuilder.show();








//                                popup = new PopupWindow(view, 300, 470, true);
//
//                              //  popup.setBackgroundDrawable(d);
//
//                                popup.setOutsideTouchable(true);
//                                popup.setTouchable(true);
//                                popup.setFocusable(true);
//                                //the pop-up will be dismissed if touch event occurs anywhere outside its window
//                                popup.setTouchInterceptor(new View.OnTouchListener() {
//                                    public boolean onTouch(View v, MotionEvent event) {
//                                    if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
//                                        popup.dismiss();
//                                        return true;
//                                    }
//                                    return false;
//                                    }
//                                });
//                                popup.showAtLocation(view, Gravity.CENTER, 0, 0);
//
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        });

              //  }
    //  });
      return view;
    }





}
