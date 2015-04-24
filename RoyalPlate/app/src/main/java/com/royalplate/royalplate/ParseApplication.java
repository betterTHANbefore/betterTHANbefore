package com.royalplate.royalplate;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseObject;
import com.royalplate.royalplate.data.KidsMenuData;

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
