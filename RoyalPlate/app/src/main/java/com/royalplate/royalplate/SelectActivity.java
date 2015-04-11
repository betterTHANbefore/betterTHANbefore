package com.royalplate.royalplate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectActivity extends Activity{


    private Button waiterButton;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_activity);

        waiterButton = (Button)findViewById(R.id.waiter_button);
        waiterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent  waiterUI = new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(waiterUI);
            }
        });

    }


}