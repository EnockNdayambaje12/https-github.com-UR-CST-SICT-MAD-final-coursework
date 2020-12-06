package com.example.employee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

private var clickNum = 0
        private lateinit var textView : TextView
    privat lateinit var analytics : FirebaseAnalytics


    @Override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        setSupportActionBar(toolbar)
                textView = finfViewById<TextView>(R.id.myText)
                        analytics = FirebaseAnalytics.getInstance(this)

                        val upButton = finfViewById<Btton>(R.id.button)
                                upButton.setOnClickListener{ it: View!
                clickNum++
                        analytics.logEvent("button_clicked", null)
        }





//        Toolbar toolbar = findViewById (R.id.toolbar);
//        setSupportActionBar (toolbar);
//
//        FloatingActionButton fab = findViewById (R.id.fab);
//        fab.setOnClickListener (new View.OnClickListener ( ) {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make (view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction ("Action", null).show ( );
//            }
//        });
//
//
//
//        admin = (TextView) findViewById (R.id.admin);
//        admin.setOnClickListener (this);
//
//        EMPLOYEE = (TextView) findViewById (R.id.EMPLOYEE);
//        EMPLOYEE.setOnClickListener (this);

    }

    public void btn_RegisterUser(View view) {
        startActivity (new Intent (getApplicationContext (),RegisterUser.class));
    }

    public void btn_profile(View view) {
        startActivity (new Intent (getApplicationContext (),profile.class));
    }
}

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater ( ).inflate (R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId ( );
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected (item);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId ()){
//            case R.id.admin:
//                startActivity (new Intent (this, RegisterUser.class));
//                break;}
//
//            switch (v.getId ()){
//            case R.id.EMPLOYEE:
//                startActivity (new Intent (this, profile.class));
//                break;}
//
//
//    }
//}
