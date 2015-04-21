package com.royalplate.royalplate;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import com.parse.ParseObject;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ProgressDialog;
import android.util.Log;

import java.util.List;

/**
 * Created by hetu on 4/11/15.
 */
public class SubMenuActivity extends Activity{
    ListView listview;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ArrayAdapter<String> adapter;




    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submenu_activity);

//        // Execute RemoteDataTask AsyncTask
//        new RemoteDataTask().execute();
//        // RemoteDataTask AsyncTask
        // Execute RemoteDataTask AsyncTask
        new RemoteDataTask().execute();
        // RemoteDataTask AsyncTask



        String appetizerTitle;
        String kidsMenuTitle;
        TextView subMenuTitle;
        Button goToMenuBtn;
        String title;
        /*****************************************************************
         * subMenuTitle TextView set the title according to which button
         * is pressed.
         * ImageView for tp set the images according to submenu to left
         * and right
         ****************************************************************/
        subMenuTitle = (TextView)findViewById(R.id.submenuTitle_textview);
        subMenuTitle.setText(getIntent().getExtras().getString("title"));

        ImageView icon_right = (ImageView) findViewById(R.id.imageRight_icon);
        ImageView icon_left = (ImageView) findViewById(R.id.imageLeft_icon);
        /***************************************************************
         * get the text from the textview
         ***************************************************************/
        title = subMenuTitle.getText().toString();


        switch(title) {

            case "APPETIZER":

                // Image appears in ImageView widgets from the source file

                icon_right.setImageResource(R.drawable.springrolls);
                icon_left.setImageResource(R.drawable.springrolls);


                break;

            case "SALADS":
                // Image appears in ImageView widgets from the source file
                icon_right.setImageResource(R.drawable.gardensalad);
                icon_left.setImageResource(R.drawable.spinachsalad);
                break;

            case "KIDS MENU":
                // Image appears in ImageView widgets from the source file
                icon_right.setImageResource(R.drawable.fries);
                icon_left.setImageResource(R.drawable.chocolatemilk);


                break;

            default:
                subMenuTitle.setText(getIntent().getExtras().getString("To go Main Manu"));
        }


        goToMenuBtn = (Button)findViewById(R.id.mainMenuBtn);
        goToMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent goToMenuIntent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(goToMenuIntent);
            }
        });

        /*****************************************************************************************
         * if order confirmed, order button send all the items ordered by the customer to the CHEF
         ******************************************************************************************/
        Button orderBtn = (Button) findViewById(R.id.orderbutton);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderBtnIntent = new Intent(getApplicationContext(), ChefActivity.class);
                startActivity(orderBtnIntent);
            }
        });
    }
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(SubMenuActivity.this);
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
          //  query.orderByDescending("_created_at");
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
            adapter = new ArrayAdapter<String>(SubMenuActivity.this,
                    R.layout.listview_item);
            // Retrieve object "name" from Parse.com database
            for (ParseObject kidsmenu : ob) {
                adapter.add((String) kidsmenu.get("Item_Name"));
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
