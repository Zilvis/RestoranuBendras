package com.Restoranu.Api.Restoranu.Api.Service;

import com.Restoranu.Api.Restoranu.Api.Entity.ClientsEntity;

import java.util.List;

public interface ClientService {

	ClientsEntity create(ClientsEntity client);
	List<ClientsEntity> getClients();
}
