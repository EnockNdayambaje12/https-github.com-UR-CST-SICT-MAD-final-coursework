package com.example.employee;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class editProfile extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText profileName,profileEmail,profilePhone,profileDep,profileDistrict,profilePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_edit_profile);

        Intent data= getIntent ();

         String name= data.getStringExtra ("name");
         String email= data.getStringExtra ("email");
         String phone= data.getStringExtra ("phone");
         String dep= data.getStringExtra ("dep");
         String district= data.getStringExtra ("district");
         String password= data.getStringExtra ("password");

         profileName = findViewById (R.id.profileFullName);
         profileEmail= findViewById (R.id.profileEmailaddress);
         profilePhone= findViewById (R.id.profilePhoneNo);
         profileDep= findViewById (R.id.profileDep);
         profileDistrict= findViewById (R.id.profileDistrict);
         profilePassword= findViewById (R.id.profilePassword);


         profileName.setText(name);
         profileEmail.setText (email);
         profilePhone.setText (phone);
         profileDep.setText (dep);
         profileDistrict.setText (district);
         profilePassword.setText (password);

        Log.d (TAG, "on create"+ name +""+email+""+phone+""+dep+""+district+""+password);



    }
}
