package com.royalplate.royalplate.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import java.util.List;

import static com.royalplate.royalplate.R.id.waiterlist;
import static com.royalplate.royalplate.R.id.waiterslist;
import static com.royalplate.royalplate.R.id.waiterslist_right;

/**
 * Created by hetu on 5/2/15.
 */
public class TableAdapter extends ArrayAdapter<TablesData>{
    List<TablesData> tableslist;
    Context context;
    private PopupWindow popup;
    ListView waiterListview;
    WaiterAdapter waiterAdapter;
    AlertDialog.Builder dialogbuilder;

    public TableAdapter(Context context, List<TablesData> objects) {
        super(context, R.layout.listview_tables, objects);
        this.context = context;
        this.tableslist = objects;
    }


    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.listview_tables, parent, false);
        Log.i("size" ,  "" + "passed");

        final Button tableButton = (Button) view.findViewById((R.id.tableBtn));
            tableButton.setText(tableslist.get(position).getTable().toString());

            tableButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {





                    final ParseQuery<WaiterData> waiters = new ParseQuery<WaiterData>( "WaiterParse");
                     waiters.addAscendingOrder("WaiterName");


                    waiters.findInBackground(new FindCallback<WaiterData>() {

                    @Override
                    public void done(List<WaiterData> waiterdata, com.parse.ParseException ee) {
                        try {
                            waiterdata = waiters.find();

                                LayoutInflater inflater = (LayoutInflater) context
                                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                View view = inflater.inflate(R.layout.listview_waiter, parent, false);

                            Log.i("size" ,  "" + waiterdata.size());


                            waiterListview = (ListView) view.findViewById(R.id.waiterslist);
//                            waiterAdapter = new WaiterAdapter(context, (List<WaiterData>) waiters);
//                            waiterListview.setAdapter(waiterAdapter);

                                CheckBox waitercheckbox = (CheckBox) view.findViewById((R.id.waiterchkbox));
                                    waitercheckbox.setText(waiterdata.get(0).getWaiter());

//
                            dialogbuilder = new AlertDialog.Builder(context);
                            dialogbuilder.setView(view)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    })
                                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id){

                                        }

                                    });
                         dialogbuilder.create();








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

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        });

                }
      });
      return view;
    }
}
