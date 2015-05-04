package com.royalplate.royalplate.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
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
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.royalplate.royalplate.HostessActivity;
import com.royalplate.royalplate.R;
import com.royalplate.royalplate.data.HostessData;
import com.royalplate.royalplate.data.SubMenuData;

import java.util.List;

/**
 * Created by hetu on 4/29/15.
 */

public class HostessAdapter extends ArrayAdapter<ParseObject> {

    Context context;
    List<ParseObject> hostessData;
    ListView waiterslistview;
    private PopupWindow popup;


    public HostessAdapter(Context context, List<ParseObject> objects){
        super(context, R.layout.listview_tables, objects);
        this.context = context;
        this.hostessData = objects;

    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.listview_tables, parent, false);

       final Button tableButton = (Button) view.findViewById((R.id.tableBtn));

        tableButton.setText(((HostessData) (hostessData.get(position))).getTable());
        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    LayoutInflater inflater = (LayoutInflater) context
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                    View view = inflater.inflate(R.layout.listview_waiter, parent, false);


                    CheckBox waitercheckbox = (CheckBox) view.findViewById(R.id.waiterchkbox);

                    waitercheckbox.setText(((HostessData) (hostessData.get(position))).getWaiter());

                    popup = new PopupWindow(view, 300, 370, true);
                    popup.showAtLocation(view, Gravity.CENTER, 0, 0);
                    popup.setBackgroundDrawable(new BitmapDrawable());
                    popup.setOutsideTouchable(true);
                    popup.setTouchable(true);
                    popup.setFocusable(true);
                    //the pop-up will be dismissed if touch event occurs anywhere outside its window
                    popup.setTouchInterceptor(new View.OnTouchListener() {
                        public boolean onTouch(View v, MotionEvent event) {
                            if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                                popup.dismiss();
                                return true;
                            }
                            return false;
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }



        });
        return view;
    }
//
//    private void QueryData() {
//
//        final ParseQuery<ParseObject> waiter_hostess = ParseQuery.getQuery("WaiterParse");
//        waiter_hostess.findInBackground(new FindCallback<ParseObject>() {
//
//            @Override
//            public void done(List<ParseObject> waiter_hostess, ParseException e) {
//                hostesAdapter = new HostessAdapter(HostessActivity.this, waiter_hostess);
//                waiterlistview.setAdapter(hostesAdapter);
//
//
//            }
//        });
//
//    }

}

