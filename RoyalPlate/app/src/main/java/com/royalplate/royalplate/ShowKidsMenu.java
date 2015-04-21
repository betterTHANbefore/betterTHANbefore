package com.royalplate.royalplate;

import java.util.List;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by hetu on 4/20/15.
 */
public class ShowKidsMenu extends Activity {
    // Declare Variables
    ListView listview;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.listview_main);
        // Execute RemoteDataTask AsyncTask
        new RemoteDataTask().execute();
    }
    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(ShowKidsMenu.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Parse.com Simple ListView Tutorial");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Locate the class table named "Country" in Parse.com
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                    "KidsMenu");
            query.orderByDescending("_created_at");
            try {
                ob = query.find();
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listview = (ListView) findViewById(R.id.listview);
            // Pass the results into an ArrayAdapter
            adapter = new ArrayAdapter<String>(ShowKidsMenu.this,
                    R.layout.listview_item);
            // Retrieve object "name" from Parse.com database
            for (ParseObject kidsmenu : ob) {
                adapter.add((String) kidsmenu.get("Item_Name"));
                adapter.add((String) kidsmenu.get("Item_Price"));

            }
            // Binds the Adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
            // Capture button clicks on ListView items
//            listview.setOnItemClickListener(new OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view,
//                                        int position, long id) {
//                    // Send single item click data to SingleItemView Class
//                    Intent i = new Intent(ShowKidsMenu.this,
//                            ShowKidsMenu.class);
//                    // Pass data "name" followed by the position
//                    i.putExtra("name", ob.get(position).getString("name")
//                            .toString());
//                    // Open SingleItemView.java Activity
//                    startActivity(i);
//                }
//            });
        }
    }
}