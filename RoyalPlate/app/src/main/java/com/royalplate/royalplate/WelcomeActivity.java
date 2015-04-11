package com.royalplate.royalplate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by hetu on 4/9/15.
 */
public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstancesState){
        super.onCreate((savedInstancesState));
        setContentView(R.layout.welcome_activity);
        ImageView logoImage = (ImageView)findViewById(R.id.royalplate_logo);

        logoImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent welcomeApp = new Intent(getApplicationContext(),SelectActivity.class);
                startActivity(welcomeApp);
            }
        });
    }

}





