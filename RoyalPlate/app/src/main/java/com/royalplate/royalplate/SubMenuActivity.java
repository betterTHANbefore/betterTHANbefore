package com.royalplate.royalplate;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.widget.ListView;

import com.royalplate.royalplate.adapter.SubMenuAdapter;

/**
 * Created by hetu on 4/11/15.
 */
public class SubMenuActivity extends FragmentActivity {

    ListView listview;
    SubMenuAdapter menuAdapter;
String tableNumber;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.submenu_activity);
        listview = (ListView) findViewById(R.id.itemlist);

        TextView subMenuTitle;
        TextView tableNo;
        Button goToMenuBtn;
        String title;
        /*****************************************************************
         * subMenuTitle TextView set the title according to which button
         * is pressed.
         * ImageView for tp set the images according to submenu to left
         * and right
         ****************************************************************/

        subMenuTitle = (TextView) findViewById(R.id.submenuTitle_textview);
        subMenuTitle.setText(getIntent().getExtras().getString("title") + "    "+ getIntent().getExtras().getString("tableNo"));

       tableNumber = getIntent().getExtras().getString("tableNo"); // pass table no to adapter


       // tableNo = (TextView) findViewById(R.id.tableNo_textview);
        // lumpped text -> needs to get prettier
      //  tableNo.setText(getIntent().getExtras().getString("tableNo"));

        ImageView icon_right = (ImageView) findViewById(R.id.imageRight_icon);
        ImageView icon_left = (ImageView) findViewById(R.id.imageLeft_icon);
        /***************************************************************
         * get the text from the textview
         ***************************************************************/
        // title = subMenuTitle.getText().toString();

        title = getIntent().getExtras().getString("title");

        switch (title) {
            case "APPETIZER":
                // Image appears in ImageView widgets from the source file
                icon_right.setImageResource(R.drawable.fries);
                icon_left.setImageResource(R.drawable.chocolatemilk);
                loadItems("AppetizerMenuParse");
                break;

            case "BEVERAGES":
                // Image appears in ImageView widgets from the source file
                icon_right.setImageResource(R.drawable.fries);
                icon_left.setImageResource(R.drawable.chocolatemilk);
                loadItems("DrinkMenuParse");
                break;

            case "BURGERS":
                // Image appears in ImageView widgets from the source file
                icon_right.setImageResource(R.drawable.fries);
                icon_left.setImageResource(R.drawable.chocolatemilk);
                loadItems("BurgerMenuParse");
                break;

            case "DESSERTS":
                loadItems("DessertsMenuParse");
                break;

            case "ENTREES":
                loadItems("EntreesMenuParse");
                break;

            case "ENTREES & MAIN DISHES":
                loadItems("EntreesMainMenuParse");
                break;

            case "FRESH SALADS":
                // Image appears in ImageView widgets from the source file
                icon_right.setImageResource(R.drawable.gardensalad);
                icon_left.setImageResource(R.drawable.spinachsalad);
                loadItems("FreshSaladsParse");
                break;

            case "HAVE IT ALL":
                // Image appears in ImageView widgets from the source file

                icon_right.setImageResource(R.drawable.springrolls);
                icon_left.setImageResource(R.drawable.springrolls);
                loadItems("HaveitallMenuParse");
                break;

            case "KIDS":
                // Image appears in ImageView widgets from the source file
                icon_right.setImageResource(R.drawable.fries);
                loadItems("KidsMenuParse");
                break;

            case "LUNCH COMBOS":
                loadItems("LunchCombosMenuParse");
                break;

            case "NEW BAR MENU":
                loadItems("NewBarMenuParse");
                break;

            case "SANDWICHES":
                // Image appears in ImageView widgets from the source file
                icon_right.setImageResource(R.drawable.fries);
                icon_left.setImageResource(R.drawable.chocolatemilk);
                loadItems("SandwichMenuParse");
                break;

            case "2 FOR $20":
                // Image appears in ImageView widgets from the source file
                icon_right.setImageResource(R.drawable.fries);
                icon_left.setImageResource(R.drawable.chocolatemilk);
                loadItems("TwoTwenty");
                break;

            default:
                subMenuTitle.setText(getIntent().getExtras().getString("To go Main Manu"));
        }

        goToMenuBtn = (Button) findViewById(R.id.mainMenuBtn);
        goToMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMenuIntent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(goToMenuIntent);
            }
        });

        // this contains OrderListFragment class
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.fragmentContainer, new OrderListFragment()).commit();

//
//        Intent subMenuIntent = new Intent(SubMenuActivity.this, SubMenuAdapter.class);
//
//        int itemCost = getIntent().getExtras().getInt("iniPrice");
//        subMenuIntent.putExtra("iniPrice", itemCost);
//        int noItem = getIntent().getExtras().getInt("iniNoOfItem");
//        subMenuIntent.putExtra("iniNoOfItem", noItem);
       // startActivity(subMenuIntent);

    }

    private void loadItems(String str) {
             final int itemCost = getIntent().getExtras().getInt("iniPrice");

        final ParseQuery<ParseObject> items = ParseQuery.getQuery(str);
        items.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> items, ParseException e) {
                menuAdapter = new SubMenuAdapter(SubMenuActivity.this, items, itemCost, tableNumber );
                listview.setAdapter(menuAdapter);
            }
        });
    }

}


