package com.royalplate.royalplate;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseObject;
import com.royalplate.royalplate.data.BurgerMenuData;
import com.royalplate.royalplate.data.DessertsMenuData;
import com.royalplate.royalplate.data.DrinkMenuData;
import com.royalplate.royalplate.data.FreshSaladsData;
import com.royalplate.royalplate.data.HaveitallMenuData;
import com.royalplate.royalplate.data.KidsMenuData;
import com.royalplate.royalplate.data.SandwichMenuData;
import com.royalplate.royalplate.data.TwoTwentyData;

/**
 * Created by operamac on 4/14/15.
 */
public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);


        // connect to sue's parse account
        Parse.initialize(this,
                getString(R.string.parse_app_id),
                getString(R.string.parse_client_id));

        ParseObject.registerSubclass(KidsMenuData.class);
        ParseObject.registerSubclass(FreshSaladsData.class);
        ParseObject.registerSubclass(DrinkMenuData.class);
        ParseObject.registerSubclass(HaveitallMenuData.class);
        ParseObject.registerSubclass(SandwichMenuData.class);
        ParseObject.registerSubclass(TwoTwentyData.class);
        ParseObject.registerSubclass(BurgerMenuData.class);
        ParseObject.registerSubclass(DessertsMenuData.class);

        // ParseObject.registerSubclass(ManuParse.class);

        Log.i("Application", "Initialized");
//
      // ParseUser.enableAutomaticUser();
//        ParseACL defaultACL = new ParseACL();

//        // If you would like all objects to be private by default, remove this line.
//        defaultACL.setPublicReadAccess(true);
//
//        ParseACL.setDefaultACL(defaultACL, true);

    }
}
