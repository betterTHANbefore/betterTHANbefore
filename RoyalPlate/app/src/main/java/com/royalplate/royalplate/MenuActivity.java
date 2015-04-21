package com.royalplate.royalplate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

/**
 * Created by hetu on 4/9/15.
 */
public class MenuActivity extends Activity{


    private Button orderedButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        final Button appetizerBtn = (Button)findViewById(R.id.appetizer_button);
        appetizerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent appIntent = new Intent(getApplicationContext(), ShowKidsMenu.class);
//                startActivity(appIntent);
//
//
//




                Intent appetizerIntent = new Intent(getApplicationContext(),SubMenuActivity.class);

                //pass title to next UI to show in a TextView
                appetizerIntent.putExtra("title", appetizerBtn.getText().toString());
                startActivity(appetizerIntent);


            }
        });

        final Button saladsBtn = (Button)findViewById(R.id.salads_button);
        saladsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appetizerIntent = new Intent(getApplicationContext(),SubMenuActivity.class);

                //pass title to next UI to show in a TextView
                appetizerIntent.putExtra("title", saladsBtn.getText().toString());
                startActivity(appetizerIntent);
            }
        });

        final Button burgersBtn = (Button) findViewById(R.id.burger_button);
        burgersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent burgerBtnIntent = new Intent(getApplicationContext(), SubMenuActivity.class);
                burgerBtnIntent.putExtra("title", burgersBtn.getText().toString());
                startActivity(burgerBtnIntent);
            }
        });

// add all other buttons activity here.


        final Button kidsMenuBtn = (Button)findViewById(R.id.kidsmenu_button);

        kidsMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kidsMenuIntent = new Intent(getApplicationContext(),SubMenuActivity.class);
                kidsMenuIntent.putExtra("title", kidsMenuBtn.getText().toString());
                startActivity(kidsMenuIntent);

            }
        });
        /**********************************************
         * if user clicks on the RoyalPlate logo, it will
         * activate the SelectActivity.
         *************************************************/

        //     final ImageView  royalplate = (ImageView) findViewById(R.id.royalplate_logo);
//        royalplate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent royalplateIntent = new Intent(getApplicationContext(), SelectActivity.class);
//                startActivity(royalplateIntent);
//            }
//        });

//        drinksSpinner = (Spinner)findViewById(R.id.drinks_spinner);
//        ArrayAdapter<String> drinksAdapter = new ArrayAdapter<String>(MenuActivity.this,android.R.layout.simple_spinner_item,drinks);
//
//        drinksAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        drinksSpinner.setAdapter(drinksAdapter);
//
//        saladsSpinner = (Spinner)findViewById(R.id.salads_spinner);
//        ArrayAdapter<String>saladsAdapter = new ArrayAdapter<String>(MenuActivity.this,android.R.layout.simple_spinner_item,salads);
//
//        saladsAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        saladsSpinner.setAdapter(saladsAdapter);
//
//        desertsSpinner = (Spinner)findViewById(R.id.deserts_spinner);
//        ArrayAdapter<String>desertsAdapter = new ArrayAdapter<String>(MenuActivity.this,android.R.layout.simple_spinner_item,deserts);
//
//        desertsAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        drinksSpinner.setAdapter(desertsAdapter);

//        orderedButton = (Button)findViewById(R.id.orderbutton);
//        orderedButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent chefUI = new Intent(getApplicationContext(),ChefActivity.class );
//                startActivity(chefUI);

        // }
        //      });








    }

}



