package com.example.employee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity {

    EditText txtname, txtemail, txtphone, txtdep, txtdistrict, txtpassword;

    Button btnRegister;

    DatabaseReference reff;
    Employee employee;

    private FirebaseRecyclerOptions<model> options;
    private FirebaseRecyclerAdapter<model, MyViewHolder> adapter;

    private RecyclerView recyclerView;

//      DatabaseReference reference;

//    private FirebaseAuth mAuth;
//    private TextView register;
//    private EditText editTextname,editTextemail,editTextphone,editTextdep,editTextdistrict,editTextpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.register);


//        mAuth = FirebaseAuth.getInstance ();
//
//        register = (Button) findViewById (R.id.register);
//        register.setOnClickListener (this);

        txtname = (EditText) findViewById (R.id.name);
        txtemail = (EditText) findViewById (R.id.email);
        txtphone = (EditText) findViewById (R.id.phone);
        txtdep = (EditText) findViewById (R.id.dep);
        txtdistrict = (EditText) findViewById (R.id.district);
        txtpassword = (EditText) findViewById (R.id.password);
        btnRegister = (Button) findViewById (R.id.Register);
        employee = new Employee ( );
        reff = FirebaseDatabase.getInstance ( ).getReference ( ).child ("Employee");

        recyclerView = findViewById (R.id.recyclerView);
        recyclerView.setHasFixedSize (true);
        recyclerView.setLayoutManager (new LinearLayoutManager (this));


        btnRegister.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                employee.setName (txtname.getText ( ).toString ( ).trim ( ));
                employee.setEmail (txtemail.getText ( ).toString ( ).trim ( ));
                employee.setPhone (txtphone.getText ( ).toString ( ).trim ( ));
                employee.setDep (txtdep.getText ( ).toString ( ).trim ( ));
                employee.setDistrict (txtdistrict.getText ( ).toString ( ).trim ( ));
                employee.setPassword (txtpassword.getText ( ).toString ( ).trim ( ));
                reff.push ( ).setValue (employee);
                Toast.makeText (RegisterUser.this, "data inserted sucessfully", Toast.LENGTH_LONG).show ( );
            }
        });

//
//        changeProfileImage.setOnclickListener(v){
//            Intent i = new Intent (v.getContext(),editProfile.class);
//        }

           options=new FirebaseRecyclerOptions.Builder<model>().setQuery(reff,model.class).build();
           adapter=new FirebaseRecyclerAdapter<model, MyViewHolder> (options) {
               @Override
               protected void onBindViewHolder(@NonNull MyViewHolder holder, int i, @NonNull model model) {

                   holder.textViewname.setText(model.getName ());
                   holder.textViewemail.setText(model.getEmail ());
                   holder.textViewphone.setText(model.getPhone ());
                   holder.textViewdep.setText(model.getDep ());
                   holder.textViewdistrict.setText(model.getDistrict ());


               }

               @NonNull
               @Override
               public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                  View v= LayoutInflater.from(parent.getContext()).inflate (R.layout.single_view_layout,parent,false);
                   return new MyViewHolder (v);

               }
           };


           adapter.startListening ();
           recyclerView.setAdapter (adapter);

    }
}
//
//    @Override
//    public void onClick(View v) {
//      switch (v.getId ()){
//        case R.id.register:
//            register();
//            break;
//
//    }
//
//}
//
//    private void register() {
//        final String email = editTextemail.getText ().toString ().trim ();
//        String password = editTextpassword.getText ().toString ().trim ();
//        final String name = editTextname.getText ().toString ().trim ();
//        final String district = editTextdistrict.getText ().toString ().trim ();
//        final String dep = editTextdep.getText ().toString ().trim ();
//        final String phone = editTextphone.getText ().toString ().trim ();
//
//        mAuth.createUserWithEmailAndPassword (email,password).addOnCompleteListener (new OnCompleteListener<AuthResult> ( ) {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful ( )) {
//                            user User = new user (name, email, dep, district, phone);
//
//                            FirebaseDatabase.getInstance ( ).getReference ("users")
//                                    .child (FirebaseAuth.getInstance ( ).getCurrentUser ( ).getUid ( ))
//                                    .setValue (User).addOnCompleteListener (new OnCompleteListener<Void> ( ) {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if (task.isSuccessful ( )) {
//                                        Toast.makeText (RegisterUser.this, "user has been registered", Toast.LENGTH_LONG).show ( );
//                                    }
//                                }
//
//                            });
//
//
//                        }
//                    }
//
//        });
//    }






