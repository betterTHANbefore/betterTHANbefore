package com.royalplate.royalplate;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.royalplate.royalplate.adapter.KidsMenuAdapter;
import com.royalplate.royalplate.data.KidsMenuParse;

import java.util.List;
/**
 * Created by hetu on 4/23/15.
 */
public class ListActivity extends ActionBarActivity{
ListView listView;
    KidsMenuAdapter kidsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    loadAllItems();



    }

    private void loadAllItems() {

        final ParseQuery<KidsMenuParse> kidsItem = ParseQuery.getQuery(KidsMenuParse.class);
        kidsItem.findInBackground(new FindCallback<KidsMenuParse>() {
            @Override
            public void done(List<KidsMenuParse> kidsItem, ParseException e) {
                kidsAdapter = new KidsMenuAdapter(ListActivity.this,  kidsItem);

                listView.setAdapter(kidsAdapter);
                Log.i("Name", "pass listview");
            }
        });

    }


}
