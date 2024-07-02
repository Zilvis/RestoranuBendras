package com.example.reservationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reservationapp.Controller.ClientController;
import com.example.reservationapp.Entity.ClientEntity;
import com.example.reservationapp.Service.RetrofitService;
import com.example.reservationapp.adapter.ClientAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_client_list);

        recyclerView = findViewById(R.id.clientList_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton floatingActionButton = findViewById(R.id.clientList_fab);
        floatingActionButton.setOnClickListener(view ->{
            Intent intent = new Intent(this, ClientAddForm.class);
            startActivity(intent);
            loadClients();
        });

        loadClients();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void loadClients() {
        RetrofitService retrofitService = new RetrofitService();
        ClientController clientController = retrofitService.getRetrofit().create(ClientController.class);
        clientController.getAllClients()
                .enqueue(new Callback<List<ClientEntity>>() {
                    @Override
                    public void onResponse(Call<List<ClientEntity>> call, Response<List<ClientEntity>> response) {
                        populateListView(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<ClientEntity>> call, Throwable throwable) {
                        Toast.makeText(ClientListActivity.this, "Failed to load client list", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void populateListView(List<ClientEntity> clientList) {
        ClientAdapter clientAdapter = new ClientAdapter(clientList);
        recyclerView.setAdapter(clientAdapter);
    }
}



















