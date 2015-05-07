package com.royalplate.royalplate;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.GridView;
import android.app.Activity;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.royalplate.royalplate.adapter.HostessAdapter;
import com.royalplate.royalplate.adapter.TableAdapter;
import com.royalplate.royalplate.adapter.WaiterAdapter;
import com.royalplate.royalplate.data.TablesData;
import com.royalplate.royalplate.data.WaiterData;

import java.util.List;

/**
 * Created by hetu on 4/12/15.
 */
public class HostessActivity extends FragmentActivity {


    GridView tablelistview;
    ListView waiterlistview;

    TableAdapter tableAdapter;
    WaiterAdapter waiterAdapter;
    HostessAdapter hostesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hostess_activity);
       // setContentView(R.layout.testing_waiter);

        loadTables();
        loadWaiters();

      //  loaddata();

        tablelistview = (GridView) findViewById(R.id.tablelist_left);


        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.fragmentContainer, new WaiterSelectorFragment()).commit();

//        tablelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
//
//            // to pass the text from that button to other UI or parse
//
//                Button tableButton = (Button) parent.getChildAt(position).findViewById(R.id.tableBtn);
//                final String tableno = tableButton.getText().toString();
//
//
//                Intent tablelistviewIntent = new Intent(HostessActivity.this,HostessActivity.class);
//                tablelistviewIntent.putExtra("hostess", tableno);
//                startActivity(tablelistviewIntent);
//
//            }
//        });
        waiterlistview = (ListView) findViewById(R.id.waiterslist_right);
//        waiterlistview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
//
//                CheckBox waitercheckbox = (CheckBox) parent.getChildAt(position).findViewById(R.id.waiterchkbox);
//                final String waitername = waitercheckbox.getText().toString();
//
//            }
//
//         });




//
//        waiterlistview = (ListView) findViewById(R.id.waiterslist_right);
//        waiterlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            //  listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Button waiterButton = (Button) parent.getChildAt(position).findViewById(R.id.waiterBtn);
//                final String waitername = waiterButton.getText().toString();
//
//                Intent tablelistviewIntent = new Intent(HostessActivity.this,HostessActivity.class);
//                tablelistviewIntent.putExtra("hostess", waitername);
//                startActivity(tablelistviewIntent);
//
//            }
//        });




//
//        findViewById(R.id.table1).setOnTouchListener(this);
//        findViewById(R.id.table2).setOnTouchListener(this);
//        findViewById(R.id.table3).setOnTouchListener(this);
//
//        findViewById(R.id.top_container).setOnDragListener(this);
//        findViewById(R.id.bottom_container).setOnDragListener(this);
    }

//    @Override
//    public boolean onTouch(View v, MotionEvent e) {
//        if (e.getAction() == MotionEvent.ACTION_DOWN) {
//            DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
//            v.startDrag(null, shadowBuilder, v, 0);
//            v.setVisibility(View.INVISIBLE);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    @Override
//    public boolean onDrag(View v, DragEvent e) {
//        if (e.getAction() == DragEvent.ACTION_DROP) {
//            View view = (View) e.getLocalState();
//            ViewGroup from = (ViewGroup) view.getParent();
//            from.removeView(view);
//            LinearLayout to = (LinearLayout) v;
//            to.addView(view);
//            view.setVisibility(View.VISIBLE);
//        }
//        return true;
//    }

    private void loadWaiters(){
       //final  ParseQuery<WaiterData> waiters = ParseQuery.getQuery("User");
        final ParseQuery<WaiterData> waiters = ParseQuery.getQuery("WaiterParse");
        waiters.findInBackground(new FindCallback<WaiterData>() {

            @Override
            public void done(List<WaiterData> waiters, ParseException e) {
                waiterAdapter = new WaiterAdapter(HostessActivity.this, waiters);
                waiterlistview.setAdapter(waiterAdapter);

            }
        });
    }

    private void loadTables() {

            final ParseQuery<TablesData> tables = ParseQuery.getQuery("TablesParse");
            tables.findInBackground(new FindCallback<TablesData>() {

                @Override
                public void done(List<TablesData> tables, ParseException e) {
                    tableAdapter = new TableAdapter(HostessActivity.this, tables);
                    tablelistview.setAdapter(tableAdapter);

                }

            });
    }

//        private void loaddata(){
//
//            final ParseQuery<ParseObject> table_hostess = ParseQuery.getQuery("TablesParse");
//            table_hostess.findInBackground(new FindCallback<ParseObject>() {
//
//                @Override
//                public void done(List<ParseObject> table_hostess, ParseException e) {
//                   hostesAdapter = new HostessAdapter(HostessActivity.this, table_hostess);
//                    tablelistview.setAdapter(hostesAdapter);
//
//
//                }
//            });
//            final ParseQuery<ParseObject> waiters = ParseQuery.getQuery("WaiterParse");
//            waiters.findInBackground(new FindCallback<ParseObject>() {
//
//                @Override
//                public void done(List<ParseObject> waiters, ParseException e) {
//                    hostesAdapter = new HostessAdapter(HostessActivity.this, waiters);
//                    waiterlistview.setAdapter(hostesAdapter);
//
//
//                }
//            });
//   }

}

