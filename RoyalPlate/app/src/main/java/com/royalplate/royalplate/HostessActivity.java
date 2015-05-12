package com.royalplate.royalplate;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static android.view.View.OnClickListener;

/**
 * Created by hetu on 4/12/15.
 */
public class HostessActivity extends Activity implements OnClickListener{


    GridView tablelistview;
    ListView waiterlistview;

    TableAdapter tableAdapter;
    WaiterAdapter waiterAdapter;
    Button assignedButton;
    SharedPreferences sharedtable;
    SharedPreferences sharedwaiter;
    SharedPreferences.Editor waitereditor;
    SharedPreferences.Editor tableeditor;
    Map<String, Set<String>> waitertables;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hostess_activity);
        // setContentView(R.layout.testing_waiter);

        loadTables();
        loadWaiters();

       // loaddata();

        tablelistview = (GridView) findViewById(R.id.tablelist_left);


        /********************
         * CheckBox listener
         ******************/


//
//        tablelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
//
//            // to pass the text from that button to other UI or parse
//
//                CheckBox tableButton = (CheckBox) parent.getChildAt(position).findViewById(R.id.tableBtn);
//                final String tableno = tableButton.getText().toString();
//                Log.i("Tag", "table no  "+ tableno);
////
////                Intent tablelistviewIntent = new Intent(HostessActivity.this,HostessActivity.class);
////                tablelistviewIntent.putExtra("hostess", tableno);
////                startActivity(tablelistviewIntent);
//
//            }
//        });
        waiterlistview = (ListView) findViewById(R.id.waiterslist_right);

        /********************
         * CheckBox listener
         ******************/





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

        Log.i("TAg", "Assignedbutton got NOT clicked");




        assignedButton = (Button) findViewById(R.id.assignedBtn);
        assignedButton.setOnClickListener(this);

//        assignedButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /***********************************************************************************
//                 * if assigned button is clicked, store data values from the checkboxes
//                 **********************************************************************************/
//              String  table = getIntent().getExtras().getString("TableNo");
//
//
//
//            Log.i("TAg", "Assignedbutton got clicked");
//             Log.i("Tag", "Table no " + table);
//
//
//
//
//
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
//                waiterAdapter = new WaiterAdapter(HostessActivity.this, waiters,getBaseContext());
                waiterAdapter = new WaiterAdapter(getBaseContext(), waiters,HostessActivity.this);

                waiterlistview.setAdapter(waiterAdapter);

            }
        });
    }

    private void loadTables() {

        final ParseQuery<TablesData> tables = ParseQuery.getQuery("TablesParse");
        tables.findInBackground(new FindCallback<TablesData>() {

            @Override
            public void done(List<TablesData> tables, ParseException e) {
               //tableAdapter = new TableAdapter(HostessActivity.this, tables);

                tableAdapter = new TableAdapter(getBaseContext(), tables, HostessActivity.this);

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

    public HostessActivity(){

    }

    public void saveTableNumber(HashSet<String> tablelist){

//       sharedtable = PreferenceManager.getDefaultSharedPreferences(this);
        sharedtable = PreferenceManager.getDefaultSharedPreferences(this);


//        SharedPreferences.Editor tableeditor = sharedtable.edit();
        tableeditor = sharedtable.edit();

        tableeditor.clear();
        tableeditor.putStringSet("TableNo", tablelist);

        tableeditor.apply();
    }




    public void saveWaiterName(HashSet<String> waiternameset){

        sharedwaiter = PreferenceManager.getDefaultSharedPreferences(this);

//        SharedPreferences.Editor waitereditor = sharedwaiter.edit();
        waitereditor = sharedwaiter.edit();


        waitereditor.clear();
        waitereditor.putStringSet("WaiterName", waiternameset);

        waitereditor.apply();
    }


    @Override
    public void onClick(View v) {

//        Log.i("Tag", "HA:  " + sharedtable.getStringSet("TableNo", new HashSet<String>()).size());

        Log.i("Tag", "HA:  " + sharedtable.getStringSet("TableNo", new HashSet<String>()));

        Log.i("Tag", "HA:  " + sharedwaiter.getStringSet("WaiterName", new HashSet<String>()));

        Set<String> tableSet = sharedtable.getStringSet("TableNo", new HashSet<String>());
        Set<String> waiterSet = sharedwaiter.getStringSet("WaiterName", new HashSet<String>());


        int waitersetSize = sharedwaiter.getStringSet("WaiterName", new HashSet<String>()).size();
        int tablesetSize = sharedtable.getStringSet("TableNo", new HashSet<String>()).size();

        for(String table : tableSet) {
            Log.i("Tag", "TSet " + table);
        }
        for(String waiter : waiterSet) {
            Log.i("Tag", "WSet " + waiter);
        }

        // each waiter from the watierset get the set of tables she has been assigned
        // outer for loop reads watierset and inner reads tableset

        for(String waiter : waiterSet){
            for(String table : tableSet) {


                waitertables.put(waiter, tableSet);
            }


        }

        for (Map.Entry<String,Set<String>> entry : waitertables.entrySet()) {
            String key = entry.getKey();
//            for(String table : tableSet) {
//                Log.i("Tag", "TSet " +key + "   " + table);
//            }
        }

//        for(String key : waitertables.keySet()){
//            Log.i("tag", key +  "  " + waitertables.get(key));
//        }
//        for  (Map.Entry<String, String> e : waitertables.entrySet()) {
//           Log.i("Tag" , e.getKey()+"="+e.getValue());
//        }
      //  Log.i("Tag", "Map size" + waitertables.size());

    }



}
