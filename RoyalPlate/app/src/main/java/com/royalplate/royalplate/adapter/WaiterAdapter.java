package com.royalplate.royalplate.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.parse.ParseObject;
import com.royalplate.royalplate.HostessActivity;
import com.royalplate.royalplate.R;
import com.royalplate.royalplate.data.WaiterData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by hetu on 5/2/15.
 */
public class WaiterAdapter extends ArrayAdapter<WaiterData> {
    List<WaiterData> waiterslist;
    ListView waiterListview;
    Context context;
    HostessActivity hostessActivity;
    Set<String> waiternameSet;
    

    public WaiterAdapter(Context context, List<WaiterData> objects,HostessActivity hostessActivity) {
        super(context, R.layout.listview_waiter, objects);
        this.context = context;
        this.waiterslist = objects;
        this.hostessActivity = hostessActivity;
    }

//    public WatierAdapter(Context context, List<WaiterData> objects) {
//         super(context, R.layout.listview_waiter, objects);
    //    this.context = context;
//    this.waiterslist = objects;
//    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){


      //  final ArrayList<String> waitername = new ArrayList<String>();

      waiternameSet = new HashSet<String>();

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.listview_waiter, parent, false);
            waiterListview = (ListView) view.findViewById(R.id.waiterslist);

            final CheckBox waitercheckbox = (CheckBox) view.findViewById((R.id.waiterchkbox));
            waitercheckbox.setText(waiterslist.get(position).getWaiter());

            waitercheckbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("Tag", "clickedW");

                    final boolean isChecked = waitercheckbox.isChecked();
                    if(isChecked) {
                        String waitername = waitercheckbox.getText().toString();
                        waiternameSet.add(waitername);

                      //  hostessActivity.saveTableNumber(waitername);

                       // Log.i("Tag", "WaiterAdapter: table no  " + waitername);


                        Log.i("Tag", " set  " + waiternameSet);

                    }
                    hostessActivity.saveWaiterName((HashSet<String>) waiternameSet);
                }
            });
        //  hostessActivity.saveWaiterName((HashSet<String>) waiternameSet);

//
//                for(int i=0; i<waiterListview.getChildCount(); i++){
//                    waitercheckbox.setChecked(false);
//
//                }
        return view;
    }



}

