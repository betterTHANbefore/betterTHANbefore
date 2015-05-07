package com.royalplate.royalplate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.royalplate.royalplate.adapter.MainMenuAdapter;
import com.royalplate.royalplate.data.MainMenuData;

import java.util.List;



/**
 * Created by hetu on 4/9/15.
 */
public class MenuActivity extends Activity implements SimpleGestureFilter.SimpleGestureListener {

    ListView listview;
    GridView gridview;
    MainMenuAdapter mainMenuAdapter;

    private Button orderedButton;
    private TextView tableNumView;
    private String menuItemName;
    private String tableNum;


    private SimpleGestureFilter detector;
    private boolean leftSwipeFlag = false;

    @Override
    public void onSwipe(int direction) {
        String str = "";

        switch (direction) {

            case SimpleGestureFilter.SWIPE_RIGHT : str = "Swipe Right";
                break;
            case SimpleGestureFilter.SWIPE_LEFT :  str = "Swipe Left";
                Log.i("SWIPE","TO THE LEFT");
                break;
            case SimpleGestureFilter.SWIPE_DOWN :  str = "Swipe Down";
                break;
            case SimpleGestureFilter.SWIPE_UP :    str = "Swipe Up";
                break;
        }

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

        // We only care about left swipe that intents to go to SubMenuActivity
        if (direction == SimpleGestureFilter.SWIPE_LEFT) {
            Intent intent = new Intent(this, SubMenuActivity.class);
            // putExtra params need to be set up correctly accordingly what we need to pass
            intent.putExtra("title", "menuItemName");
            intent.putExtra("tableNo", "tableNum");
            startActivity(intent);
        }
    }

    @Override
    public void onDoubleTap() {
        Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu_activity);


       tableNumView = (TextView) findViewById(R.id.table_num_view);

        loadMainMenuItems();

        gridview = (GridView) findViewById(R.id.menulist_right);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

      //  listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent listviewIntent = new Intent(MenuActivity.this, SubMenuActivity.class);

                Button listBtn  = (Button) parent.getChildAt(position).findViewById(R.id.mainmenu);
                menuItemName = listBtn.getText().toString();
                tableNum = getIntent().getExtras().getString("tableNo");
                listviewIntent.putExtra("title", menuItemName);
                listviewIntent.putExtra("tableNo", tableNum);
                startActivity(listviewIntent);

                Log.v("value ", "result is " + menuItemName);
            }
        });

        // Detect touched area
        detector = new SimpleGestureFilter(this,this);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        this.detector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }


    /*************************************************************************************
     * This function loads the data from the parse, where the class is
     * called "MenuParse". It uses MainMenuAdapter. And Listview to
     * display the data.
     **************************************************************************************/
    private void loadMainMenuItems() {
        final ParseQuery<MainMenuData> mainMenuItems = ParseQuery.getQuery("MenuParse");
        mainMenuItems.findInBackground(new FindCallback<MainMenuData>() {

            @Override
            public void done(List<MainMenuData> mainMenuItems, ParseException e) {
                mainMenuAdapter = new MainMenuAdapter(MenuActivity.this, mainMenuItems);
                gridview.setAdapter(mainMenuAdapter);

            }
        });
    }
}






//        final Button appetizerBtn = (Button)findViewById(R.id.haveItAll_button);
//        appetizerBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent haveItAllIntent = new Intent(MenuActivity.this,SubMenuActivity.class);
//
//                //pass title to next UI to show in a TextView
//                haveItAllIntent.putExtra("title", appetizerBtn.getText().toString());
//                startActivity(haveItAllIntent);
//
//            }
//        });
//
//        final Button saladsBtn = (Button)findViewById(R.id.salads_button);
//        saladsBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent appetizerIntent = new Intent(getApplicationContext(),SubMenuActivity.class);
//
//                //pass title to next UI to show in a TextView
//                appetizerIntent.putExtra("title", saladsBtn.getText().toString());
//                startActivity(appetizerIntent);
//            }
//        });
//
//        final Button burgersBtn = (Button) findViewById(R.id.burger_button);
//        burgersBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent burgerBtnIntent = new Intent(getApplicationContext(), SubMenuActivity.class);
//                burgerBtnIntent.putExtra("title", burgersBtn.getText().toString());
//                startActivity(burgerBtnIntent);
//            }
//        });
//
//// add all other buttons activity here.
//
//
//        final Button kidsMenuBtn = (Button)findViewById(R.id.kids_button);
//
//        kidsMenuBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               Intent kidsMenuIntent = new Intent(getApplicationContext(),SubMenuActivity.class);
//
//              //  Intent kidsMenuIntent = new Intent(MenuActivity.this,ListActivity.class);
//
//
//                kidsMenuIntent.putExtra("title", kidsMenuBtn.getText().toString());
//                startActivity(kidsMenuIntent);
//
//            }
//        });







        /**********************************************
         * if user clicks on the RoyalPlate_logo, it will
         * activate the SelectActivity.
         *************************************************/

        //     final ImageView  royalplate = (ImageView) findViewById(R.id.royalplate_logo);
//        royalplate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent royalplateIntent = new Intent(getApplicationContext(), SelectActivity.class);
//                startActivity(royalplateIntent);
//            }
//        });

//        drinksSpinner = (Spinner)findViewById(R.id.drinks_spinner);
//        ArrayAdapter<String> drinksAdapter = new ArrayAdapter<String>(MenuActivity.this,android.R.layout.simple_spinner_item,drinks);
//
//        drinksAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        drinksSpinner.setAdapter(drinksAdapter);
//
//        saladsSpinner = (Spinner)findViewById(R.id.salads_spinner);
//        ArrayAdapter<String>saladsAdapter = new ArrayAdapter<String>(MenuActivity.this,android.R.layout.simple_spinner_item,salads);
//
//        saladsAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        saladsSpinner.setAdapter(saladsAdapter);
//
//        desertsSpinner = (Spinner)findViewById(R.id.deserts_spinner);
//        ArrayAdapter<String>desertsAdapter = new ArrayAdapter<String>(MenuActivity.this,android.R.layout.simple_spinner_item,deserts);
//
//        desertsAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        drinksSpinner.setAdapter(desertsAdapter);

//        orderedButton = (Button)findViewById(R.id.orderbutton);
//        orderedButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent chefUI = new Intent(getApplicationContext(),ChefActivity.class );
//                startActivity(chefUI);

        // }
        //      });








