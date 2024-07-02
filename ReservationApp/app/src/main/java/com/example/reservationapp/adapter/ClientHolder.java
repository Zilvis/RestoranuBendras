package com.example.reservationapp.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reservationapp.R;

public class ClientHolder extends RecyclerView.ViewHolder {
    TextView name, phone, email;

    public ClientHolder(@NonNull View itemView) {
        super(itemView);
        name  = itemView.findViewById(R.id.clientListItem_name);
        phone = itemView.findViewById(R.id.clientListItem_phone);
        email = itemView.findViewById(R.id.clientListItem_email);
    }
}
