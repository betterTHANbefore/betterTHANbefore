package com.royalplate.royalplate;

import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.app.Activity;
/**
 * Created by hetu on 4/12/15.
 */
public class HostessActivity extends Activity implements OnTouchListener, OnDragListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hostess_activity);

        findViewById(R.id.table1).setOnTouchListener(this);
        findViewById(R.id.table2).setOnTouchListener(this);
        findViewById(R.id.table3).setOnTouchListener(this);

        findViewById(R.id.top_container).setOnDragListener(this);
        findViewById(R.id.bottom_container).setOnDragListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(null, shadowBuilder, v, 0);
            v.setVisibility(View.INVISIBLE);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onDrag(View v, DragEvent e) {
        if (e.getAction() == DragEvent.ACTION_DROP) {
            View view = (View) e.getLocalState();
            ViewGroup from = (ViewGroup) view.getParent();
            from.removeView(view);
            LinearLayout to = (LinearLayout) v;
            to.addView(view);
            view.setVisibility(View.VISIBLE);
        }
        return true;
    }

}