package com.royalplate.royalplate.adapter;

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

import com.royalplate.royalplate.R;
import com.royalplate.royalplate.data.WaiterData;

import java.util.List;

/**
 * Created by hetu on 5/2/15.
 */
public class WaiterAdapter extends ArrayAdapter<WaiterData> {
    List<WaiterData> waiterslist;
    ListView waiterListview;
    Context context;
PopupWindow popup;
    public WaiterAdapter(Context context, List<WaiterData> objects) {
        super(context, R.layout.listview_waiter, objects);
        this.context = context;
        this.waiterslist = objects;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.listview_waiter, parent, false);
  waiterListview = (ListView) view.findViewById(R.id.waiterslist);
        CheckBox waitercheckbox = (CheckBox) view.findViewById((R.id.waiterchkbox));
            waitercheckbox.setText(waiterslist.get(position).getWaiter());
//
                        try{
                        popup = new PopupWindow(view, 300, 470, true);
                //
                              //  popup.setBackgroundDrawable(d);

                                popup.setOutsideTouchable(true);
                                popup.setTouchable(true);
                               // popup.setFocusable(true);
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
                                popup.showAtLocation(view, Gravity.CENTER, 0, 0);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
        return view;
    }

}
