package com.royalplate.royalplate;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class SelectActivity extends ActionBarActivity {

    private Button hostessButton;
    private Button waiterButton;
    private Button chefButton;
    private Button managerButton;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_activity);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_royalplate);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        hostessButton = (Button)findViewById(R.id.hostess_button);
        waiterButton = (Button)findViewById(R.id.waiter_button);
        chefButton = (Button)findViewById(R.id.chef_button);
        managerButton = (Button)findViewById(R.id.manager_button);

        hostessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent hostessIntent = new Intent(getApplicationContext(), HostessActivity.class);


                startActivity(hostessIntent);
            }
        });

        waiterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // AssignedTableActivity bypass
                Intent  waiterIntent = new Intent(getApplicationContext(), AssignedTableActivity.class);
                // Below Intent initialization for normal flow
//                Intent  waiterIntent = new Intent(getApplicationContext(), SignupOrLoginActivity.class);
//                Below line is for login bypass
//                Intent  waiterIntent = new Intent(getApplicationContext(), MenuActivity.class);
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
                Intent managerIntent = new Intent(getApplicationContext(), ManagerActivity.class);
                startActivity(managerIntent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubar_icon, menu);
        menu.add("RoyalPlate");
        return super.onCreateOptionsMenu(menu);
    }

}