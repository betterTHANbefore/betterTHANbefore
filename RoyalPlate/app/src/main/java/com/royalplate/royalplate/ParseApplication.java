package com.royalplate.royalplate;



        import com.parse.Parse;
        import com.parse.ParseACL;

        import com.parse.ParseUser;

        import android.app.Application;
/**
 * Created by hetu on 4/20/15.
 */
public class ParseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);

        // TEST TEST TEST

        // connect to sue's parse account
        Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_id));

//        ParseUser.enableAutomaticUser();
//        ParseACL defaultACL = new ParseACL();

//        // If you would like all objects to be private by default, remove this line.
//        defaultACL.setPublicReadAccess(true);
//
//        ParseACL.setDefaultACL(defaultACL, true);
    }
}
