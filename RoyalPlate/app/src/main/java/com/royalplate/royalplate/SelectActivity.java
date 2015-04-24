package com.royalplate.royalplate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectActivity extends Activity{

    private Button hostessButton;
    private Button waiterButton;
    private Button chefButton;
    private Button managerButton;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_activity);

        hostessButton = (Button)findViewById(R.id.hostess_button);
        waiterButton = (Button)findViewById(R.id.waiter_button);
        chefButton = (Button)findViewById(R.id.chef_button);
        managerButton = (Button)findViewById(R.id.manager_button);

        hostessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hostessIntnet = new Intent(getApplicationContext(), HostessActivity.class);
                startActivity(hostessIntnet);
            }
        });

        waiterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent  waiterIntent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(waiterIntent);
            }
        });

        chefButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chefIntent = new Intent(getApplicationContext(), ChefActivity.class);
                startActivity(chefIntent);

            }
        });

        managerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent managerInten = new Intent(getApplicationContext(), ManagerActivity.class);
                startActivity(managerInten);
            }
        });

    }

}