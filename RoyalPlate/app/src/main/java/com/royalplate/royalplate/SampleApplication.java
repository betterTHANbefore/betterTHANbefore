package com.royalplate.royalplate;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by operamac on 4/14/15.
 */
public class SampleApplication extends Application {
    @Override
    public void onCreate() {
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // TEST TEST TEST

        // connect to sue's parse account
        Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_id));

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);

    }
}
