package com.Restoranu.Api.Restoranu.Api.Service;

import com.Restoranu.Api.Restoranu.Api.Entity.ClientsEntity;
import com.Restoranu.Api.Restoranu.Api.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepository ClientRepository;

	@Override
	public ClientsEntity create(ClientsEntity client) {
		return ClientRepository.save(client);
	}

	@Override
	public List<ClientsEntity> getClients() {
		return (List<ClientsEntity>) ClientRepository.findAll();
	}
}
