package com.royalplate.royalplate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


/**
 * Created by hetu on 4/9/15.
 */
public class WelcomeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(final Bundle savedInstancesState){

        super.onCreate((savedInstancesState));
        setContentView(R.layout.welcome_activity);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_royalplate);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


//        anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.welcome_animation);
//
//        anim.setAnimationListener(this);

       ImageView logoImage = (ImageView)findViewById(R.id.royalplate_logo);

        logoImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent welcomeApp = new Intent(getApplicationContext(),SelectActivity.class);
                startActivity(welcomeApp);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
       // MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.menubar_icon, menu);
        menu.add(0,0,0,"RoyalPlate").setIcon(R.drawable.ic_royalplate);
        return super.onCreateOptionsMenu(menu);
    }


}





