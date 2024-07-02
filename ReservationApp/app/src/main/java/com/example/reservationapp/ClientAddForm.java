package com.example.reservationapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.reservationapp.Controller.ClientController;
import com.example.reservationapp.Entity.ClientEntity;
import com.example.reservationapp.Service.RetrofitService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientAddForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        initializeComponents();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initializeComponents() {
        TextInputEditText inputEditTextName     = findViewById(R.id.form_textFieldName);
        TextInputEditText inputEditTextPhone    = findViewById(R.id.form_phoneNumber);
        TextInputEditText inputEditTextEmail    = findViewById(R.id.form_email);
        MaterialButton    saveButton            = findViewById(R.id.form_buttonSave);
        RetrofitService retrofitService         = new RetrofitService();
        ClientController clientController       = retrofitService.getRetrofit().create(ClientController.class);

        saveButton.setOnClickListener(view ->{
            String name     = String.valueOf(inputEditTextName.getText());
            String phone    = String.valueOf(inputEditTextPhone.getText());
            String email    = String.valueOf(inputEditTextEmail.getText());

            ClientEntity clientEntity = new ClientEntity(name, phone, email);
            clientController.create(clientEntity)
                    .enqueue(new Callback<ClientEntity>() {
                        @Override
                        public void onResponse(Call<ClientEntity> call, Response<ClientEntity> response) {
                            Toast.makeText(ClientAddForm.this, "Success!",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<ClientEntity> call, Throwable Throwable) {
                            Toast.makeText(ClientAddForm.this, "Failed!",Toast.LENGTH_SHORT).show();
                            Logger.getLogger(ClientAddForm.class.getName()).log(Level.SEVERE, "Error!");
                        }
                    });
        });
    }
}