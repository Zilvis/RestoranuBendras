package com.example.reservationapp.Controller;

import com.example.reservationapp.Entity.ClientEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ClientController {

    @GET("/api/clients")
    Call<List<ClientEntity>> getAllClients();

    @POST("/api/clients")
    Call<ClientEntity> create(@Body ClientEntity clientEntity);
}
