package com.royalplate.royalplate;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.royalplate.royalplate.adapter.MenuAdapter;

import java.util.List;

/**
 * Created by operamac on 4/29/15.
 */

// This class belongs to SubMenuActivity
public class OrderListFragment extends Fragment {

    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_orderlist, container, false);
        Log.i("FRAGMET", "FROGGGGY");

        ParseObject poTest = new ParseObject("Table1");
        poTest.put("Test", "Mange Juice");
        poTest.put("Test", "Mil Juice");
        poTest.put("Test", "other Juice");
        poTest.put("Test", "barley Juice");

        poTest.saveInBackground();

//        ParseQuery pq = new ParseQuery("Table1");
//        pq.findInBackground(new FindCallback() {
//
//
//            @Override
//            public void done(Object o, Throwable throwable) {
//
//            }
//        });

        final Button orderBtn = (Button) v.findViewById(R.id.orderbutton);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // temporaly going back to MenuActivity
                Intent orderBtnIntent = new Intent(v.getContext(), OrderSucceedActivity.class);
//                orderBtnIntent.putExtra("table no", 1);
                String tableNum = getActivity().getIntent().getExtras().getString("tableNo");
                orderBtnIntent.putExtra("table no", tableNum);
                startActivity(orderBtnIntent);
            }
        });
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
