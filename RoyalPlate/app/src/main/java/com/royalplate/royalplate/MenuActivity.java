package com.royalplate.royalplate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by hetu on 4/9/15.
 */
public class MenuActivity extends Activity{

    private Spinner drinksSpinner;
    private Spinner saladsSpinner;
    private Spinner desertsSpinner;
    private static final String[]drinks = {"Drinks","Soda","Lemonade","Chai","Hot Chocolate" };
    private static final String[]salads = {"Salads", "salad1","salad2","salad3","salad4"};
    private static final String[]deserts = {"Deserts", "ice cream","cheese cake","pi"};

    private Button orderedButton;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

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

    /**
     * Created by hetu on 4/10/15.
     */
    public static class ChefActivity {
    }
}



