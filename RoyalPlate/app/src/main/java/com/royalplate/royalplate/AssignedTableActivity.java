package com.royalplate.royalplate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by operamac on 5/1/15.
 */
public class AssignedTableActivity extends Activity {


    // temporaly, 3 table buttons statically.
    private Button[] tableButtons = new Button[3];
//    private Button tb;

//    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assigned_table_activity);


//        String tableNumStr = getText().toString().
        // FIX IT this may need to be grid or list rather than buttons
        tableButtons[0] = (Button) findViewById(R.id.rock);
        tableButtons[1] = (Button) findViewById(R.id.and);
        tableButtons[2] = (Button) findViewById(R.id.roll);

        tableButtons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("table no", "1");
                intent.putExtra("iniPrice" , 0);
                intent.putExtra("iniNoOfItem", 0);
//                Log.i("HELLO","AHHHHHHHHHHHHHHH");
                startActivity(intent);
                Log.i("HELLO", "AHHHHHHHHHHHHHHH");
            }
        });

        tableButtons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("table no", "2");
//                Log.i("HELLO","AHHHHHHHHHHHHHHH");
                startActivity(intent);
                Log.i("HELLO", "AHHHHHHHHHHHHHHH");
            }
        });

        tableButtons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("table no", "3");
//                Log.i("HELLO","AHHHHHHHHHHHHHHH");
                startActivity(intent);
                Log.i("HELLO", "AHHHHHHHHHHHHHHH");
            }
        });





    }
}
