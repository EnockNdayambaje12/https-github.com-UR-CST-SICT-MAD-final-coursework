package com.example.employee;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyViewHolder extends RecyclerView.ViewHolder {

    TextView textViewname,textViewemail,textViewphone,textViewdep,textViewdistrict;

    public MyViewHolder(@NonNull View itemView) {
        super (itemView);
    textViewname=itemView.findViewById(R.id.textViewname);
    textViewemail=itemView.findViewById(R.id.textViewemail);
    textViewphone=itemView.findViewById(R.id.textViewphone);
    textViewdep=itemView.findViewById(R.id.textViewdep);
    textViewdistrict=itemView.findViewById(R.id.textViewdistrict);


    }
}
