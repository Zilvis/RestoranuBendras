package com.example.reservationapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reservationapp.Entity.ClientEntity;
import com.example.reservationapp.R;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientHolder> {
    private List<ClientEntity> clientList;

    public ClientAdapter(List<ClientEntity> clientList) {
        this.clientList = clientList;
    }


    @NonNull
    @Override
    public ClientHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_client_item, parent, false);
        return new ClientHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientHolder holder, int position) {
        ClientEntity client = clientList.get(position);
        holder.name.setText(client.getName());
        holder.phone.setText(client.getPhone());
        holder.email.setText(client.getEmail());
    }

    @Override
    public int getItemCount() {
        return clientList.size();
    }
}
