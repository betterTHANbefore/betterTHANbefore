package com.royalplate.royalplate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by hetu on 4/9/15.
 */
public class WelcomeToRoyalPlate_Activity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstancesState){
        super.onCreate((savedInstancesState));
        setContentView(R.layout.welcome_to_royalplate);

        Button logoButton = (Button)findViewById(R.id.royalplate_logo);
        logoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent welcomeApp = new Intent(getApplicationContext(),First_Activity.class);
                startActivity(welcomeApp);
            }
        });
    }

}





