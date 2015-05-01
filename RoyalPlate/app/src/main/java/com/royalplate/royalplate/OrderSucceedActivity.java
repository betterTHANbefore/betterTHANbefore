package com.royalplate.royalplate;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by operamac on 5/1/15.
 */
public class OrderSucceedActivity extends Activity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_succeed_activity);

        tv = (TextView) findViewById(R.id.table_num_view);
        tv.setText("Table " + getIntent().getExtras().getString("table no"));

    }
}
