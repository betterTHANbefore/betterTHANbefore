package com.royalplate.royalplate;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class WaiterActivity extends ActionBarActivity {


    private Spinner tableSpinner;
    private static final String[]tables = {"Choose Table#","Table 1","Table 2","Table 3","Table 4" };
    private Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.royalplate_setting_activity);


        tableSpinner = (Spinner)findViewById(R.id.table_spinner);
        ArrayAdapter<String> tableAdapter = new ArrayAdapter<String>(WaiterActivity.this,android.R.layout.simple_spinner_item,tables);

        tableAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        tableSpinner.setAdapter(tableAdapter);
        // tableSpinner.setOnItemClickListener(this);


        /*******************************************************
         * Go to Menu button listener switchs to Menu Items UI
         ******************************************************/
        menuButton = (Button)findViewById(R.id.menuBtn);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent menuUI = new Intent(getApplicationContext(),Menu_Items_Activity.class );
//                startActivity(menuUI);
            }
        });



    }

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_royal_plate__main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
