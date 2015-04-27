package com.royalplate.royalplate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

import com.royalplate.royalplate.adapter.MenuAdapter;

/**
 * Created by hetu on 4/11/15.
 */
public class SubMenuActivity extends Activity {

    ListView listview;
    MenuAdapter menuAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submenu_activity);
        listview = (ListView) findViewById(R.id.itemlist);

//        String appetizerTitle;
//        String kidsMenuTitle;
        TextView subMenuTitle;
        Button goToMenuBtn;
        String title;
        /*****************************************************************
         * subMenuTitle TextView set the title according to which button
         * is pressed.
         * ImageView for tp set the images according to submenu to left
         * and right
         ****************************************************************/
        subMenuTitle = (TextView) findViewById(R.id.submenuTitle_textview);
        subMenuTitle.setText(getIntent().getExtras().getString("title"));

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

        /*****************************************************************************************
         * if order confirmed, order button send all the items ordered by the customer to the CHEF
         ******************************************************************************************/
        Button orderBtn = (Button) findViewById(R.id.orderbutton);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderBtnIntent = new Intent(getApplicationContext(), ChefActivity.class);
                startActivity(orderBtnIntent);
            }
        });
    }

    private void loadItems(String str) {

        final ParseQuery<ParseObject> items = ParseQuery.getQuery(str);

        items.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> items, ParseException e) {
                menuAdapter = new MenuAdapter(SubMenuActivity.this, items);
                listview.setAdapter(menuAdapter);
            }
        });
    }

}