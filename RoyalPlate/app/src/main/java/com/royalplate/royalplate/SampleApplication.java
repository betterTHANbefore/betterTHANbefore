package com.royalplate.royalplate;

import android.app.Application;
import com.parse.Parse;
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
    }
}
